package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.NestedCommentDeleteDto;
import com.sangwool.boardproject.dto.NestedCommentDto;
import com.sangwool.boardproject.dto.NestedCommentUpdateDto;
import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.entity.NestedComment;
import com.sangwool.boardproject.repository.NestedCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class NestedCommentServiceImpl implements NestedCommentService {

    private final NestedCommentRepository nestedCommentRepository;

    @Override
    public List<NestedCommentDto> getAllNestedComments() {
        return nestedCommentRepository.findAll()
                .stream()
                .map(nestedComment -> NestedCommentDto.buildDto(nestedComment, nestedComment.getNestedCommentUpdateDate()))
                .toList();
    }

    @Override
    public NestedCommentDto getDetailsNestedComment(Long nestedCommentSeq) {

        try {
            NestedComment nestedComment = nestedCommentRepository.findByCommentSeqNum(nestedCommentSeq);
            return NestedCommentDto.buildDto(nestedComment, nestedComment.getNestedCommentUpdateDate());
        } catch (NullPointerException e) {
            log.debug("NullPointerException = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<NestedCommentDto> getNestedCommentsByCommentSeq(Long commentSeq) {
        return nestedCommentRepository.findAllByCommentSeqNum(commentSeq)
                .stream()
                .map(nestedComment -> NestedCommentDto.buildDto(nestedComment, nestedComment.getNestedCommentUpdateDate()))
                .toList();
    }

    @Override
    public NestedCommentDto createNestedComments(NestedCommentUploadDto nestedCommentUploadDto) {

        try {

            NestedComment nestedComment = nestedCommentRepository.save(nestedCommentUploadDto);
            return NestedCommentDto.buildDto(nestedComment, nestedComment.getNestedCommentUploadDate());
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public NestedCommentDto updateNestedComments(NestedCommentUpdateDto nestedCommentUpdateDto) {

        try {

            NestedComment nestedCommentUpdate = nestedCommentRepository.updateNestedComment(nestedCommentUpdateDto);
            return NestedCommentDto.buildDto(nestedCommentUpdate, nestedCommentUpdate.getNestedCommentUpdateDate());
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteNestedComments(NestedCommentDeleteDto nestedCommentDeleteDto) {

        Long nestedCommentSeq = nestedCommentDeleteDto.getNestedCommentSeq();

        try {
            nestedCommentRepository.deleteNestedComment(nestedCommentSeq);
            return true;
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return false;
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return false;
        }
    }
}
