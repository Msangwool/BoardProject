package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.CommentUpdateDto;
import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.entity.Comment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
public class MemoryCommentRepository implements CommentRepository {

    private static final Map<Long, Comment> commentMap = new ConcurrentHashMap<>();
    private static Long seqNum = 0L;

    @Override
    public Comment save(CommentUploadDto commentUploadDto) {
        Long commentSeqNum = ++seqNum;

        Comment comment = Comment.builder()
                .commentSeq(commentSeqNum)
                .boardSeq(commentUploadDto.getBoardSeq())
                .userSeq(commentUploadDto.getUserSeq())
                .commentContent(commentUploadDto.getCommentContent())
                .commentUploadDate(new Date(System.currentTimeMillis()).toString())
                .commentUpdateDate(new Date(System.currentTimeMillis()).toString())
                .build();
        commentMap.put(commentSeqNum, comment);

        return comment;
    }

    @Override
    public Comment updateComment(CommentUpdateDto commentUpdateDto) {

        try {

            Long commentSeq = commentUpdateDto.getCommentSeq();
            Comment comment = commentMap.get(commentSeq);

            if (!comment.getUserSeq().equals(commentUpdateDto.getUserSeq())) {
                throw new IllegalArgumentException();
            }

            Comment commentUpdate = Comment.builder()
                    .commentSeq(commentSeq)
                    .boardSeq(comment.getBoardSeq())
                    .userSeq(commentUpdateDto.getUserSeq())
                    .commentContent(commentUpdateDto.getCommentContent())
                    .commentUploadDate(comment.getCommentUploadDate())
                    .commentUpdateDate(new Date(System.currentTimeMillis()).toString())
                    .build();
            commentMap.replace(commentSeq, commentUpdate);

            return commentUpdate;
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            log.debug("IllegalArgumentException = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public Comment findByCommentSeqNum(Long commentSeqNum) {
        return commentMap.get(commentSeqNum);
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(commentMap.values());
    }

    @Override
    public List<Comment> findAllByBoardSeqNum(Long boardSeq) {
        return commentMap.values().stream().filter(m -> m.getBoardSeq().equals(boardSeq)).toList();
    }

    @Override
    public void deleteComment(Long commentSeq) {

        try {
            commentMap.remove(commentSeq);
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException = {}", e.getMessage());
        }
    }
}
