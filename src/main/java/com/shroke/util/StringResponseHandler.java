//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.shroke.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.AbstractResponseHandler;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class StringResponseHandler extends AbstractResponseHandler<String> {
    private Charset charset;
    public StringResponseHandler(Charset charset) {
        this.charset = charset;
    }
    public StringResponseHandler() {
        this.charset = NielConstants.UTF8;
    }

    public String handleEntity(HttpEntity entity) throws IOException {
        return entity != null?EntityUtils.toString(entity,charset): StringUtils.EMPTY;
    }
}
