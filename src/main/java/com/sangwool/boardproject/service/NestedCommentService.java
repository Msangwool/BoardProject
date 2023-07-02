package com.sangwool.boardproject.service;

import com.sangwool.boardproject.dto.NestedCommentDeleteDto;
import com.sangwool.boardproject.dto.NestedCommentDto;
import com.sangwool.boardproject.dto.NestedCommentUpdateDto;
import com.sangwool.boardproject.dto.NestedCommentUploadDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface NestedCommentService {

    /**
     * getAllNestedComments - NestedCommentService |
     * @return 모든 대댓글을 반환한다.
     */
    List<NestedCommentDto> getAllNestedComments();

    /**
     * getDetailsNestedComment - NestedCommentService |
     * @param nestedCommentSeq 대댓글 Sequence 번호를 받아온다.
     * @return 해당 대댓글 정보를 Map 형태로 반환한다.
     */
    NestedCommentDto getDetailsNestedComment(Long nestedCommentSeq);

    /**
     * getNestedCommentsByCommentSeq - NestedCommentService |
     * @param commentSeq 댓글 Sequence 번호를 받아온다.
     * @return 해당 댓글 Sequence 번호를 가진 모든 대댓글을 반환한다.
     */
    List<NestedCommentDto> getNestedCommentsByCommentSeq(Long commentSeq);

    /**
     * createNestedComments - NestedCommentService |
     * 대댓글을 생성한다.
     * @param nestedCommentUploadDto 대댓글 생성에 필요한 정보를 받아온다.
     * @return Client 에게 필요한 대댓글 정보를 반환한다.
     */
    Optional<NestedCommentDto> createNestedComments(NestedCommentUploadDto nestedCommentUploadDto);

    /**
     * updateNestedComments - NestedCommentService |
     * 대댓글을 수정한다.
     * @param nestedCommentUpdateDto 대댓글 수정에 필요한 정보를 받아온다.
     * @return Client 에게 필요한 대댓글 정보를 반환한다.
     */
    Optional<NestedCommentDto> updateNestedComments(NestedCommentUpdateDto nestedCommentUpdateDto);

    /**
     * deleteNestedComments - NestedCommentService |
     * @param nestedCommentDeleteDto 대댓글 삭제에 필요한 정보를 받아온다.
     * @return 대댓글 삭제 성공 여부를 반환한다.
     */
    boolean deleteNestedComments(NestedCommentDeleteDto nestedCommentDeleteDto);
}
