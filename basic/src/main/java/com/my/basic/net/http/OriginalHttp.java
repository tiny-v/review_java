package com.my.basic.net.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.*;

/**
 * 原生Http请求
 * @author tiny_v
 * @date 2021/7/31.
 */
public class OriginalHttp {

    Logger logger = LoggerFactory.getLogger(OriginalHttp.class);

    /**
     * url信息
     */
    public void urlInfo(){
        try{
            URL url = new URL("http://www.gov.cn/premier/index.htm#xinwen");
            /**
             * protocol:  协议          [http]
             * host:      主机名        [www.gov.cn]
             * port:      端口          [-1]
             * path:      路径          [/premier/index.htm]
             * file:      文件名        [/premier/index.htm]
             * ref:       锚定|参考Url  [xinwen]
             * userInfo:  用户信息      [null]
             * authority: 授权部分      [www.gov.cn]
             * */
            logger.info("protocol:{}, host:{}, port:{}, path:{}, file:{}, ref:{}, userInfo:{}, authority:{}",
                    url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getFile(), url.getRef(), url.getUserInfo(), url.getAuthority());
            url = new URL("ftp://root:password@127.0.0.1:21/profile");
            /**
             * protocol:  协议           ftp]
             * host:      主机名         [127.0.0.1]
             * port:      端口           [21]
             * path:      路径           [/profile]
             * file:      文件名         [/profile]
             * ref:       锚定|参考Url   [null]
             * userInfo:  用户信息       [root:password]
             * authority: 授权部分       [root:password@127.0.0.1:21]
             * */
            logger.info("protocol:{}, host:{}, port:{}, path:{}, file:{}, ref:{}, userInfo:{}, authority:{}",
                    url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getFile(), url.getRef(), url.getUserInfo(), url.getAuthority());
        }catch (MalformedURLException malformedURLException){
            /**malformedURLException: 畸形URL异常*/
            logger.info(malformedURLException.getMessage());
        }
    }

    public void httpUrlConnection(){
        try {
            URL url = new URL("http://www.gov.cn/premier/index.htm#xinwen");
            /**
             * 1. URLConnection实例不会在创建时建立实际的网络连接。 这只会在调用URLConnection.connect()时发生;
             * 2. 如果对于URL的协议（如HTTP或JAR），则存在一个属于以下软件包或其子包之一的公共专用URLConnection子类：java.lang，java.io，java.util，java.net，返回的连接将是该子类。
             *    例如，对于HTTP，将返回一个HttpURLConnection，对于JAR，将返回一个JarURLConnection。
             *  */
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            /* 设置连接属性 */
            setConnProperty(conn);
            /* 建立连接 */
            conn.connect();
            /* 打印response内容 */
            printPageInfo(conn);
            logger.info("responseCode:{}, responseMsg:{}", conn.getResponseCode(), conn.getResponseMessage());
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置连接参数
     */
    private void setConnProperty(HttpURLConnection conn) throws ProtocolException {
        if(conn == null){
            return;
        }
        /**
         * 设置请求方式 / http1.1
         * GET POST HEAD PUT PATCH OPTIONS DELETE TRACE
         * */
        conn.setRequestMethod("POST");
        /**
         * ConnectTimeout: 意思是用来建立连接的时间。如果到了指定的时间，还没建立连接，则报异常
         * 比如： java.net.SocketTimeoutException: connect timed out
         * */
        conn.setConnectTimeout(6*1000);
        /**
         * 意思是已经建立连接，并开始读取服务端资源。如果到了指定的时间，没有可能的数据被客户端读取，则报异常
         * 比如： java.net.SocketTimeoutException: Read timed out
         * */
        conn.setReadTimeout(1000);
        // 是否使用缓存
        conn.setUseCaches(false);
        // 设置接受格式
        conn.setRequestProperty("accept", "*/*");
        // 是否使用长连接, Http1.1 默认是长连接, 不使用长连接的话, 可以将value设为close
        conn.setRequestProperty("connection", "Keep-Alive");
    }


    public void deleteSecurityGroup(){

    }

    /**
     * 打印页面内容
     * @param connection
     */
    private void printPageInfo(HttpURLConnection connection){
        try(InputStream inputStream = connection.getInputStream();
            // 使用UTF-8格式来解码
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            ) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                logger.info(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args){

        //new OriginalHttp().httpUrlConnection();

        String params = "1234,4567";
        String result = "";
        String[] idTemps = params.split(",");
        for(String str: idTemps){
            result = result + "\""+str+ "\"" +",";
        }
        result = result.substring(0, result.length()-1);
        System.out.println(result);

    }

}
