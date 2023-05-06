package com.sangwool.boardproject.controller;

import com.sangwool.boardproject.dto.BoardUploadDto;
import com.sangwool.boardproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    // 게시글 작성
    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardUploadDto boardUploadDto) {

        return ResponseEntity.ok().body(boardService.createBoards(boardUploadDto));
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity<?> getBoards() {

        return ResponseEntity.ok().body(boardService.getBoards());
    }

    // 게시글 상세 조회
    @GetMapping("/{boardSeq}")
    public ResponseEntity<?> getDetailsBoard(@PathVariable Long boardSeq) {

        return ResponseEntity.ok().body(boardService.getDetailsBoards(boardSeq));
    }

    // 게시글 수정
    @PutMapping
    public ResponseEntity<?> updateBoard(@RequestBody BoardUploadDto boardUploadDto) {

        return ResponseEntity.ok().body(boardService.updateBoards(boardUploadDto));
    }

    // 게시글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteBoard(@RequestBody Long boardSeq) {

        return ResponseEntity.ok().body(boardService.deleteBoards(boardSeq));
    }
}
