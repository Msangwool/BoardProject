package com.sangwool.boardproject.dto;

import com.sangwool.boardproject.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private final Long commentSeq;              // 댓글 Sequence 번호
    private final Long boardSeq;                // 게시판 Sequence 번호
    private final Long userSeq;                 // 댓글 작성자 Sequence 번호 (유저)
    private final String commentContent;        // 댓글 내용
    private final String commentDate;             // 등록 or 수정 시간

    @Builder
    public CommentDto(Long commentSeq, Long boardSeq, Long userSeq, String commentContent, String commentDate) {
        this.commentSeq = commentSeq;
        this.boardSeq = boardSeq;
        this.userSeq = userSeq;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }

    public static CommentDto buildDto(Comment comment, String date) {
        return CommentDto.builder()
                .commentSeq(comment.getCommentSeq())
                .boardSeq(comment.getBoardSeq())
                .userSeq(comment.getUserSeq())
                .commentContent(comment.getCommentContent())
                .commentDate(date)
                .build();
    }
}
