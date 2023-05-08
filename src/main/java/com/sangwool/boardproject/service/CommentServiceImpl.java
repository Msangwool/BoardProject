package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.CommentDeleteDto;
import com.sangwool.boardproject.dto.CommentDto;
import com.sangwool.boardproject.dto.CommentUpdateDto;
import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.entity.Comment;
import com.sangwool.boardproject.entity.NestedComment;
import com.sangwool.boardproject.repository.CommentRepository;
import com.sangwool.boardproject.repository.NestedCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final NestedCommentRepository nestedCommentRepository;

    @Override
    public List<Map<String, String>> getAllComments() {
        return commentRepository.findAll().stream().map(CommentServiceImpl::makeMap).toList();
    }

    @Override
    public Map<String, String> getDetailsComment(Long commentSeq) {
        return makeMap(commentRepository.findByCommentSeqNum(commentSeq));
    }

    @Override
    public List<Map<String, String>> getCommentsByBoardSeq(Long boardSeq) {
        return commentRepository.findAllByBoardSeqNum(boardSeq).stream().map(CommentServiceImpl::makeMap).toList();
    }

    @Override
    public CommentDto createComments(CommentUploadDto commentUploadDto) {

        try {

            Comment comment = commentRepository.save(commentUploadDto);
            return CommentDto.buildDto(comment, comment.getCommentUpdateDate());
        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public CommentDto updateComments(CommentUpdateDto commentUpdateDto) {

        try {

            Comment commentUpdate = commentRepository.updateComment(commentUpdateDto);
            return CommentDto.buildDto(commentUpdate, commentUpdate.getCommentUpdateDate());
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteComments(CommentDeleteDto commentDeleteDto) {

        Long commentSeq = commentDeleteDto.getCommentSeq();

        try {
            // 해당 댓글의 대댓글 삭제
            List<NestedComment> nestedComments = nestedCommentRepository.findAllByCommentSeqNum(commentSeq);
            nestedComments.forEach(nestedComment -> nestedCommentRepository.deleteNestedComment(nestedComment.getNestedCommentSeq()));

            // 해당 댓글 삭제
            commentRepository.deleteComment(commentSeq);
            return true;
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return false;
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return false;
        }
    }

    private static Map<String, String> makeMap(Comment comment) {

        Map<String, String> map = new HashMap<>();

        map.put("boardSeq", comment.getBoardSeq().toString());
        map.put("userSeq", comment.getUserSeq().toString());
        map.put("commentContent", comment.getCommentContent());
        map.put("commentUpdateDate", comment.getCommentUpdateDate());

        return map;
    }
}