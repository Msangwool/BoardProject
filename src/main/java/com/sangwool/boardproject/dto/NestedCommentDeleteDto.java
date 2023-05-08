package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NestedCommentDeleteDto {
    private Long nestedCommentSeq;                          // 대댓글 Sequence 번호

    @Builder
    public NestedCommentDeleteDto(Long nestedCommentSeq) {
        this.nestedCommentSeq = nestedCommentSeq;
    }
}
