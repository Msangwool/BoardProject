package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.CommentDeleteDto;
import com.sangwool.boardproject.dto.CommentDto;
import com.sangwool.boardproject.dto.CommentUpdateDto;
import com.sangwool.boardproject.dto.CommentUploadDto;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    /**
     * getAllComments - CommentService |
     * @return 모든 댓글을 반환한다.
     */
    List<CommentDto> getAllComments();

    /**
     * getDetailsComment - CommentService |
     * 특정 댓글 정보를 제공한다.
     * @param commentSeq 댓글 Sequence 번호를 받아온다.
     * @return 해당 댓글 정보를 Map 형태로 반환한다.
     */
    CommentDto getDetailsComment(Long commentSeq);

    /**
     * getCommentsByBoardSeq - CommentService |
     * 특정 게시글에 있는 모든 댓글을 제공한다.
     * @param boardSeq 게시글 Sequence 번호를 받아온다.
     * @return 해당 게시글 Sequence 번호를 가진 모든 댓글을 반환한다.
     */
    List<CommentDto> getCommentsByBoardSeq(Long boardSeq);

    /**
     * createComments - CommentService |
     * 댓글을 생성한다.
     * @param commentUploadDto 댓글 생성에 필요한 정보를 받아온다.
     * @return Client 에게 필요한 댓글 정보를 반환한다..
     */
    Optional<CommentDto> createComments(CommentUploadDto commentUploadDto);

    /**
     * updateComments - CommentService |
     * 댓글을 수정한다.
     * @param commentUpdateDto 댓글 수정에 필요한 정보를 받아온다.
     * @return Client 에게 필요한 댓글 정보를 반환한다..
     */
    Optional<CommentDto> updateComments(CommentUpdateDto commentUpdateDto);

    /**
     * getDetailsComment - CommentService |
     * 댓글을 삭제한다. 대댓글도 모두 삭제한다.
     * @param commentDeleteDto 댓글 삭제에 필요한 정보를 받아온다.
     * @return 댓글 삭제 성공여부를 반환한다.
     */
    boolean deleteComments(CommentDeleteDto commentDeleteDto);
}
