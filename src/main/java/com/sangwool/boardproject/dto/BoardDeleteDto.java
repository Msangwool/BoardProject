package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardDeleteDto {
    private Long boardSeq;                      // 게시글 Sequence 번호
    private Long userSeq;                       // 유저 Sequence 번호

    @Builder
    public BoardDeleteDto(Long boardSeq, Long userSeq) {
        this.boardSeq = boardSeq;
        this.userSeq = userSeq;
    }
}
