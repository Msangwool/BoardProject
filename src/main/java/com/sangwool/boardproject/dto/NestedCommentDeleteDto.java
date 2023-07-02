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
    private Long userSeq;                                   // 유저 Sequence 번호

    @Builder
    public NestedCommentDeleteDto(Long nestedCommentSeq, Long userSeq) {
        this.nestedCommentSeq = nestedCommentSeq;
        this.userSeq = userSeq;
    }

    public static NestedCommentDeleteDto buildDto(Long nestedCommentSeq, Long userSeq) {
        return NestedCommentDeleteDto.builder()
                .nestedCommentSeq(nestedCommentSeq)
                .userSeq(userSeq)
                .build();
    }
}
