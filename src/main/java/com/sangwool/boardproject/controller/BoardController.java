package com.sangwool.boardproject.controller;

import com.sangwool.boardproject.dto.BoardDeleteDto;
import com.sangwool.boardproject.dto.BoardUpdateDto;
import com.sangwool.boardproject.dto.BoardUploadDto;
import com.sangwool.boardproject.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/boards")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    // 게시글 작성
    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardUploadDto boardUploadDto) {

        log.debug("[BoardController] createBoard");
        return ResponseEntity.ok().body(boardService.createBoards(boardUploadDto));
    }

    // 게시글 목록 조회
    @GetMapping
    public ResponseEntity<?> getBoards() {

        log.debug("[BoardController] getBoards");
        return ResponseEntity.ok().body(boardService.getBoards());
    }

    // 게시글 상세 조회
    @GetMapping("/{boardSeq}")
    public ResponseEntity<?> getDetailsBoard(@PathVariable Long boardSeq) {

        log.debug("[BoardController] getDetailsBoard");
        return ResponseEntity.ok().body(boardService.getDetailsBoards(boardSeq));
    }

    // 게시글 수정
    @PutMapping
    public ResponseEntity<?> updateBoard(@RequestBody BoardUpdateDto boardUpdateDto) {

        log.debug("[BoardController] updateBoard");
        return ResponseEntity.ok().body(boardService.updateBoards(boardUpdateDto));
    }

    // 게시글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteBoard(@RequestBody BoardDeleteDto boardDeleteDto) {

        log.debug("[BoardController] deleteBoard");
        return ResponseEntity.ok().body(boardService.deleteBoards(boardDeleteDto));
    }
}
