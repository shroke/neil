package com.shroke.util;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

/**
 * Created by shroke on 2017/6/16.
 */
public class HttpNeilUtils {

    public static HttpPost getHttpPost(HttpPost post, String host){

        post.addHeader("Host", host);
        post.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.4 (KHTML, like Gecko) Chrome/22.0.1229.94 Safari/537.4");
        post.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        post.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
        post.addHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
        post.addHeader("Connection", "keep-alive");
        post.addHeader("Cache-Control", "max-age=0");
        post.addHeader("Accept-Encoding","deflate"); // //Accept-Encoding:"gzip, deflate"

        return post;

    }

    public static HttpGet getHttpGet(HttpGet get, String host) {
        get.addHeader("Host", host);
        get.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.4 (KHTML, like Gecko) Chrome/22.0.1229.94 Safari/537.4");
        get.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        get.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
        get.addHeader("Accept-Charset", "GBK,utf-8;q=0.7,*;q=0.3");
        get.addHeader("Connection", "keep-alive");
        get.addHeader("Cache-Control", "max-age=0");
        get.addHeader("Content-Type", "text/html; charset=UTF-8");
        get.addHeader("Accept-Encoding","deflate");

        return get;
    }

}

