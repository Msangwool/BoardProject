package com.sangwool.boardproject.usecase;

import com.sangwool.boardproject.dto.BoardDeleteDto;
import com.sangwool.boardproject.dto.CommentDeleteDto;
import com.sangwool.boardproject.dto.NestedCommentDeleteDto;
import com.sangwool.boardproject.entity.Comment;
import com.sangwool.boardproject.entity.NestedComment;
import com.sangwool.boardproject.repository.BoardRepository;
import com.sangwool.boardproject.repository.CommentRepository;
import com.sangwool.boardproject.repository.NestedCommentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeleteServiceImpl implements DeleteService {
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final NestedCommentRepository nestedCommentRepository;

    @Override
    public Boolean boardDelete(BoardDeleteDto boardDeleteDto) {

        // 해당 게시글 유효성 검증
        Long boardSeq = boardDeleteDto.getBoardSeq();
        if (!boardRepository.findByBoardSeqNum(boardSeq).getUserSeq().equals(boardDeleteDto.getUserSeq())) {
            return false;
        }

        // 해당 게시글의 대댓글 삭제
        List<Comment> comments = commentRepository.findAllByBoardSeqNum(boardDeleteDto.getBoardSeq());
        comments.forEach(comment ->
                commentDelete(CommentDeleteDto.buildDto(comment.getCommentSeq(), comment.getUserSeq())));

        // 게시글을 삭제한다.
        boardRepository.deleteBoard(boardSeq);
        return true;
    }

    @Override
    public Boolean commentDelete(CommentDeleteDto commentDeleteDto) {

        // 해당 댓글 권한 검증
        Long commentSeq = commentDeleteDto.getCommentSeq();
        if (!commentRepository.findByCommentSeqNum(commentSeq).getUserSeq().equals(commentDeleteDto.getUserSeq())) {
            return false;
        }

        // 해당 댓글의 대댓글 삭제
        List<NestedComment> nestedComments = nestedCommentRepository.findAllByCommentSeqNum(commentSeq);
        nestedComments.forEach(nestedComment ->
                nestedCommentDelete(NestedCommentDeleteDto.buildDto(nestedComment.getNestedCommentSeq(), nestedComment.getUserSeq())));

        // 해당 댓글 삭제
        commentRepository.deleteComment(commentSeq);
        return true;
    }

    @Override
    public void nestedCommentDelete(NestedCommentDeleteDto nestedCommentDeleteDto) {

        // 해당 대댓글 권한 검증
        Long nestedCommentSeq = nestedCommentDeleteDto.getNestedCommentSeq();
        if (!nestedCommentRepository.findByCommentSeqNum(nestedCommentSeq).getUserSeq().equals(nestedCommentDeleteDto.getUserSeq())) {
            return;
        }

        // 해당 대댓글 삭제
        nestedCommentRepository.deleteNestedComment(nestedCommentSeq);
    }
}
