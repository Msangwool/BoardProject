package com.sangwool.boardproject.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Board {

    private final Long boardSeq;                // 게시글 Sequence 번호
    private final String boardTitle;            // 게시글 제목
    private final Long userSeq;                 // 게시글 작성자
    private final String boardContent;          // 게시글 내용
    private final String boardUploadDate;       // 게시글 작성시간
    private final String boardUpdateDate;       // 게시글 수정시간
    private final Long boardCategory;         // 게시글 종류

    @Builder
    public Board(Long boardSeq, String boardTitle, Long userSeq,
                 String boardContent, String boardUploadDate, String boardUpdateDate, Long boardCategory) {
        this.boardSeq = boardSeq;
        this.boardTitle = boardTitle;
        this.userSeq = userSeq;
        this.boardContent = boardContent;
        this.boardUploadDate = boardUploadDate;
        this.boardUpdateDate = boardUpdateDate;
        this.boardCategory = boardCategory;
    }
}
