package com.sangwool.boardproject.usecase;

import com.sangwool.boardproject.dto.BoardDeleteDto;
import com.sangwool.boardproject.dto.CommentDeleteDto;
import com.sangwool.boardproject.dto.NestedCommentDeleteDto;

public interface DeleteService {

    /**
     * boardDelete - DeleteUseCase |
     * 게시글을 삭제한다.
     *
     * @param boardDeleteDto 게시글 Sequence 번호를 받아온다.
     */
    Boolean boardDelete(BoardDeleteDto boardDeleteDto);

    /**
     * commentDelete - DeleteUseCase |
     * 댓글을 삭제한다.
     *
     * @param commentDeleteDto 댓글 Sequence 번호를 받아온다.
     */
    Boolean commentDelete(CommentDeleteDto commentDeleteDto);

    /**
     * nestedCommentDelete - DeleteUseCase |
     * 대댓글을 삭제한다.
     *
     * @param nestedCommentDeleteDto 대댓글 Sequence 번호를 받아온다.
     */
    void nestedCommentDelete(NestedCommentDeleteDto nestedCommentDeleteDto);
}
