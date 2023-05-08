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

    @Builder
    public CommentDeleteDto(Long commentSeq) {
        this.commentSeq = commentSeq;
    }
}
