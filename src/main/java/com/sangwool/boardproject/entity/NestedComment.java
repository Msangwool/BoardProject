package com.sangwool.boardproject.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NestedComment {

    private final Long nestedCommentSeq;                // 대댓글 Sequence 번호
    private final Long commentSeq;                      // 댓글 Sequence 번호
    private final Long userSeq;                         // 대댓글 작성자 Sequence 번호 (유저)
    private final String nestedCommentContent;          // 대댓글 내용
    private final String nestedCommentUploadDate;       // 대댓글 업로드 시간
    private final String nestedCommentUpdateDate;       // 대댓글 수정 시간

    @Builder
    public NestedComment(Long nestedCommentSeq, Long commentSeq, Long userSeq,
                         String nestedCommentContent, String nestedCommentUploadDate, String nestedCommentUpdateDate) {
        this.nestedCommentSeq = nestedCommentSeq;
        this.commentSeq = commentSeq;
        this.userSeq = userSeq;
        this.nestedCommentContent = nestedCommentContent;
        this.nestedCommentUploadDate = nestedCommentUploadDate;
        this.nestedCommentUpdateDate = nestedCommentUpdateDate;
    }
}
