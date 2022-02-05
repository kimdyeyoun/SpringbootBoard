package com.koreait.springbootboard.board.comment.model;

import lombok.Data;

@Data
public class BoardCommentEntity {
    private int icmt;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String rdt;
    private String mdt;
}
