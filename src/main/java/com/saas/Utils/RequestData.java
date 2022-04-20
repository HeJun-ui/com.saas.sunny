package com.saas.Utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestData {
    @Test
    public void demo() {
        String url = "https://pos-kec.kerry-ecommerce.com.cn/pos-web/shipment/create";
        String data = "{\"items\":[{\"currency\":\"THB\",\"description\":\"Two-piece business suit\",\"description_origin_language\":\"商务西装两件套\",\"quantity\":2,\"unit_price\":1090}],\"package\":{\"actual_weight\":1158,\"cod_value\":1690,\"cod_value_currency\":\"THB\",\"declared_value\":1690,\"declared_value_currency\":\"THB\",\"number_of_package\":1,\"payment_method\":\"COD\",\"reference_number\":\"TESTSUN20220419\",\"shipment_term\":\"DDP\",\"shipping_fee\":0},\"receiver\":{\"address\":\"ภูเก็ต เมืองภูเก็ต 101/574 ถนนประชาวามัคคี ตำบลรัษฎา\",\"city\":\"เมืองภูเก็ต\",\"company\":\"นายศิริพงษ์ เลื่อนฉวี\",\"country_code\":\"TH\",\"name\":\"นายศิริพงษ์ เลื่อนฉวี\",\"phone\":\"0994582626\"},\"sender\":{\"address\":\"Hong Kong Yueshao\",\"city\":\"Hong Kong\",\"company\":\"Hong Kong Yueshao\",\"country_code\":\"CN\",\"name\":\"mekmak\",\"phone\":\"13712374183\",\"post_code\":\"999077\"},\"service\":{\"channel_code\":\"CTCNTH100\"}}";
        JSONObject body = sendPost(url, data);
        System.out.println(body);
    }

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
            conn.setRequestProperty("Authorization","Bearer 325d78cd-492c-4839-993d-53a2d53f5ead");
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
