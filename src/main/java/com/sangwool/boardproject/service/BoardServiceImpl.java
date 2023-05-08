package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.*;
import com.sangwool.boardproject.entity.Board;
import com.sangwool.boardproject.entity.Comment;
import com.sangwool.boardproject.repository.BoardRepository;
import com.sangwool.boardproject.repository.CommentRepository;
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
    private final CommentService commentService;
    private final CommentRepository commentRepository;

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

        try {
            // 해당 게시글 번호로 된 모든 댓글을 삭제한다.
            List<Comment> comments = commentRepository.findAllByBoardSeqNum(boardSeq);
            comments.forEach(comment ->
                    commentService.deleteComments(
                            CommentDeleteDto.builder()
                                    .commentSeq(comment.getCommentSeq())
                                    .build()
                    )
            );

            // 게시글을 삭제한다.
            boardRepository.deleteBoard(boardSeq);
            return true;
        } catch (NoSuchElementException e) {
            log.debug("NoSuchElementException = {}", e.getMessage());
            return false;
        } catch (Exception e) {
            log.debug("Exception = {}", e.getMessage());
            return false;
        }
    }
}
