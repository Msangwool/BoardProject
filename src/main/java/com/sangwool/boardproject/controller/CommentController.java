package com.sangwool.boardproject.controller;

import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 댓글 작성
    @PostMapping
    public ResponseEntity<?> createComment(@RequestBody CommentUploadDto commentUploadDto) {

        return ResponseEntity.ok().body(commentService.createComments(commentUploadDto));
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<?> getComments() {

        return ResponseEntity.ok().body(commentService.getAllComments());
    }

    // 댓글 상세 조회
    @GetMapping("/{commentSeq}")
    public ResponseEntity<?> getDetailComment(@PathVariable Long commentSeq) {

        return ResponseEntity.ok().body(commentService.getDetailsComment(commentSeq));
    }

    @GetMapping("/boards/{boardSeq}")
    public ResponseEntity<?> getCommentsByBoardSeq(@PathVariable Long boardSeq) {

        return ResponseEntity.ok().body(commentService.getCommentsByBoardSeq(boardSeq));
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<?> updateComment(@RequestBody CommentUploadDto commentUploadDto) {

        return ResponseEntity.ok().body(commentService.updateComments(commentUploadDto));
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteComment(@RequestBody Long commentSeq) {

        return ResponseEntity.ok().body(commentService.deleteComments(commentSeq));
    }
}
