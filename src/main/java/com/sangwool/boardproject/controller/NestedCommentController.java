package com.sangwool.boardproject.controller;

import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.service.NestedCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/nestedComments")
@RequiredArgsConstructor
public class NestedCommentController {

    private final NestedCommentService nestedCommentService;

    // 댓글 작성
    @PostMapping
    public ResponseEntity<?> createNestedComment(@RequestBody NestedCommentUploadDto nestedCommentUploadDto) {

        return ResponseEntity.ok().body(nestedCommentService.createNestedComments(nestedCommentUploadDto));
    }

    // 댓글 목록 조회
    @GetMapping
    public ResponseEntity<?> getNestedComment() {

        return ResponseEntity.ok().body(nestedCommentService.getAllNestedComments());
    }

    // 댓글 상세 조회
    @GetMapping("/{commentSeq}")
    public ResponseEntity<?> getDetailsNestedComment(@PathVariable Long commentSeq) {

        return ResponseEntity.ok().body(nestedCommentService.getDetailsNestedComment(commentSeq));
    }

    @GetMapping("/comments/{commentSeq}")
    public ResponseEntity<?> getNestedCommentsByCommentSeq(@PathVariable Long commentSeq) {

        return ResponseEntity.ok().body(nestedCommentService.getNestedCommentsByCommentSeq(commentSeq));
    }

    // 댓글 수정
    @PutMapping
    public ResponseEntity<?> updateNestedComment(@RequestBody NestedCommentUploadDto nestedCommentUploadDto) {

        return ResponseEntity.ok().body(nestedCommentService.updateNestedComments(nestedCommentUploadDto));
    }

    // 댓글 삭제
    @DeleteMapping
    public ResponseEntity<?> deleteNestedComment(@RequestBody Long nestedCommentSeq) {

        return ResponseEntity.ok().body(nestedCommentService.deleteNestedComments(nestedCommentSeq));
    }
}
