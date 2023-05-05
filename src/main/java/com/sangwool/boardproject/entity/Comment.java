package com.sangwool.boardproject.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Comment {

    private final Long commentSeq;              // 댓글 Sequence 번호
    private final Long boardSeq;                // 게시판 Sequence 번호
    private final Long userSeq;                 // 댓글 작성자 Sequence 번호 (유저)
    private final String commentContent;        // 댓글 내용
    private final String commentUploadDate;     // 댓글 업로드 시간
    private final String commentUpdateDate;     // 댓글 수정 시간

    @Builder
    public Comment(Long commentSeq, Long boardSeq, Long userSeq, String commentContent,
                   String commentUploadDate, String commentUpdateDate) {
        this.commentSeq = commentSeq;
        this.boardSeq = boardSeq;
        this.userSeq = userSeq;
        this.commentContent = commentContent;
        this.commentUploadDate = commentUploadDate;
        this.commentUpdateDate = commentUpdateDate;
    }
}
