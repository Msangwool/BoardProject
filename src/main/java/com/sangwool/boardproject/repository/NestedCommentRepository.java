package com.sangwool.boardproject.repository;

import com.sangwool.boardproject.dto.NestedCommentUploadDto;
import com.sangwool.boardproject.entity.NestedComment;

import java.util.List;

public interface NestedCommentRepository {

    /**
     * save - NestedCommentRepository |
     * 대댓글 업로드 DTO 를 바탕으로 대댓글 정보를 DB에 저장한다.
     * @param nestedCommentUploadDto 대댓글 업로드 DTO 를 받아온다.
     */
    void save(NestedCommentUploadDto nestedCommentUploadDto);

    /**
     * findByCommentSeqNum - NestedCommentRepository |
     * 대댓글 Sequence 번호를 통해 해당 대댓글을 찾는다.
     * @param nestedCommentSeq 대댓글 Sequence 번호를 받아온다.
     * @return 찾은 대댓글 정보를 반환한다.
     */
    NestedComment findByCommentSeqNum(Long nestedCommentSeq);

    /**
     * findAll - NestedCommentRepository |
     * @return 모든 대댓글을 반환한다.
     */
    List<NestedComment> findAll();

    /**
     * findAllByCommentSeqNum - NestedCommentRepository |
     * 댓글 Sequence 번호를 가진 모든 대댓글을 찾는다.
     * @param commentSeq 댓글 Sequence 번호를 받아온다.
     * @return 댓글 Sequence 번호를 가지는 모든 대댓글을 반환한다.
     */
    List<NestedComment> findAllByCommentSeqNum(Long commentSeq);
}
