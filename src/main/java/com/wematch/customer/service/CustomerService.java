package com.wematch.customer.service;

import com.wematch.customer.bean.CustomerDTO;

public interface CustomerService {
    //고객 등록
    public Object insertUser(CustomerDTO dto);
    //고객 리스트
    public Object getUserInfo();
}
