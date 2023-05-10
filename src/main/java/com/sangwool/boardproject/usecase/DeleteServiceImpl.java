package com.sangwool.boardproject.usecase;

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
    public Boolean boardDelete(Long boardSeq) {

        // 해당 게시글 번호로 된 모든 댓글을 삭제한다.
        List<Comment> comments = commentRepository.findAllByBoardSeqNum(boardSeq);
        comments.forEach(comment -> commentDelete(comment.getCommentSeq()));

        // 게시글을 삭제한다.
        boardRepository.deleteBoard(boardSeq);
        return true;
    }

    @Override
    public Boolean commentDelete(Long commentSeq) {

        // 해당 댓글의 대댓글 삭제
        List<NestedComment> nestedComments = nestedCommentRepository.findAllByCommentSeqNum(commentSeq);
        nestedComments.forEach(nestedComment -> nestedCommentDelete(nestedComment.getNestedCommentSeq()));

        // 해당 댓글 삭제
        commentRepository.deleteComment(commentSeq);
        return true;
    }

    @Override
    public void nestedCommentDelete(Long nestedCommentSeq) {

        nestedCommentRepository.deleteNestedComment(nestedCommentSeq);
    }
}
