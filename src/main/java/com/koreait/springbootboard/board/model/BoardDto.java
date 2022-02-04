package com.koreait.springbootboard.board.model;

import lombok.Data;

@Data
public class BoardDto {
    private int icategory;
    private int iboard;
    private int recordCount;
    private int currentPage;
    private int startIdx;


}
