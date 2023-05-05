package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.NestedCommentUploadDto;

import java.util.Map;

public interface NestedCommentService {

    /**
     * getAllNestedComments - NestedCommentService |
     * @return 모든 대댓글을 반환한다.
     */
    Map<String, String> getAllNestedComments();

    /**
     * getDetailsNestedComment - NestedCommentService |
     * @param nestedCommentSeq 대댓글 Sequence 번호를 받아온다.
     * @return 해당 대댓글 정보를 Map 형태로 반환한다.
     */
    Map<String, String> getDetailsNestedComment(Long nestedCommentSeq);

    /**
     * getNestedCommentsByCommentSeq - NestedCommentService |
     * @param commentSeq 댓글 Sequence 번호를 받아온다.
     * @return 해당 댓글 Sequence 번호를 가진 모든 대댓글을 반환한다.
     */
    Map<String, String> getNestedCommentsByCommentSeq(Long commentSeq);

    /**
     * createNestedComments - NestedCommentService |
     * 대댓글을 생성한다.
     * @param nestedCommentUploadDto 대댓글 생성에 필요한 정보를 받아온다.
     * @return 대댓글 생성 성공 여부를 반환한다.
     */
    boolean createNestedComments(NestedCommentUploadDto nestedCommentUploadDto);

    /**
     * updateNestedComments - NestedCommentService |
     * 대댓글을 수정한다.
     * @param nestedCommentUploadDto 대댓글 수정에 필요한 정보를 받아온다.
     * @return 대댓글 수정 성공 여부를 반환한다.
     */
    boolean updateNestedComments(NestedCommentUploadDto nestedCommentUploadDto);

    /**
     * deleteNestedComments - NestedCommentService |
     * @param nestedCommentSeq 대댓글 삭제에 필요한 정보를 받아온다.
     * @return 대댓글 삭제 성공 여부를 반환한다.
     */
    boolean deleteNestedComments(Long nestedCommentSeq);
}
