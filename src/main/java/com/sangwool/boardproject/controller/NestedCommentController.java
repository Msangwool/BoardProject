package com.sangwool.boardproject.controller;

import com.sangwool.boardproject.dto.NestedCommentDeleteDto;
import com.sangwool.boardproject.dto.NestedCommentDto;
import com.sangwool.boardproject.dto.NestedCommentUpdateDto;
import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.service.NestedCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/v1/nestedComments")
@RequiredArgsConstructor
@Slf4j
public class NestedCommentController {

    private final NestedCommentService nestedCommentService;

    // 댓글 작성
    @PostMapping
    public ResponseEntity<?> createNestedComment(@RequestBody NestedCommentUploadDto nestedCommentUploadDto) {

        log.debug("[NestedCommentController] createNestedComment");
        Optional<NestedCommentDto> nestedCommentDto = nestedCommentService.createNestedComments(nestedCommentUploadDto);
        if (nestedCommentDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(nestedCommentDto.get());
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<?> getNestedComment() {

        log.debug("[NestedCommentController] getNestedComment");
        return ResponseEntity.ok().body(nestedCommentService.getAllNestedComments());
    }

    // 댓글 상세 조회
    @GetMapping("/{commentSeq}")
    public ResponseEntity<?> getDetailsNestedComment(@PathVariable Long commentSeq) {

        log.debug("[NestedCommentController] getDetailsNestedComment");
        return ResponseEntity.ok().body(nestedCommentService.getDetailsNestedComment(commentSeq));
    }

    @GetMapping("/comments/{commentSeq}")
    public ResponseEntity<?> getNestedCommentsByCommentSeq(@PathVariable Long commentSeq) {

        log.debug("[NestedCommentController] getNestedCommentsByCommentSeq");
        return ResponseEntity.ok().body(nestedCommentService.getNestedCommentsByCommentSeq(commentSeq));
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<?> updateNestedComment(@RequestBody NestedCommentUpdateDto nestedCommentUpdateDto) {

        log.debug("[NestedCommentController] updateNestedComment");
        Optional<NestedCommentDto> nestedCommentDto = nestedCommentService.updateNestedComments(nestedCommentUpdateDto);
        if (nestedCommentDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.ok().body(nestedCommentDto.get());
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteNestedComment(@RequestBody NestedCommentDeleteDto nestedCommentDeleteDto) {

        log.debug("[NestedCommentController] deleteNestedComment");
        return ResponseEntity.ok().body(nestedCommentService.deleteNestedComments(nestedCommentDeleteDto));
    }
}
