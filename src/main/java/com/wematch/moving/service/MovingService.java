package com.wematch.moving.service;

public interface MovingService {
    //이사 신청접수
    public Object insertReqInfo(Object data);
    //이사 신청접수 리스트
    public Object getMovingReqInfo(Object data);
    //이사업체와 이사신청 접수 맵핑
    public Object insertCenterMapping(Object data);

}
