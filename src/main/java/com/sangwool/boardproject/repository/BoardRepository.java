package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.BoardUploadDto;
import com.sangwool.boardproject.entity.Board;

import java.util.List;

public interface BoardRepository {

    /**
     * save - BoardRepository |
     * 게시판 업로드 DTO 를 바탕으로 게시판 정보를 DB에 저장한다.
     * @param boardUploadDto 게시판 업로드 DTO 를 받아온다.
     */
    void save(BoardUploadDto boardUploadDto);

    /**
     * findByBoardSeqNum - BoardRepository |
     * 게시판 Sequence 번호를 통해 해당 게시판을 찾는다.
     * @param boardSeqNum 게시판 Sequence 번호를 받아온다.
     * @return 찾은 게시판 정보를 반환한다.
     */
    Board findByBoardSeqNum(Long boardSeqNum);

    /**
     * findAll - BoardRepository |
     * @return 모든 게시판을 찾아서 반환한다.
     */
    List<Board> findAll();

    /**
     * findAllByUserSeq - BoardRepository |
     * 요청한 유저가 작성한 모든 게시판을 찾는다.
     * @param userSeq 유저의 Sequence 번호를 받아온다.
     * @return 요청한 유저가 작성한 모든 게시판 정보를 반환한다.
     */
    List<Board> findAllByUserSeq(Long userSeq);
}
