package com.shroke.parsing;

import com.shroke.model.CompanyProfile;
import com.shroke.util.LogMessageBuilder;
import com.shroke.util.NielConstants;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * Created by shroke on 2017/6/17.
 */
@Component
public class StockProfileParse extends BaseProfileParse{

    private static final Logger logger = LoggerFactory.getLogger(StockProfileParse.class);

    public CompanyProfile processSource(String source) throws IOException{
        File file = new File(source);
        Document doc = Jsoup.parse(file,NielConstants.GBK_STRING);
        //Document doc =  Jsoup.connect("").get();
        Element content = doc.getElementById("comInfo1");

        CompanyProfile companyProfile = new CompanyProfile();
        companyProfile.setCompanyName(getTableValue(content,0,1));
        companyProfile.setCompanyEnglishName(getTableValue(content,1,1));
        companyProfile.setMarket(getTableValue(content,2,1));
        companyProfile.setListedDate(parseSqlDate(getTableValue(content,2,3)));
        companyProfile.setIssuePrice(parseIssuePrice(getTableValue(content,3,1)));
        companyProfile.setUnderwritingManager(getTableValue(content,3,3));
        companyProfile.setEstablishmentDate(parseSqlDate(getTableValue(content,4,1)));
        companyProfile.setRegisteredCapital(parseRegisteredCapital(getTableValue(content,4,3)));
        companyProfile.setOrganizationType(getTableValue(content,5,1));
        companyProfile.setTypeOfOrganization(getTableValue(content,5,3));
        companyProfile.setSecretary(getTableValue(content,6,1));
        companyProfile.setCompanyTel(getTableValue(content,6,3));
        companyProfile.setSecretaryTel(getTableValue(content,8,1));
        companyProfile.setCompanyFax(getTableValue(content,8,3));
        companyProfile.setSecretaryFax(getTableValue(content,10,1));
        companyProfile.setCompanyEmail(getTableValue(content,10,3));
        companyProfile.setSecretaryEmail(getTableValue(content,12,1));
        companyProfile.setWebSite(getTableValue(content,12,3));
        companyProfile.setZipcode(getTableValue(content,14,1));
        companyProfile.setInformationDisclosureSite(getTableValue(content,14,3));
        companyProfile.setNameHistory(getTableValue(content,16,1));
        companyProfile.setRegisteredAddress(getTableValue(content,17,1));
        companyProfile.setOfficeAddress(getTableValue(content,18,1));
        companyProfile.setCompanyDesc(getTableValue(content,19,1));
        companyProfile.setBusinessInformation(getTableValue(content,20,1));

        logger.info(LogMessageBuilder.MESSAGE_HOLDER,companyProfile);



        //stockMapper.insert(stock);
        return companyProfile;
    }

    public static void main(String[] agrs) throws IOException{

        StockProfileParse stockBaseParse = new StockProfileParse();
        System.out.println(stockBaseParse.parseSqlDate("2017-06-24"));
        System.out.println(stockBaseParse.parseIssuePrice("1234"));
        System.out.println(stockBaseParse.parseRegisteredCapital("51234万元"));
        //System.out.println(File.);

        String path = StockProfileParse.class.getClass().getResource(NielConstants.FILE_ROOT_PATH).getPath();
        logger.info(LogMessageBuilder.MESSAGE_HOLDER,path);
        String filePath = path +  "gszl.shtml";
        logger.info(LogMessageBuilder.MESSAGE_HOLDER,filePath);
        File file = new File(filePath);
        Document doc = Jsoup.parse(file,NielConstants.GBK_STRING);
        Element content = doc.getElementById("comInfo1");
        //logger.info(LogMessageBuilder.MESSAGE_HOLDER,content.outerHtml());
        Elements trs = content.select("tr");
        for(int i=0; i<trs.size(); i++){
            Elements tds = trs.get(i).select("td");
            System.out.print("第"+i+"行：");
            for(int j=0; j<tds.size();j++){
                String txt = tds.get(j).text();
                System.out.print("第"+j+"列：" + txt);
                System.out.print(":");
            }
            System.out.println("");
        }
        stockBaseParse.processSource(filePath);

    }
}
