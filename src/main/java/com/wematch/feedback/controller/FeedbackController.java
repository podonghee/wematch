package com.wematch.feedback.controller;
import com.wematch.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private FeedBackService feedBackService;
    //유저 피드백 이력등록
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public Object feedBackHist(@RequestBody Object param){
        return feedBackService.insertFeedBackHist(param);
    }
}





