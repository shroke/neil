package com.shroke.service;

import com.google.common.collect.Maps;
import com.shroke.mapper.ExchangeMapper;
import com.shroke.model.Exchange;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by shroke on 2017/6/11.
 */
@Service
public class ExchangeService {
    private ExchangeMapper exchangeMapper;

    private Map<String,Exchange> cache = Maps.newHashMap();

    private Exchange getCacheExchangeByName(String name){
        Exchange exchange = cache.get(name);
        if(exchange == null){
            synchronized (cache) {
                exchange = cache.get(name);
                if (exchange == null) {
                    exchange = exchangeMapper.getByName(name);
                    if (exchange != null) {
                        cache.put(name, exchange);
                    }
                }
            }
        }
        return exchange;
    }
}
