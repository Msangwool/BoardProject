package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.BoardUploadDto;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Override
    public Map<String, String> getBoards() {
        return null;
    }

    @Override
    public Map<String, String> getDetailsBoards(Long boardSeq) {
        return null;
    }

    @Override
    public boolean createBoards(BoardUploadDto boardUploadDto) {
        return false;
    }

    @Override
    public boolean updateBoards(BoardUploadDto boardUploadDto) {
        return false;
    }

    @Override
    public boolean deleteBoards(Long boardSeq) {
        return false;
    }
}