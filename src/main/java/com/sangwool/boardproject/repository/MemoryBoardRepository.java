package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.BoardUploadDto;
import com.sangwool.boardproject.entity.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryBoardRepository implements BoardRepository {

    private static final Map<Long, Board> boardMap = new ConcurrentHashMap<>();
    private static Long seqNum = 0L;

    @Override
    public void save(BoardUploadDto boardUploadDto) {
        Long boardSeqNum = ++seqNum;

        boardMap.put(boardSeqNum, Board.builder()
                .boardSeq(++boardSeqNum)
                .boardTitle(boardUploadDto.getBoardTitle())
                .userSeq(boardUploadDto.getUserSeq())
                .boardContent(boardUploadDto.getBoardContent())
                .boardUploadDate(new Date(System.currentTimeMillis()).toString())
                .build());
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
}
