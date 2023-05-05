package com.sangwool.boardproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/boards")
public class BoardController {

    // 게시글 작성
    @PostMapping
    public ResponseEntity<?> createBoard() {

        return null;
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity<?> getBoards() {

        return null;
    }

    // 게시글 상세 조회
    @GetMapping("/{userSeq}")
    public ResponseEntity<?> getDetailsBoard(@PathVariable String userSeq) {

        return null;
    }

    // 게시글 수정
    @PutMapping
    public ResponseEntity<?> updateBoard() {

        return null;
    }

    // 게시글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteBoard() {

        return null;
    }
}
