package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.NestedCommentUpdateDto;
import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.entity.NestedComment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
public class MemoryNestedCommentRepository implements NestedCommentRepository {

    private static final Map<Long, NestedComment> nestedCommentMap = new ConcurrentHashMap<>();
    private static Long seqNum = 0L;

    @Override
    public NestedComment save(NestedCommentUploadDto nestedCommentUploadDto) {
        Long nestedCommentSeqNum = ++seqNum;

        NestedComment nestedComment = NestedComment.builder()
                .nestedCommentSeq(nestedCommentSeqNum)
                .commentSeq(nestedCommentUploadDto.getCommentSeq())
                .userSeq(nestedCommentUploadDto.getUserSeq())
                .nestedCommentContent(nestedCommentUploadDto.getNestedCommentContent())
                .nestedCommentUploadDate(new Date(System.currentTimeMillis()).toString())
                .nestedCommentUpdateDate(new Date(System.currentTimeMillis()).toString())
                .build();
        nestedCommentMap.put(nestedCommentSeqNum, nestedComment);

        return nestedComment;
    }

    @Override
    public NestedComment updateNestedComment(NestedCommentUpdateDto nestedCommentUpdateDto) {
        try {

            Long nestedCommentSeq = nestedCommentUpdateDto.getNestedCommentSeq();
            NestedComment nestedComment = nestedCommentMap.get(nestedCommentSeq);

            if (!nestedComment.getUserSeq().equals(nestedCommentUpdateDto.getUserSeq())) {
                throw new IllegalArgumentException();
            }

            NestedComment nestedCommentUpdate = NestedComment.builder()
                    .nestedCommentSeq(nestedCommentSeq)
                    .commentSeq(nestedComment.getCommentSeq())
                    .userSeq(nestedCommentUpdateDto.getUserSeq())
                    .nestedCommentContent(nestedCommentUpdateDto.getNestedCommentContent())
                    .nestedCommentUploadDate(nestedComment.getNestedCommentUploadDate())
                    .nestedCommentUpdateDate(new Date(System.currentTimeMillis()).toString())
                    .build();
            nestedCommentMap.replace(nestedCommentSeq, nestedCommentUpdate);

            return nestedCommentUpdate;
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            log.debug("IllegalArgumentException = {}", e.getMessage());
            return null;
        }
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

    @Override
    public void deleteNestedComment(Long nestedComment) {

        try {
            nestedCommentMap.remove(nestedComment);
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
        }
    }
}
