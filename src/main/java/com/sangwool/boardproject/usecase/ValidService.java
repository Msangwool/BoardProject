package com.sangwool.boardproject.usecase;

public interface ValidService {

    /**
     * isBoard - ValidService |
     * 게시글이 존재한다면 true 를 게시글이 존재하지 않는다면 false 를 반환합니다.
     * @param boardSeq 게시글 번호를 받아옵니다.
     * @return 해당 게시글이 존재하는지의 여부를 반환합니다.
     */
    Boolean isBoard(Long boardSeq);

    /**
     * isComment - ValidService |
     * 댓글이 존재한다면 true 를 반환하고 댓글이 존재하지 않는다면 false 를 반환합니다.
     * @param commentSeq 댓글 번호를 받아옵니다.
     * @return 해당 댓글이 존재하는지의 여부를 반환합니다.
     */
    Boolean isComment(Long commentSeq);
}
