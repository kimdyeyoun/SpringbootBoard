package com.koreait.springbootboard.board.model;

import lombok.Data;

@Data
public class BoardEntity {
    private int iboard;
    private int icatagory;
    private int iuser;
    private int hits;
    private int isdel;
    private String title;
    private String ctnt;
    private String rdt;
    private String mdt;
    private String lasttip;
}
