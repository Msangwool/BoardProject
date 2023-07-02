package com.sangwool.boardproject.usecase;

import com.sangwool.boardproject.repository.BoardRepository;
import com.sangwool.boardproject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ValidServiceImpl implements ValidService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    public Boolean isBoard(Long boardSeq) {

        return boardRepository.findByBoardSeqNum(boardSeq) != null;
    }

    @Override
    public Boolean isComment(Long commentSeq) {

        return commentRepository.findByCommentSeqNum(commentSeq) != null;
    }
}
