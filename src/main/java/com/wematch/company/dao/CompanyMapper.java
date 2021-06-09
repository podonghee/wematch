package com.wematch.company.dao;

import com.wematch.company.bean.CompanyDTO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


@Mapper
public interface CompanyMapper {
    //이사업체 등록
    int insertMovingCenter(CompanyDTO dto);
    //이사업체 트럭 등록
    int insertMovingCenterCar(Object param);
    //이사업체 최신 max값 가져오기
    int getSelectCmId();
    //이사업체 리스트
    List<CompanyDTO> getMovingCenterList();

}
