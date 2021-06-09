package com.wematch.feedback.service.impl;

import com.wematch.feedback.dao.FeedBackMapper;
import com.wematch.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FeedBackServiceImpl implements FeedBackService {
    @Autowired
    private FeedBackMapper feedBackMapper;

    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 유저 피드백 등록 함수
     * */
    @Override
    public Object insertFeedBackHist(Object data) {
        HashMap<String, Object> reqMap = (HashMap) data;
        HashMap<String, Object> result = new HashMap<>();
        try {
            feedBackMapper.insertFeedBackHist(reqMap);
            result.put("result", true);
            result.put("errMsg", "");
            return result;
        } catch (Exception e) {
            result.put("result", false);
            result.put("errMsg", e.getMessage());
            return result;
        }
    }
}
