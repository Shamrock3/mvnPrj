package com.liang.http.c01;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.io.*;

/**
 * Created by liang on 2017/4/28.
 */
public class SendAndRecHttp {
    /**
     * 向指定的url发送http请求
     *
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","keep-alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for(String key : map.keySet()) {
                System.out.println(key + "---------->" + map.get(key));
            }

            /*in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine()) != null) {
                result += line;
            }*/
            //读取二进制文件
            File file = new File("./img.jpg");
            OutputStream os = new FileOutputStream(file);
            int len = 0;
            InputStream is = connection.getInputStream();
            byte[] buffer = new byte[4*1024];
            while((len = is.read(buffer)) != -1) {
                os.write(buffer,0,len);
            }
            os.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public static String sendPost(String url,String param) {

        return null;
    }

    public static void main(String[] args) {
        String result = sendGet("http://pic18.nipic.com/20111221/7439876_134443857000_2.jpg","");
        System.out.println(result);
    }
}
