package com.sangwool.boardproject.controller;

import com.sangwool.boardproject.dto.CommentDeleteDto;
import com.sangwool.boardproject.dto.CommentDto;
import com.sangwool.boardproject.dto.CommentUpdateDto;
import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentUploadDto commentUploadDto) {

        log.debug("[CommentController] createComment");
        Optional<CommentDto> commentDto = commentService.createComments(commentUploadDto);
        if (commentDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(commentDto.get());
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<?> getComments() {

        log.debug("[CommentController] getComments");
        return ResponseEntity.ok().body(commentService.getAllComments());
    }

    // 댓글 상세 조회
    @GetMapping("/{commentSeq}")
    public ResponseEntity<?> getDetailComment(@PathVariable Long commentSeq) {

        log.debug("[CommentController] getDetailComment");
        return ResponseEntity.ok().body(commentService.getDetailsComment(commentSeq));
    }

    @GetMapping("/boards/{boardSeq}")
    public ResponseEntity<?> getCommentsByBoardSeq(@PathVariable Long boardSeq) {

        log.debug("[CommentController] getCommentsByBoardSeq");
        return ResponseEntity.ok().body(commentService.getCommentsByBoardSeq(boardSeq));
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<?> updateComment(@RequestBody CommentUpdateDto commentUpdateDto) {

        log.debug("[CommentController] updateComment");
        Optional<CommentDto> commentDto = commentService.updateComments(commentUpdateDto);
        if (commentDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(commentDto.get());
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteComment(@RequestBody CommentDeleteDto commentDeleteDto) {

        log.debug("[CommentController] deleteComment");
        return ResponseEntity.ok().body(commentService.deleteComments(commentDeleteDto));
    }
}
