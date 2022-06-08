package com.saas.Utils;

import com.alibaba.fastjson.JSONObject;import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class RequestData {

 /**
     * @param pathurl 请求地址
     * @param data    请求数据
     * @return
     */
    public JSONObject sendPost(String pathurl, String data) {
        OutputStreamWriter out = null;
        BufferedReader br = null;
        String result = "";
        HttpURLConnection conn = null;
        try {
            URL url = new URL(pathurl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization","Bearer { \"sysCode\": \"KEC\", \"sign\": \"29b2dca44308cff12e1a24adbd61ae9f242bbbf49e0d8f41b4848377aa630d07\"}");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(data);
            out.flush();
            InputStream is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null) {
                result += str;
            }
            out.flush();
            br.close();


        } catch (Exception e) {

            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "UTF-8"));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    result += line;
                }
                reader.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        return JSONObject.parseObject(result);
    }

}
