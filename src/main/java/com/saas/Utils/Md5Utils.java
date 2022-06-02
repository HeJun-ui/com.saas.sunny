package com.saas.Utils;

import org.springframework.util.DigestUtils;

import java.beans.BeanInfo;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {


    //32位，小写
    String md532Lower = DigestUtils.md5DigestAsHex("adcdefg".getBytes());
    //32位，大写
    String md532Upper=md532Lower.toUpperCase();
    //16位，小写
    String md516Lower =md532Lower.substring(8, 24);
    //16位，大写
    String md516Upper=md532Lower.substring(8, 24).toUpperCase();

    public static void getMD5Str(String str) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            messageDigest.update(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        byte[] byteArray = messageDigest.digest();

        StringBuffer md5StrBuff = new StringBuffer();

        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        //32位，小写
        String md532Lower = md5StrBuff.toString();
        //32位，大写
        String md532Upper=md532Lower.toUpperCase();
        //16位，小写
        String md516Lower =md532Lower.substring(8, 24);
        //16位，大写
        String md516Upper=md532Lower.substring(8, 24).toUpperCase();
    }

}
