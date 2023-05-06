package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.BoardUploadDto;

import java.util.List;
import java.util.Map;

public interface BoardService {

    /**
     * getBoards - BoardService |
     * @return 게시글 목록을 반환한다.
     */
    List<Map<String, String>> getBoards();

    /**
     * getDetailsBoards - BoardService |
     * @param boardSeq 게시글 Sequence 번호를 받아온다.
     * @return 해당 게시글 내용을 Map 형태로 반환한다.
     */
    Map<String, String> getDetailsBoards(Long boardSeq);

    /**
     * createBoards - BoardService |
     * 게시글을 생성한다.
     * @param boardUploadDto 게시글 생성에 필요한 게시글 정보를 받아온다.
     * @return 게시글 생성의 성공 여부를 반환한다.
     */
    boolean createBoards(BoardUploadDto boardUploadDto);

    /**
     * updateBoards - BoardService |
     * @param boardUploadDto 업데이트에 필요한 게시글 정보를 받아온다.
     * @return 게시글 업데이트의 성공 여부를 반환한다.
     */
    boolean updateBoards(BoardUploadDto boardUploadDto);

    /**
     * deleteBoards - BoardService |
     * @param boardSeq 게시글 Sequence 번호를 받아온다.
     * @return 게시글 삭제의 성공 여부를 반환한다.
     */
    boolean deleteBoards(Long boardSeq);
}
