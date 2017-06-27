package com.shroke.process;

import com.google.common.collect.Lists;
import com.shroke.mapper.StockMapper;
import com.shroke.model.CompanyProfile;
import com.shroke.model.Exchange;
import com.shroke.model.Stock;
import com.shroke.model.StockStatus;
import com.shroke.parsing.QuoteParse;
import com.shroke.parsing.StockProfileParse;
import com.shroke.response.QuoteResponse;
import com.shroke.service.ExchangeService;
import com.shroke.util.LogMessageBuilder;
import com.shroke.util.NielConstants;
import com.shroke.util.StringResponseHandler;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by shroke on 2017/6/3.
 */
@Service
public class StockDailyProcess {
    private static List<String> urls = Lists.newArrayList();
    public static final Logger logger = LoggerFactory.getLogger(StockDailyProcess.class);
    private final static String stockBaseUrl = "http://vip.stock.finance.sina.com.cn/corp/go.php/vCI_CorpInfo/stockid/%s.phtml";
    @Autowired
    private QuoteParse dailyFileParse;
    @Autowired
    private StockProfileParse stockProfileParse;
    @Autowired
    private StockMapper stockMapper;
    @Autowired
    private ExchangeService exchangeService;

    public static void main(String[] agrs) throws IOException {
        StockDailyProcess mainProcess = new StockDailyProcess();
        mainProcess.processDaily("1");
        // mainProcess.processDaily();
    }

    public void processDaily(String type) throws IOException {
        Response response = Request.Get("http://quote.tool.hexun.com/hqzx/quote.aspx?type=" + 1 + "&market=2&sorttype=3&updown=up&page=1&count=5000&time=215450").execute();
        Content content = response.returnContent();
        List<QuoteResponse> quoteResponseList = dailyFileParse.process(content.asString());
        for(QuoteResponse quoteResponse:quoteResponseList){
            processQuoteResponse(quoteResponse);
        }
    }

    private void processQuoteResponse(QuoteResponse quoteResponse) throws IOException {
        String stockCode = quoteResponse.getStockCode();
        Stock stock = stockMapper.selectByStockCode(stockCode);
        if(stock == null){
            stock = new Stock();
            String requestUrl = String.format(stockBaseUrl, stockCode);
            String value = Request.Get(requestUrl)
                    .connectTimeout(NielConstants.CONNECT_TIMEOUT)
                    .execute()
                    .handleResponse(new StringResponseHandler(NielConstants.GBK));
            CompanyProfile companyProfile = stockProfileParse.processSource(value);

            stock.setCompanyProfile(companyProfile);
            stock.setStockCode(stockCode);
            stock.setName(quoteResponse.getStockName());
            stock.setExchangeId(parseExchange(companyProfile.getMarket()));
            stock.setIndustriesId(0);   //TODO
            stock.setListedDate(companyProfile.getListedDate());
            stock.setSumShares(0);      //TODO
            stock.setTradableShares(0); //TODO
            stock.setCurrentPrice(quoteResponse.getUptodate());
            stock.setStockStatus(StockStatus.ACTIVE);

            stockMapper.insert(stock);
        }

    }

    private long parseExchange(String name){
        Exchange exchange = exchangeService.getCacheExchangeByName(name);
        if(exchange != null){
            return exchange.getId();
        }
        logger.error(LogMessageBuilder.MESSAGE_HOLDER
                ,new LogMessageBuilder("证券所信息未找到！").addParameter("name",name));
        return 0;
    }

}
