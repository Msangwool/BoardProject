package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.entity.Comment;
import com.sangwool.boardproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

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
    public boolean createComments(CommentUploadDto commentUploadDto) {

        try {

            commentRepository.save(commentUploadDto);
            return true;

        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateComments(CommentUploadDto commentUploadDto) {
        return false;
    }

    @Override
    public boolean deleteComments(Long commentSeq) {
        return false;
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