package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.*;
import com.sangwool.boardproject.entity.Board;
import com.sangwool.boardproject.repository.BoardRepository;
import com.sangwool.boardproject.usecase.Delete;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final Delete delete;

    @Override
    public List<BoardDto> getBoards() {
        return boardRepository.findAll().stream().map(board -> BoardDto.buildDto(board, board.getBoardUpdateDate())).toList();
    }

    @Override
    public BoardDto getDetailsBoards(Long boardSeq) {

        try {
            Board board = boardRepository.findByBoardSeqNum(boardSeq);
            return BoardDto.buildDto(board, board.getBoardUpdateDate());
        } catch (NullPointerException e) {
            log.debug("NullPointerException = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public BoardDto createBoards(BoardUploadDto boardUploadDto) {

        try {

            Board board = boardRepository.save(boardUploadDto);
            return BoardDto.buildDto(board, board.getBoardUploadDate());
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public BoardDto updateBoards(BoardUpdateDto boardUpdateDto) {


        try {

            Board boardUpdate = boardRepository.updateBoard(boardUpdateDto);
            return BoardDto.buildDto(boardUpdate, boardUpdate.getBoardUpdateDate());
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteBoards(BoardDeleteDto boardDeleteDto) {

        Long boardSeq = boardDeleteDto.getBoardSeq();

        return delete.boardDelete(boardSeq);
    }
}
