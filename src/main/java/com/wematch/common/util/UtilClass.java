package com.wematch.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilClass {
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 주소 00시 00구 00동 까지만 나오게 하는 함수
     * */
    public static String addrSplit(String addr){
        String reqAddr = addr;
        String tmpAddr = "";
        int i= 0;
        String[] arrAddr = reqAddr.split("\\s");
        for(String vo : arrAddr){
            if(i == 3) break;
            tmpAddr += vo +" ";
            i++;
        }
        return tmpAddr;
    }
    /**
     * Date : 2021.06.08
     * Author : po dong hee
     * Description : 폰 번호에 대해 마스킹 하는 함수
     * */
    public static String phoneNumberSplit(String mobile) {
        String replaceString = mobile;
        //String replaceString = "01012324444";
        String MOBILE_PATTERN = "^(\\d{3})-?(\\d{3,4})-?(\\d{4})$";
        Matcher matcher = Pattern.compile(MOBILE_PATTERN).matcher(replaceString);
        String replaceTarget = null;
        if(matcher.matches()) {
            replaceString = "";
            boolean isHyphen = false;
            if(mobile.indexOf("-") > -1) {
                isHyphen = true;
            }
            for(int i=1;i<=matcher.groupCount();i++) {
                replaceTarget = matcher.group(i);
                if(i == 3) {
                    replaceString += replaceTarget.substring(0,1)+"**"+replaceTarget.substring(3,4);

                } else {
                    replaceString = replaceString + replaceTarget;
                }

                if(isHyphen && i < matcher.groupCount()) {
                    replaceString = replaceString + "-";
                }
            }
        }
        return replaceString;
    }
}
