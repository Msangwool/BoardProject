package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.CommentUploadDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Map<String, String> getAllComments() {
        return null;
    }

    @Override
    public Map<String, String> getDetailsComment(Long commentSeq) {
        return null;
    }

    @Override
    public Map<String, String> getCommentsByBoardSeq(Long boardSeq) {
        return null;
    }

    @Override
    public boolean createComments(CommentUploadDto commentUploadDto) {
        return false;
    }

    @Override
    public boolean updateComments(CommentUploadDto commentUploadDto) {
        return false;
    }

    @Override
    public boolean deleteComments(Long commentSeq) {
        return false;
    }
}