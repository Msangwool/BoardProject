package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.CommentDeleteDto;
import com.sangwool.boardproject.dto.CommentDto;
import com.sangwool.boardproject.dto.CommentUpdateDto;
import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.entity.Comment;
import com.sangwool.boardproject.repository.CommentRepository;
import com.sangwool.boardproject.usecase.Delete;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final Delete delete;

    @Override
    public List<CommentDto> getAllComments() {

        return commentRepository.findAll()
                .stream().map(comment -> CommentDto.buildDto(comment, comment.getCommentUpdateDate()))
                .toList();
    }

    @Override
    public CommentDto getDetailsComment(Long commentSeq) {

        try {
            Comment comment = commentRepository.findByCommentSeqNum(commentSeq);

            return CommentDto.buildDto(comment, comment.getCommentUpdateDate());
        } catch (NullPointerException e) {
            log.debug("NullPointerException = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<CommentDto> getCommentsByBoardSeq(Long boardSeq) {
        return commentRepository.findAllByBoardSeqNum(boardSeq)
                .stream().map(comment -> CommentDto.buildDto(comment, comment.getCommentUpdateDate()))
                .toList();
    }

    @Override
    public CommentDto createComments(CommentUploadDto commentUploadDto) {

        try {

            Comment comment = commentRepository.save(commentUploadDto);
            return CommentDto.buildDto(comment, comment.getCommentUpdateDate());
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
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

        return delete.commentDelete(commentSeq);
    }
}