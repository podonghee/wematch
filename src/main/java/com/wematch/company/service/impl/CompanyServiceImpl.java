package com.wematch.company.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wematch.company.bean.CompanyDTO;
import com.wematch.company.dao.CompanyMapper;
import com.wematch.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import static com.wematch.common.util.UtilClass.addrSplit;
import static com.wematch.common.util.UtilClass.phoneNumberSplit;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;
    /**
     * Date : 2021.06.07
     * Author : po dong hee
     * Description : 이사업체 정보를 등록하는 함수
     * */
    @Override
    public Object insertMovingCenter(CompanyDTO dto) {
        HashMap<String,Object> result = new HashMap<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<CompanyDTO> carList =  objectMapper.convertValue(dto.getMovingCenterCarList(), new TypeReference<List<CompanyDTO>>() {});
            //이사업체 정보 등록
            companyMapper.insertMovingCenter(dto);
            //이사업체 Id 가져오기
            int mcId = companyMapper.getSelectCmId();
            for(CompanyDTO vo : carList){
                vo.setMcSeq(mcId);
                //이사업체 트럭 수 등록
                companyMapper.insertMovingCenterCar(vo);
            }
            result.put("result",true);
            result.put("errMsg","");

            return result;
        }catch (Exception e){
            result.put("result",false);
            result.put("errMsg",e.getMessage());
            e.printStackTrace();
            return result;

        }
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 이사업체 List
     * */
    @Override
    public Object getMovingCenterList() {
        HashMap<String,Object> resMap = new HashMap<>();
        try {
            List<CompanyDTO> list = companyMapper.getMovingCenterList();
            for(CompanyDTO vo : list){
                //정규식 함수 이용 휴대폰번호 마스킹
                vo.setMcTel(phoneNumberSplit(vo.getMcTel()));
                //간단하게 split 으로 쪼개서 주소 작업진행
                vo.setMcAddr(addrSplit(vo.getMcAddr()));
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
