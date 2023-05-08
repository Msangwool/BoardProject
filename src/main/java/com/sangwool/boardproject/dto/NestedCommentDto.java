package com.sangwool.boardproject.dto;

import com.sangwool.boardproject.entity.NestedComment;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NestedCommentDto {
    private final Long nestedCommentSeq;                // 대댓글 Sequence 번호
    private final Long commentSeq;                      // 댓글 Sequence 번호
    private final Long userSeq;                         // 대댓글 작성자 Sequence 번호 (유저)
    private final String nestedCommentContent;          // 대댓글 내용
    private final String nestedCommentDate;                     // 등록 or 수정 시간

    @Builder
    public NestedCommentDto(Long nestedCommentSeq, Long commentSeq, Long userSeq, String nestedCommentContent, String nestedCommentDate) {
        this.nestedCommentSeq = nestedCommentSeq;
        this.commentSeq = commentSeq;
        this.userSeq = userSeq;
        this.nestedCommentContent = nestedCommentContent;
        this.nestedCommentDate = nestedCommentDate;
    }

    public static NestedCommentDto buildDto(NestedComment nestedComment, String date) {

        return NestedCommentDto.builder()
                .nestedCommentSeq(nestedComment.getNestedCommentSeq())
                .commentSeq(nestedComment.getCommentSeq())
                .userSeq(nestedComment.getUserSeq())
                .nestedCommentContent(nestedComment.getNestedCommentContent())
                .nestedCommentDate(date)
                .build();
    }
}
