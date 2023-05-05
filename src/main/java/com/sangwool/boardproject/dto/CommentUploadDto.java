package com.sangwool.boardproject.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUploadDto {

    private final Long boardSeq;                // 게시판 Sequence 번호
    private final Long userSeq;                 // 댓글 작성자 Sequence 번호 (유저)
    private final String commentContent;        // 댓글 내용

    @Builder
    public CommentUploadDto(Long boardSeq, Long userSeq, String commentContent) {
        this.boardSeq = boardSeq;
        this.userSeq = userSeq;
        this.commentContent = commentContent;
    }
}
