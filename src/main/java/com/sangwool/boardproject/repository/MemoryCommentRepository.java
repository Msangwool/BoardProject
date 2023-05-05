package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryCommentRepository implements CommentRepository {

    private static final Map<Long, Comment> commentMap = new ConcurrentHashMap<>();
    private static Long seqNum = 0L;

    @Override
    public void save(CommentUploadDto commentUploadDto) {
        Long commentSeqNum = ++seqNum;

        commentMap.put(commentSeqNum, Comment.builder()
                .commentSeq(commentSeqNum)
                .boardSeq(commentUploadDto.getBoardSeq())
                .userSeq(commentUploadDto.getUserSeq())
                .commentContent(commentUploadDto.getCommentContent())
                .commentUploadDate(new Date(System.currentTimeMillis()).toString())
                .build());
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
}
