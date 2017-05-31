package com.pony.common.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zelei.fan on 2017/5/27.
 * 发送rest请求
 */
public class HttpClient {

    private static Logger logger = LoggerFactory.getLogger(HttpClient.class);

    @Value("${pony.monitor.url}")
    private String hostUrl;

    private RestTemplate restTemplate;

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public <T> T defaultPost(String uri, Object request, Class<T> responseType) {
        try {
            return restTemplate.postForObject(hostUrl + uri, request,responseType);
        } catch (Exception e) {
            logger.error("postForObject failed!url:"+uri, e);
            return null;
        }
    }

    public <T> T defaultGet(String uri, Class<T> responseType,Map<String, ?> map) {
        try {
            StringBuilder url = new StringBuilder(uri);
            if(map != null){
                url.append("?");
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    url.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                return restTemplate.getForObject(hostUrl + url.toString().substring(0, url.length()-1), responseType);
            }
            return restTemplate.getForObject(hostUrl + uri, responseType);
        } catch (Exception e) {
            logger.error("getForObject failed!url: "+uri, e);
            return null;
        }
    }

    public  <T> T  exchangeForget(String uri, ParameterizedTypeReference<T> responseType,Map<String, ?> map) {
        try {
            StringBuilder url = new StringBuilder(uri);
            if(map != null){
                url.append("?");
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    url.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                HttpEntity<T> response =  restTemplate.exchange(hostUrl + url.toString().substring(0, url.length()-1), HttpMethod.GET, null, responseType);
                return response.getBody();
            }
            return restTemplate.exchange(hostUrl + uri, HttpMethod.GET, null, responseType).getBody();
        } catch (Exception e) {
            logger.error("getForObject failed!url: "+uri, e);
            return null;
        }
    }

    public <T> T get(String url, Class<T> responseType,Map<String, ?> map) {
        try {
            StringBuilder uri = new StringBuilder(url);
            if(map != null){
                uri.append("?");
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    uri.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
                }
                return restTemplate.getForObject(uri.toString().substring(0, uri.length()-1), responseType);
            }
            return restTemplate.getForObject(url, responseType);
        } catch (Exception e) {
            logger.error("getForObject failed!url: "+url, e);
            return null;
        }
    }

    public <T> T post(String url, Object request, Class<T> responseType) {
        try {
            return restTemplate.postForObject(url, request,responseType);
        } catch (Exception e) {
            logger.error("postForObject failed!url:"+url, e);
            return null;
        }
    }

    public <T> T defaultGet(String uri, Class<T> responseType) {
        try {
            return restTemplate.getForObject(hostUrl + uri, responseType);
        } catch (Exception e) {
            logger.error("getForObject failed!url: "+uri, e);
            return null;
        }
    }
}
