package com.sangwool.boardproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/comment")
public class CommentController {

    // 댓글 작성
    @PostMapping
    public ResponseEntity<?> createComment() {

        return null;
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<?> getComments() {

        return null;
    }

    // 댓글 상세 조회
    @GetMapping("/{boardSeq}")
    public ResponseEntity<?> getDetailComment(@PathVariable String boardSeq) {

        return null;
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<?> updateComment() {

        return null;
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteComment() {

        return null;
    }
}
