package com.sangwool.boardproject.usecase;

public interface DeleteService {

    Boolean boardDelete(Long boardSeq);

    Boolean commentDelete(Long commentSeq);

    void nestedCommentDelete(Long nestedCommentSeq);
}
