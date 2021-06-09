package com.wematch.company.controller;
import com.wematch.company.bean.CompanyDTO;
import com.wematch.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date : 2021.06.07
 * Author : po dong hee
 * Description : 이사업체 API
 * */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    /**
     * Date : 2021.06.07
     * Author : po dong hee
     * Description : 이사업체 등록
     * */
    @RequestMapping("/movingCenter")
    public Object movingCenter(@RequestBody CompanyDTO dto){
        return companyService.insertMovingCenter(dto);
    }
    /**
     * Date : 2021.06.07
     * Author : po dong hee
     * Description : 이사업체 등록
     * */
    @RequestMapping("/getMovingCenterList")
    public Object getMovingCenterList()  {
        return companyService.getMovingCenterList();
    }
}





