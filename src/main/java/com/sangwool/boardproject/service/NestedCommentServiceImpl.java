package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.NestedCommentUploadDto;

import java.util.Map;

public class NestedCommentServiceImpl implements NestedCommentService {

    @Override
    public Map<String, String> getAllNestedComments() {
        return null;
    }

    @Override
    public Map<String, String> getDetailsNestedComment(Long nestedCommentSeq) {
        return null;
    }

    @Override
    public Map<String, String> getNestedCommentsByCommentSeq(Long commentSeq) {
        return null;
    }

    @Override
    public boolean createNestedComments(NestedCommentUploadDto nestedCommentUploadDto) {
        return false;
    }

    @Override
    public boolean updateNestedComments(NestedCommentUploadDto nestedCommentUploadDto) {
        return false;
    }

    @Override
    public boolean deleteNestedComments(Long nestedCommentSeq) {
        return false;
    }
}
