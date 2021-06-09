package com.wematch.company.bean;

import lombok.Data;
import java.util.List;
@Data
public class CompanyDTO {
    private int mcSeq; //이사업체 SEQ
    private String mcName; // 이사업체 명
    private String mcOwner; // 이사업체 대표자
    private String mcTel; // 이사업체 전화번호
    private String mcAddr; // 이사업체 주소
    private String mcRegiNumber; //이사업체 사업자등록번호
    private String mcRegiDate; // 이사업체 사업자등록일자
    private String mcEmplCnt; //이사업체 직원 수
    private String mcMatchingYn; // 이사업체 매칭여부
    private String insertDate; // 이사업체 등록일
    private String useYn;  // 이사업체 사용여부
    private int mcCarSeq; // 이사업체 트럭 SEQ
    private String mcCarWeight; // 이사업체 트럭 무게
    private String mcCarCnt; // 이사업체 트럭 개수
    private List movingCenterCarList; // carList 담기위한 변수
}
