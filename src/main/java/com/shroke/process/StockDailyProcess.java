package com.shroke.process;

import com.google.common.collect.Lists;
import com.shroke.parsing.DailyFileParse;
import com.shroke.util.LogMessageBuilder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.Charset;
import java.sql.Date;
import java.util.List;

/**
 * Created by shroke on 2017/6/3.
 */
@Service
public class StockDailyProcess {
    private static List<String> urls = Lists.newArrayList();
    public static final Logger logger = LoggerFactory.getLogger(StockDailyProcess.class);

    public static void main(String[] agrs) throws IOException {
        StockDailyProcess mainProcess = new StockDailyProcess();
        mainProcess.processDaily("1");
    }


    private static String basePath = "C:\\Users\\shroke\\Desktop\\neil\\data";
    private void save(String from, String filename, Date date, String inputString) throws IOException{
        File file = getFile(from,filename,date);
        boolean result = file.createNewFile();
        if(result){
            Writer writer = null;
            try {
                writer = new FileWriter(file);
                writer.write(inputString);
            }finally {
                if(writer!=null) {
                    writer.close();
                }
            }
        }else{
            logger.info(LogMessageBuilder.MESSAGE_HOLDER
                    ,new LogMessageBuilder("文件已存在")
                            .addParameter("from",from).addParameter("filename",filename).addParameter("date",date));
        }
    }

    private File getFile( String from, String filename, Date date){

        String path = basePath+File.separator+date+File.separator+from;
        File pathfile = new File(path);
        pathfile.mkdirs();

        String filepath = path +File.separator+filename;
        File file = new File(filepath);
        return file;
    }

    private void save(String from, String filename, Date date, InputStream inputStream) throws IOException{
        File file = getFile(from,filename,date);
        boolean result = file.createNewFile();
        if(result){
            DataOutputStream outputStream = null;
            try {
                outputStream = new DataOutputStream(new FileOutputStream(file));
                int len = inputStream.available();
                //判断长度是否大于1M
                if (len <= 1024 * 1024) {
                    byte[] bytes = new byte[len];
                    inputStream.read(bytes);
                    outputStream.write(bytes);
                } else {
                    int byteCount = 0;
                    //1M逐个读取
                    byte[] bytes = new byte[1024*1024];
                    while ((byteCount = inputStream.read(bytes)) != -1){
                        outputStream.write(bytes, 0, byteCount);
                    }
                }
            } finally {
                outputStream.flush();
                inputStream.close();
                outputStream.close();
            }
        }else{
            logger.info(LogMessageBuilder.MESSAGE_HOLDER
                    ,new LogMessageBuilder("文件已存在")
                            .addParameter("from",from).addParameter("filename",filename).addParameter("date",date));
        }
    }

    public void processDaily(String type)throws IOException{
        HttpClient httpClient = HttpClients.createDefault();
        //String type = "2" ;
        HttpGet request = new HttpGet("http://quote.tool.hexun.com/hqzx/quote.aspx?type="+type+"&market=2&sorttype=3&updown=up&page=1&count=5000&time=215450");

        HttpResponse response = null;
        try {
            response = httpClient.execute(request);
            int status = response.getStatusLine().getStatusCode();
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                String returnString = EntityUtils.toString(response.getEntity());
                String from = "hexun";
                DailyFileParse.process(from,returnString);
                //logger.debug(returnString);
                save(from,"daily" + type,new Date(System.currentTimeMillis()),returnString);
            }else{
                logger.warn(LogMessageBuilder.MESSAGE_HOLDER,new LogMessageBuilder("请求返回状态错误！").addParameter("status",status));
            }
        }finally {
            HttpClientUtils.closeQuietly(response);
            HttpClientUtils.closeQuietly(httpClient);
        }
    }


    private void process()  throws IOException{
        HttpClient httpClient = HttpClients.createDefault();
        HttpUriRequest request = new HttpGet("http://finance.sina.com.cn/realstock/company/sh000001/nc.shtml");
        HttpResponse response = httpClient.execute(request);

        // response.getStatusLine()
        logger.info(response.getStatusLine().toString());

        logger.info("{}",response.getEntity().getContentEncoding());


        //打印返回的信息
        logger.info("{}",response.getEntity().getContentLength());
        logger.info(EntityUtils.toString(response.getEntity(), Charset.forName("gbk")));
        EntityUtils.consume(response.getEntity());
        //释放连接
        //method.releaseConnection();
        request.abort();

        HttpClientUtils.closeQuietly(httpClient);
    }
}
