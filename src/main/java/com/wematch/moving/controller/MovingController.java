package com.wematch.moving.controller;

import com.wematch.moving.service.MovingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Date : 2021.06.08
 * Author : po dong hee
 * Description : 이사에 관련된 프로세스 정의
 *               이사신청 or 이사맵핑 등등
 * */
@RestController
@RequestMapping("/moving")
public class MovingController {
    @Autowired
    private MovingService movingService;
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 이사신청 등록
     * */
    @RequestMapping(value = "/reqInfo",method = RequestMethod.POST)
    public Object reqInfo(@RequestBody Object param) {
        return movingService.insertReqInfo(param);
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 이사업체와 이사신청에 대한 맵핑 등록
     * */
    @RequestMapping(value = "/movingCenterMapping",method = RequestMethod.POST)
    public Object movingCenterMapping(@RequestBody Object param) {
        return movingService.insertCenterMapping(param);
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 이사신청 등록 디테일 뷰
     * */
    @RequestMapping(value = "/getMovingReqInfo",method = RequestMethod.POST)
    public Object getMovingReqInfo(@RequestBody Object param) {
        return movingService.getMovingReqInfo(param);
    }
}





