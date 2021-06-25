package com.wematch.customer.controller;

import com.wematch.customer.bean.CustomerDTO;
import com.wematch.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date : 2021.06.08
 * Author : po dong hee
 * Description : 고객 API
 * */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 고객 등록
     * */
    @RequestMapping(method = RequestMethod.POST)
    public Object register(@RequestBody CustomerDTO dto){
       return customerService.insertUser(dto);
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 고객 리스트
     * */
    @RequestMapping(method = RequestMethod.GET)
    public Object getUserInfo()  {
        return customerService.getUserInfo();
    }
}





