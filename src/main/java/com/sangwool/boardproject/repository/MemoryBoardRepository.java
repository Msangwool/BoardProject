package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.BoardUpdateDto;
import com.sangwool.boardproject.dto.BoardUploadDto;
import com.sangwool.boardproject.entity.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Slf4j
public class MemoryBoardRepository implements BoardRepository {

    private static final Map<Long, Board> boardMap = new ConcurrentHashMap<>();
    private static Long seqNum = 0L;

    @Override
    public Board save(BoardUploadDto boardUploadDto) {
        Long boardSeqNum = ++seqNum;

        Board board = Board.builder()
                .boardSeq(boardSeqNum)
                .boardTitle(boardUploadDto.getBoardTitle())
                .userSeq(boardUploadDto.getUserSeq())
                .boardContent(boardUploadDto.getBoardContent())
                .boardUploadDate(new Date(System.currentTimeMillis()).toString())
                .boardUpdateDate(new Date(System.currentTimeMillis()).toString())
                .boardCategory(boardUploadDto.getBoardCategory())
                .build();
        boardMap.put(boardSeqNum, board);

        return board;
    }

    @Override
    public Board findByBoardSeqNum(Long boardSeqNum) {
        return boardMap.get(boardSeqNum);
    }

    @Override
    public List<Board> findAll() {
        return new ArrayList<>(boardMap.values());
    }

    @Override
    public List<Board> findAllByUserSeq(Long userSeq) {
        return boardMap.values().stream().filter(m -> m.getUserSeq().equals(userSeq)).toList();
    }

    @Override
    public Board updateBoard(BoardUpdateDto boardUpdateDto) {

        try {

            Long boardSeq = boardUpdateDto.getBoardSeq();
            Board board = boardMap.get(boardSeq);

            if (!board.getUserSeq().equals(boardUpdateDto.getUserSeq())) {
                throw new IllegalArgumentException();
            }

            Board boardUpdate = Board.builder()
                    .boardSeq(board.getBoardSeq())
                    .boardTitle(boardUpdateDto.getBoardTitle())
                    .userSeq(boardUpdateDto.getUserSeq())
                    .boardContent(boardUpdateDto.getBoardContent())
                    .boardUploadDate(board.getBoardUploadDate())
                    .boardUpdateDate(new Date(System.currentTimeMillis()).toString())
                    .boardCategory(boardUpdateDto.getBoardCategory())
                    .build();
            boardMap.replace(boardSeq, boardUpdate);

            return boardUpdate;
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            log.debug("IllegalArgumentException = {}", e.getMessage());
            return null;
        }
    }

    public void deleteBoard(Long boardSeq) {

        try {
            boardMap.remove(boardSeq);
        } catch (NoSuchElementException e) {
            log.info("NoSuchElementException = {}", e.getMessage());
        }
    }
}
