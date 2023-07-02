package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDeleteDto {

    private Long commentSeq;                            // 댓글 Sequence 번호
    private Long userSeq;                                   // 유저 Sequence 번호

    @Builder
    public CommentDeleteDto(Long commentSeq, Long userSeq) {
        this.commentSeq = commentSeq;
        this.userSeq = userSeq;
    }

    public static CommentDeleteDto buildDto(Long commentSeq, Long userSeq) {
        return CommentDeleteDto.builder()
                .commentSeq(commentSeq)
                .userSeq(userSeq)
                .build();
    }
}
