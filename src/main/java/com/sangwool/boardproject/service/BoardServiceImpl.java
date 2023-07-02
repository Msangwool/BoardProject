package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.*;
import com.sangwool.boardproject.entity.Board;
import com.sangwool.boardproject.repository.BoardRepository;
import com.sangwool.boardproject.usecase.DeleteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final DeleteService deleteService;

    @Override
    public List<BoardDto> getBoards(String boardCategory) {
        return boardRepository.findAll().stream()
                .filter(board -> board.getBoardCategory().equals(boardCategory))
                .map(board -> BoardDto.buildDto(board, board.getBoardUpdateDate())).toList();
    }

    @Override
    public BoardDto getDetailsBoards(String boardCategory, Long boardSeq) {

        try {
            Board board = boardRepository.findByBoardSeqNum(boardSeq);
            if (!board.getBoardCategory().equals(boardCategory)) {
                return null;
            }
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

        return deleteService.boardDelete(boardDeleteDto);
    }
}
