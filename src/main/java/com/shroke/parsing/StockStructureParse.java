package com.shroke.parsing;

import com.shroke.model.StockStructure;
import com.shroke.util.NielConstants;
import com.shroke.util.StringResponseHandler;
import org.apache.http.client.fluent.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by shroke on 2017/6/26.
 */
public class StockStructureParse extends BaseParse {
    private static final Logger logger = LoggerFactory.getLogger(StockStructureParse.class);

    public StockStructure parseStockStructure(String source) {
        Document doc = Jsoup.parse(source, NielConstants.GBK_STRING);
        Element content = doc.getElementById("StockStructureNewTable0");

        StockStructure stockStructure = new StockStructure();
        stockStructure.set变动日期(parseSqlDate(getTableValue(content, 1, 1)));
        stockStructure.set公告日期(parseSqlDate(getTableValue(content, 2, 1)));
        stockStructure.set变动原因(getTableValue(content, 4, 1));
        stockStructure.set总股本(parseStockNum(getTableValue(content, 5, 1)));
        stockStructure.set流通A股(parseStockNum(getTableValue(content, 7, 1)));
        stockStructure.set高管股(parseStockNum(getTableValue(content, 8, 1)));
        stockStructure.set限售A股(parseStockNum(getTableValue(content, 9, 1)));
        stockStructure.set流通B股(parseStockNum(getTableValue(content, 10, 1)));
        stockStructure.set限售B股(parseStockNum(getTableValue(content, 11, 1)));
        stockStructure.set流通H股(parseStockNum(getTableValue(content, 12, 1)));
        stockStructure.set国家股(parseStockNum(getTableValue(content, 13, 1)));
        stockStructure.set国有法人股(parseStockNum(getTableValue(content, 14, 1)));
        stockStructure.set境内发起人股(parseStockNum(getTableValue(content, 16, 1)));
        stockStructure.set募集法人股(parseStockNum(getTableValue(content, 17, 1)));
        stockStructure.set一般法人股(parseStockNum(getTableValue(content, 18, 1)));
        stockStructure.set战略投资者持股(parseStockNum(getTableValue(content, 19, 1)));
        stockStructure.set基金持股(parseStockNum(getTableValue(content, 20, 1)));
        stockStructure.set转配股(parseStockNum(getTableValue(content, 21, 1)));
        stockStructure.set内部职工股(parseStockNum(getTableValue(content, 22, 1)));
        stockStructure.set优先股(parseStockNum(getTableValue(content, 23, 1)));

        return stockStructure;
    }

    public static void main(String[] agrs) throws IOException {
        String result = Request.Get("http://vip.stock.finance.sina.com.cn/corp/go.php/vCI_StockStructure/stockid/002343.phtml")
                .execute().handleResponse(new StringResponseHandler(NielConstants.GBK));

        Document doc = Jsoup.parse(result, NielConstants.GBK_STRING);
        Element content = doc.getElementById("StockStructureNewTable0");
        //logger.info(LogMessageBuilder.MESSAGE_HOLDER,content.outerHtml());
        Elements trs = content.select("tr");
        for (int i = 0; i < trs.size(); i++) {
            Elements tds = trs.get(i).select("td");
            System.out.print("第" + i + "行：");
            for (int j = 0; j < tds.size(); j++) {
                String txt = tds.get(j).text();
                System.out.print("第" + j + "列：" + txt);
                System.out.print(":");
            }
            System.out.println("");
        }

        StockStructureParse stockStructureParse = new StockStructureParse();
        stockStructureParse.parseStockStructure(result);
    }
}
