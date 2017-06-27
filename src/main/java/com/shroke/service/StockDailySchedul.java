package com.shroke.service;

import com.google.common.collect.Lists;
import com.shroke.process.StockDailyProcess;
import com.shroke.util.LogMessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shroke on 2017/6/15.
 */
@Service
public class StockDailySchedul {
    public static final Logger logger = LoggerFactory.getLogger(StockDailySchedul.class);

    @Autowired
    private StockDailyProcess stockDailyProcess;

    @Scheduled(cron = "0 0 18 * * * ")
    public void dailySchedul(){
        List<String> types = Lists.newArrayList("1","2");
        for(String type:types) {
            try {
                stockDailyProcess.processDaily(type);
            }catch (Exception e){
                logger.error(LogMessageBuilder.MESSAGE_HOLDER,new LogMessageBuilder(e.getMessage()).addParameter("type",type),e);
            }
        }
    }


}
