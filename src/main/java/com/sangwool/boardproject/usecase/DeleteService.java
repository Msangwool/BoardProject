package com.sangwool.boardproject.usecase;

public interface DeleteService {

    /**
     * boardDelete - DeleteUseCase |
     * 게시글을 삭제한다.
     *
     * @param boardSeq 게시글 Sequence 번호를 받아온다.
     */
    Boolean boardDelete(Long boardSeq);

    /**
     * commentDelete - DeleteUseCase |
     * 댓글을 삭제한다.
     *
     * @param commentSeq 댓글 Sequence 번호를 받아온다.
     */
    Boolean commentDelete(Long commentSeq);

    /**
     * nestedCommentDelete - DeleteUseCase |
     * 대댓글을 삭제한다.
     *
     * @param nestedCommentSeq 대댓글 Sequence 번호를 받아온다.
     */
    void nestedCommentDelete(Long nestedCommentSeq);
}
