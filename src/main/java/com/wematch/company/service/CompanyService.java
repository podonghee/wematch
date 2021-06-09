package com.wematch.company.service;

import com.wematch.company.bean.CompanyDTO;

public interface CompanyService {
    //이사업체 등록
    public Object insertMovingCenter(CompanyDTO dto);
    //이사업체 리스트
    public Object getMovingCenterList();
}
