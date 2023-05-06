package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.BoardUploadDto;
import com.sangwool.boardproject.entity.Board;
import com.sangwool.boardproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<Map<String, String>> getBoards() {

        return boardRepository.findAll().stream().map(BoardServiceImpl::makeMap).toList();
    }

    @Override
    public Map<String, String> getDetailsBoards(Long boardSeq) {

        return makeMap(boardRepository.findByBoardSeqNum(boardSeq));
    }

    @Override
    public boolean createBoards(BoardUploadDto boardUploadDto) {

        try {

            boardRepository.save(boardUploadDto);
            return true;

        } catch (Exception e) {
            log.info("Exception = {}", e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateBoards(BoardUploadDto boardUploadDto) {

        return false;
    }

    @Override
    public boolean deleteBoards(Long boardSeq) {

        return false;
    }

    private static Map<String, String> makeMap(Board board) {

        Map<String, String> map = new HashMap<>();

        map.put("boardTitle", board.getBoardTitle());
        map.put("userSeq", board.getUserSeq().toString());
        map.put("boardContent", board.getBoardContent());
        map.put("boardUpdateDate", board.getBoardUpdateDate());

        return map;
    }
}
