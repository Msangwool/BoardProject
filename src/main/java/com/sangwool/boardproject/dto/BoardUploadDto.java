package com.sangwool.boardproject.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardUploadDto {

    private final String boardTitle;            // 게시글 제목
    private final Long userSeq;                 // 게시글 작성자
    private final String boardContent;          // 게시글 내용
    private final String boardCategory;         // 게시글 종류

    @Builder
    public BoardUploadDto(String boardTitle, Long userSeq, String boardContent, String boardCategory) {
        this.boardTitle = boardTitle;
        this.userSeq = userSeq;
        this.boardContent = boardContent;
        this.boardCategory = boardCategory;
    }
}
