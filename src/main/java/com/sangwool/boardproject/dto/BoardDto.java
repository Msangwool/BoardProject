package com.sangwool.boardproject.dto;

import com.sangwool.boardproject.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {
    private final Long boardSeq;                // 게시글 Sequence 번호
    private final String boardTitle;            // 게시글 제목
    private final Long userSeq;                 // 게시글 작성자
    private final String boardContent;          // 게시글 내용
    private final String boardDate;             // 등록 or 수정 시간
    private final Long boardCategory;         // 게시판 종류

    @Builder
    public BoardDto(Long boardSeq, String boardTitle, Long userSeq, String boardContent, String boardDate, Long boardCategory) {
        this.boardSeq = boardSeq;
        this.boardTitle = boardTitle;
        this.userSeq = userSeq;
        this.boardContent = boardContent;
        this.boardDate = boardDate;
        this.boardCategory = boardCategory;
    }

    public static BoardDto buildDto(Board board, String date) {
        return BoardDto.builder()
                .boardSeq(board.getBoardSeq())
                .boardTitle(board.getBoardTitle())
                .userSeq(board.getUserSeq())
                .boardContent(board.getBoardContent())
                .boardDate(date)
                .boardCategory(board.getBoardCategory())
                .build();
    }
}
