package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.entity.NestedComment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryNestedCommentRepository implements NestedCommentRepository {

    private static final Map<Long, NestedComment> nestedCommentMap = new ConcurrentHashMap<>();
    private static Long seqNum = 0L;

    @Override
    public void save(NestedCommentUploadDto nestedCommentUploadDto) {
        Long nestedCommentSeqNum = ++seqNum;

        nestedCommentMap.put(nestedCommentSeqNum, NestedComment.builder()
                .nestedCommentSeq(nestedCommentSeqNum)
                .commentSeq(nestedCommentUploadDto.getCommentSeq())
                .userSeq(nestedCommentUploadDto.getUserSeq())
                .nestedCommentContent(nestedCommentUploadDto.getNestedCommentContent())
                .nestedCommentUploadDate(new Date(System.currentTimeMillis()).toString())
                .nestedCommentUpdateDate(new Date(System.currentTimeMillis()).toString())
                .build());
    }

    @Override
    public NestedComment findByCommentSeqNum(Long commentSeqNum) {
        return nestedCommentMap.get(commentSeqNum);
    }

    @Override
    public List<NestedComment> findAll() {
        return new ArrayList<>(nestedCommentMap.values());
    }

    @Override
    public List<NestedComment> findAllByCommentSeqNum(Long commentSeq) {
        return nestedCommentMap.values().stream().filter(m -> m.getCommentSeq().equals(commentSeq)).toList();
    }
}
