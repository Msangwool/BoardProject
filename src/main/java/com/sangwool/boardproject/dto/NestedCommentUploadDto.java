package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NestedCommentUploadDto {

    private final Long commentSeq;                      // 댓글 Sequence 번호
    private final Long userSeq;                         // 대댓글 작성자 Sequence 번호 (유저)
    private final String nestedCommentContent;          // 대댓글 내용

    @Builder
    public NestedCommentUploadDto(Long commentSeq, Long userSeq, String nestedCommentContent) {
        this.commentSeq = commentSeq;
        this.userSeq = userSeq;
        this.nestedCommentContent = nestedCommentContent;
    }
}
