package com.orchard.platform.service.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * @Author orchard.chang
 * @Date 2018/10/2621:41
 * @Version 1.0
 **/
public class MyUtilService {
    /**
     * 判断是否包含特殊字符
     *
     * @param str
     * @return
     */
    public static boolean isSpecialChar(String str) {
        String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
        Pattern p = compile(regEx);
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 判断只包含数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = compile("[0-9]*");
        return pattern.matcher(str).matches();
    }


}
