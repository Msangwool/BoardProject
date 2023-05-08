package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateDto {

    private final Long commentSeq;              // 댓글 Sequence 번호
    private final Long userSeq;                 // 댓글 작성자 Sequence 번호 (유저)
    private final String commentContent;        // 댓글 내용

    @Builder
    public CommentUpdateDto(Long commentSeq, Long userSeq, String commentContent) {
        this.commentSeq = commentSeq;
        this.userSeq = userSeq;
        this.commentContent = commentContent;
    }
}
