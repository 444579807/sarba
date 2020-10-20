package org.sarba.springboot.sarbas.pringbootparent.test;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

@Component
public class Test {


    private static RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        TrustStrategy acceptingTrustStrategy = (X509Certificate[] chain, String authType) -> true;
        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);
        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        requestFactory.setHttpClient(httpClient);
        RestTemplate restTemplate = new RestTemplate(requestFactory);
        return restTemplate;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String requestUrl = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
        //
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.TEXT_XML);
        String xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+
                "<xml>" +
                "<mch_appid>wxe062425f740c30d8</mch_appid>" +
                "<mchid>10000098</mchid>" +
                "<nonce_str>3PG2J4ILTKCH16CQ2502SI8ZNMTM67VS</nonce_str>" +
                "<partner_trade_no>100000982014120919616</partner_trade_no>" +
                "<openid>ohO4Gt7wVPxIT1A9GjFaMYMiZY1s</openid>" +
                "<check_name>FORCE_CHECK</check_name>" +
                "<re_user_name>张三</re_user_name>" +
                "<amount>100</amount>" +
                "<desc>节日快乐!</desc>" +
                "<spbill_create_ip>10.2.3.10</spbill_create_ip>" +
                "<sign>C380BEC2BFD727A4B6845133519F3AD6</sign>" +
                "</xml>";
        //添加请求头
        HttpEntity<String> request = new HttpEntity<String>(xml,header);
        //发送post请求
        ResponseEntity<String> response = restTemplate().postForEntity(requestUrl, request, String.class);
        System.out.println(response.toString());

    }

}
