package com.sangwool.boardproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/nestedComment")
public class NestedCommentController {

    // 댓글 작성
    @PostMapping
    public ResponseEntity<?> createNestedComment() {

        return null;
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<?> getNestedComment() {

        return null;
    }

    // 댓글 상세 조회
    @GetMapping("/{commentSeq}")
    public ResponseEntity<?> getDetailsNestedComment(@PathVariable String commentSeq) {

        return null;
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<?> updateNestedComment() {

        return null;
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteNestedComment() {

        return null;
    }
}
