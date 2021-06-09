package com.wematch.customer.dao;

import com.wematch.customer.bean.CustomerDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CustomerMapper {
    //고객 등록
    int insertUser(CustomerDTO dto);
    //고객 리스트
    List<CustomerDTO> getUserInfoList();

}
