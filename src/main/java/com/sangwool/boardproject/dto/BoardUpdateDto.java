package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUpdateDto {

    private final Long boardSeq;                // 게시글 Sequence 번호
    private final String boardTitle;            // 게시글 제목
    private final Long userSeq;                 // 게시글 작성자
    private final String boardContent;          // 게시글 내용
    private final Long boardCategory;         // 게시글 종류

    @Builder
    public BoardUpdateDto(Long boardSeq, String boardTitle, Long userSeq, String boardContent, Long boardCategory) {
        this.boardSeq = boardSeq;
        this.boardTitle = boardTitle;
        this.userSeq = userSeq;
        this.boardContent = boardContent;
        this.boardCategory = boardCategory;
    }
}
