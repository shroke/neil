package com.shroke.service;

import com.shroke.util.HttpNeilUtils;
import com.shroke.util.LogMessageBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by shroke on 2017/6/15.
 */
public class StockService {
    public static final Logger logger = LoggerFactory.getLogger(StockDailySchedul.class);
    private final static String stockBaseUrl = "http://stockdata.stock.hexun.com/%s.shtml";

    public static void main(String[] agrs){
        StockService stockService = new StockService();
        try {
            stockService.processStock("603226");
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
    }

    public void processStock(String stockCode) throws IOException{
        HttpClient httpClient = HttpClients.createDefault();
        String requestUrl = String.format(stockBaseUrl,stockCode);
        HttpGet request = new HttpGet(requestUrl);

        HttpResponse response = null;
        try {
            HttpNeilUtils.getHttpGet(request,"stockdata.stock.hexun.com");
            response = httpClient.execute(request);
            int status = response.getStatusLine().getStatusCode();
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                logger.info(LogMessageBuilder.MESSAGE_HOLDER, EntityUtils.toString(response.getEntity()));
            }else{
                logger.warn(LogMessageBuilder.MESSAGE_HOLDER,
                        new LogMessageBuilder("请求返回状态错误！").addParameter("status",status).addParameter("requestUrl",requestUrl));
            }
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }
}
