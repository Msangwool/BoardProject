package com.sangwool.boardproject.usecase;

public interface Delete {

    public Boolean boardDelete(Long boardSeq);

    public Boolean commentDelete(Long commentSeq);

    public void nestedCommentDelete(Long nestedCommentSeq);
}
