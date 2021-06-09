package com.wematch.feedback.dao;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface FeedBackMapper {
    //피드백 인설트
    int insertFeedBackHist(Object param);

}
