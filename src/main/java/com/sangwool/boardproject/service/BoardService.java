package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.BoardDeleteDto;
import com.sangwool.boardproject.dto.BoardDto;
import com.sangwool.boardproject.dto.BoardUpdateDto;
import com.sangwool.boardproject.dto.BoardUploadDto;

import java.util.List;

public interface BoardService {

    /**
     * getBoards - BoardService |
     * @return 게시글 목록을 반환한다.
     */
    List<BoardDto> getBoards(Long boardCategory);

    /**
     * getDetailsBoards - BoardService |
     * @param boardSeq 게시글 Sequence 번호를 받아온다.
     * @return 해당 게시글 내용을 Map 형태로 반환한다.
     */
    BoardDto getDetailsBoards(Long boardCategory, Long boardSeq);

    /**
     * createBoards - BoardService |
     * 게시글을 생성한다.
     * @param boardUploadDto 게시글 생성에 필요한 게시글 정보를 받아온다.
     * @return Client 에게 제공할 게시판 내용을 반환한다.
     */
    BoardDto createBoards(BoardUploadDto boardUploadDto);

    /**
     * updateBoards - BoardService |
     * 게시글을 수정한다.
     * @param boardUpdateDto 업데이트에 필요한 게시글 정보를 받아온다.
     * @return Client 에게 제공할 게시판 내용을 반환한다.
     */
    BoardDto updateBoards(BoardUpdateDto boardUpdateDto);

    /**
     * deleteBoards - BoardService |
     * 게시판을 삭제한다. 해당 게시판으로 작성된 모든 댓글도 삭제한다.
     * @param boardDeleteDto 게시글 삭제에 필요한 DTO 정보를 받아온다.
     * @return 게시글 삭제의 성공 여부를 반환한다.
     */
    boolean deleteBoards(BoardDeleteDto boardDeleteDto);
}
