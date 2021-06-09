package com.wematch.moving.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface MovingMapper {
    //이사 신청 등록
    int insertReqInfo(Object param);
    //업체와 이사신청 맵핑 등록
    int insertMovingMapping(Object param);
    //이사신청 리스트
    List<HashMap<String,Object>> getMovingReqInfoList(Object param);


}
