package com.shroke.service;

import com.shroke.parsing.StockProfileParse;
import com.shroke.util.NielConstants;
import com.shroke.util.StringResponseHandler;
import org.apache.http.client.fluent.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by shroke on 2017/6/15.
 */
@Service
public class StockService {
    public static final Logger logger = LoggerFactory.getLogger(StockDailySchedul.class);
    private final static String stockBaseUrl = "http://vip.stock.finance.sina.com.cn/corp/go.php/vCI_CorpInfo/stockid/%s.phtml";
    @Autowired
    private StockProfileParse stockProfileParse;

    public static void main(String[] agrs) throws IOException{
        String stockCode = "603226";
        String requestUrl = String.format(stockBaseUrl,stockCode);
        long starttime = System.currentTimeMillis();
        try {
            String result = Request.Get(requestUrl)
                    .connectTimeout(NielConstants.CONNECT_TIMEOUT)
                    .execute()
                    .handleResponse(new StringResponseHandler(NielConstants.GBK));
            System.out.println(result);
        }finally {
            System.out.println("time spends:" + (System.currentTimeMillis() - starttime));
        }

//        StockService stockService = new StockService();
//        try {
//            stockService.processStock("603226");
//        }catch (Exception e){
//            logger.error(e.getMessage(),e);
//        }
    }

    public void processStock(String stockCode) throws IOException{


    }
}
