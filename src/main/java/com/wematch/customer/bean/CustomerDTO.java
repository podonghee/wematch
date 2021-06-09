package com.wematch.customer.bean;

import lombok.Data;

@Data
public class CustomerDTO {
    private int userSeq; //유저 SEQ
    private String userName; // 유저 명
    private String userTel; // 유저 전화번호
    private String insertDate; // 유저 등록일
    private String userTosYn; // 이용약관여부
    private String userEstimateYn; // 견적요청 제3자동의여부
    private String userMarketingYn; // 마케팅여부
}
