package com.shroke.service;

import com.google.common.collect.Maps;
import com.shroke.mapper.ExchangeMapper;
import com.shroke.model.Exchange;
import com.shroke.util.LogMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by shroke on 2017/6/11.
 */
@Service
public class ExchangeService {
    public static final Logger logger = LoggerFactory.getLogger(ExchangeService.class);
    @Autowired
    private ExchangeMapper exchangeMapper;

    private Map<String,Exchange> cache = Maps.newHashMap();

    @Scheduled(cron = "0 0 0/2  * * * ")
    public void refresh(){
       List<Exchange> exchanges = exchangeMapper.selectAll();
       Map<String,Exchange> tmpCache = Maps.newHashMap();
       for(Exchange exchange:exchanges){
           tmpCache.put(exchange.getName(),exchange);
       }
       logger.info(LogMessageBuilder.MESSAGE_HOLDER,
               new LogMessageBuilder("refresh Exchange").addParameter("exchanges",exchanges));
       cache = tmpCache;
    }

    public Exchange getCacheExchangeByName(String name){
        Exchange exchange = cache.get(name);
        return exchange;
    }
}
