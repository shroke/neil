package com.shroke.util;

import java.nio.charset.Charset;

/**
 * Created by shroke on 2017/6/24.
 */
public class NielConstants {
    public final static String UTF8_STRING  = "UTF-8";
    public final static  String GBK_STRING = "GBK";
    public final static Charset UTF8 = Charset.forName(UTF8_STRING);
    public final static  Charset GBK = Charset.forName(GBK_STRING);
    public final static String FILE_ROOT_PATH = "/";

    public final static int CONNECT_TIMEOUT = 1000;
}
