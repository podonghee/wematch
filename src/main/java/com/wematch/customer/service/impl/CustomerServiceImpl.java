package com.wematch.customer.service.impl;

import com.wematch.customer.bean.CustomerDTO;
import com.wematch.customer.dao.CustomerMapper;
import com.wematch.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.wematch.common.util.UtilClass.phoneNumberSplit;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 고객 등록
     * */
    @Override
    public Object insertUser(CustomerDTO dto) {
        HashMap<String,Object> result = new HashMap<>();
        //유저 정보 등록
        try {
            customerMapper.insertUser(dto);
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
     * Description : 고객 List
     * */
    @Override
    public Object getUserInfo() {
        HashMap<String,Object> resMap = new HashMap<>();
        try {
            List<CustomerDTO> list = customerMapper.getUserInfoList();
            for(CustomerDTO vo : list){
                //정규식 함수 이용 휴대폰번호 마스킹
                vo.setUserTel(phoneNumberSplit(vo.getUserTel()));
            }
            resMap.put("result",list);
            resMap.put("total_data_count",list.size());
            return resMap;
        } catch (Exception e){
            resMap.put("result",false);
            resMap.put("errMsg",e.getMessage());
            return resMap;
        }

    }
}
