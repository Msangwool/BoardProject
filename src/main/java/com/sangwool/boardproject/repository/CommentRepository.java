package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.CommentUploadDto;
import com.sangwool.boardproject.entity.Comment;

import java.util.List;

public interface CommentRepository {

    /**
     * save - CommentRepository |
     * 댓글 업로드 DTO 를 바탕으로 댓글 정보를 DB에 저장한다.
     * @param commentUploadDto 댓글 업로드 DTO 를 받아온다.
     */
    void save(CommentUploadDto commentUploadDto);

    /**
     * findByCommentSeqNum - CommentRepository |
     * 댓글 Sequence 번호를 통해 해당 댓글을 찾는다.
     * @param commentSeqNum 댓글 Sequence 번호를 받아온다.
     * @return 찾은 댓글 정보를 반환한다.
     */
    Comment findByCommentSeqNum(Long commentSeqNum);

    /**
     * findAll - CommentRepository |
     * @return 모든 댓글 정보를 반환한다.
     */
    List<Comment> findAll();

    /**
     * findAllByBoardSeqNum - CommentRepository |
     * 게시글 Sequence 번호를 갖고 있는 모든 댓글을 찾는다.
     * @param boardSeq 게시글 Sequence 번호를 가져온다.
     * @return 해당 게시글 번호를 갖고 있는 모든 댓글을 반환한다.
     */
    List<Comment> findAllByBoardSeqNum(Long boardSeq);
}
