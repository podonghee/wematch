package com.wematch.moving.service.impl;

import com.wematch.moving.dao.MovingMapper;
import com.wematch.moving.service.MovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

import static com.wematch.common.util.UtilClass.addrSplit;
import static com.wematch.common.util.UtilClass.phoneNumberSplit;

@Service
public class MovingServiceImpl implements MovingService {
    @Autowired
    private MovingMapper movingMapper;
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 이사신청 등록
     * */
    @Override
    public Object insertReqInfo(Object data) {
        HashMap<String,Object> result = new HashMap<>();
        HashMap<String,Object> reqMap = (HashMap) data;
        try {
            movingMapper.insertReqInfo(reqMap);
            result.put("result",true);
            result.put("errMsg","");
            return result;
        } catch (Exception e){
            result.put("result",false);
            result.put("errMsg",e.getMessage());
            return result;
        }
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 매칭 여부가 가능한 이사업체와 이사신청 등록을 한 REQ 와 맵핑 시켜주는 함수
     * STATUS : A = '진행초기' B = '진행중' C = '완료'
     * */
    @Override
    public Object insertCenterMapping(Object data) {
        HashMap<String,Object> reqMap = (HashMap) data;
        HashMap<String,Object> result = new HashMap<>();
        try {
            //ToDo 이사 업체에 매칭여부는 업데이트 할필요가없다
            // 업체에 역량에 따라 더 많은 일을 진행 할 수 있으니 매칭여부에 대한 프로세스는 따로만들어야함.
            reqMap.put("status","A");
            movingMapper.insertMovingMapping(reqMap);
            result.put("result",true);
            result.put("errMsg","");
            return result;
        }catch (Exception e){
            result.put("result",false);
            result.put("errMsg",e.getMessage());
            return result;
        }
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 신청 접수정보 List
     * */
    @Override
    public Object getMovingReqInfo(Object data) {
        HashMap<String,Object> result = new HashMap<>();
        try{
            HashMap<String,Object> reqMap = (HashMap) data;
            List<HashMap<String,Object>> list = movingMapper.getMovingReqInfoList(reqMap);
            for(HashMap<String,Object> vo : list){
                //정규식 함수 이용 휴대폰번호 마스킹
                vo.put("tel",phoneNumberSplit(vo.get("tel").toString()));
                vo.put("start_address",addrSplit(vo.get("start_address").toString()));
                vo.put("end_address",addrSplit(vo.get("start_address").toString()));
                //보관이사여부는 YN 처리로 구현하였다.
                vo.put("is_storage","Y".equals(vo.get("is_storage")) ? true : false);
            }
            result.put("result",list);
            result.put("total_data_count",list.size());
            return result;
        }catch (Exception e){
            result.put("result",false);
            result.put("errMsg",e.getMessage());
            return result;
        }
    }
}
