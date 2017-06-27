package com.shroke.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Date;

/**
 * Created by shroke on 2017/6/26.
 */
public class CommonUtils {
    public static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    private static String basePath = "C:\\Users\\shroke\\Desktop\\neil\\data";

    public void save(String from, String filename, Date date, String inputString) throws IOException {
        File file = getFile(from, filename, date);
        boolean result = file.createNewFile();
        if (result) {
            Writer writer = null;
            try {
                writer = new FileWriter(file);
                writer.write(inputString);
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } else {
            logger.info(LogMessageBuilder.MESSAGE_HOLDER
                    , new LogMessageBuilder("文件已存在")
                            .addParameter("from", from).addParameter("filename", filename).addParameter("date", date));
        }
    }

    private File getFile(String from, String filename, Date date) {

        String path = basePath + File.separator + date + File.separator + from;
        File pathfile = new File(path);
        pathfile.mkdirs();

        String filepath = path + File.separator + filename;
        File file = new File(filepath);
        return file;
    }

    public void save(String from, String filename, Date date, InputStream inputStream) throws IOException {
        File file = getFile(from, filename, date);
        boolean result = file.createNewFile();
        if (result) {
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
                    byte[] bytes = new byte[1024 * 1024];
                    while ((byteCount = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, byteCount);
                    }
                }
            } finally {
                outputStream.flush();
                inputStream.close();
                outputStream.close();
            }
        } else {
            logger.info(LogMessageBuilder.MESSAGE_HOLDER
                    , new LogMessageBuilder("文件已存在")
                            .addParameter("from", from).addParameter("filename", filename).addParameter("date", date));
        }
    }
}
