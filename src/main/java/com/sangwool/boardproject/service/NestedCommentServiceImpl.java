package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.entity.NestedComment;
import com.sangwool.boardproject.repository.NestedCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class NestedCommentServiceImpl implements NestedCommentService {

    private final NestedCommentRepository nestedCommentRepository;

    @Override
    public List<Map<String, String>> getAllNestedComments() {
        return nestedCommentRepository.findAll().stream().map(NestedCommentServiceImpl::makeMap).toList();
    }

    @Override
    public Map<String, String> getDetailsNestedComment(Long nestedCommentSeq) {
        return makeMap(nestedCommentRepository.findByCommentSeqNum(nestedCommentSeq));
    }

    @Override
    public List<Map<String, String>> getNestedCommentsByCommentSeq(Long commentSeq) {
        return nestedCommentRepository.findAllByCommentSeqNum(commentSeq).stream().map(NestedCommentServiceImpl::makeMap).toList();
    }

    @Override
    public boolean createNestedComments(NestedCommentUploadDto nestedCommentUploadDto) {

        try {

            nestedCommentRepository.save(nestedCommentUploadDto);
            return true;

        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateNestedComments(NestedCommentUploadDto nestedCommentUploadDto) {
        return false;
    }

    @Override
    public boolean deleteNestedComments(Long nestedCommentSeq) {
        return false;
    }

    private static Map<String, String> makeMap(NestedComment nestedComment) {

        Map<String, String> map = new HashMap<>();

        map.put("commentSeq", nestedComment.getCommentSeq().toString());
        map.put("userSeq", nestedComment.getUserSeq().toString());
        map.put("nestedCommentContent", nestedComment.getNestedCommentContent());
        map.put("nestedCommentUpdateDate", nestedComment.getNestedCommentUpdateDate());

        return map;
    }
}
