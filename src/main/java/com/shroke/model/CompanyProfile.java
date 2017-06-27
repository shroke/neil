package com.shroke.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by shroke on 2017/6/24.
 */
public class CompanyProfile {
    //公司名称
    private String companyName;
    //公司英文名称
    private String companyEnglishName;
    //上市市场
    private String market;
    //上市日期
    private Date listedDate;
    //发行价格
    private BigDecimal issuePrice;
    //主承销商
    private String underwritingManager;
    //成立日期
    private Date establishmentDate;
    //注册资本
    private BigDecimal registeredCapital;
    //机构类型
    private String organizationType;
    //组织形式
    private String typeOfOrganization;
    //董事会秘书
    private String secretary;
    //公司电话
    private String companyTel;
    //董秘电话
    private String secretaryTel;
    //公司传真
    private String companyFax;
    //董秘传真
    private String secretaryFax;
    //公司电子邮箱
    private String companyEmail;
    //董秘电子邮箱
    private String secretaryEmail;
    //公司网址
    private String webSite;
    //邮政编码
    private String zipcode;
    //信息披露网址
    private String informationDisclosureSite;
    //证券简称更名历史
    private String nameHistory;
    //注册地址
    private String registeredAddress;
    //办公地址
    private String officeAddress;
    //公司简介
    private String companyDesc;
    //经营范围
    private String businessInformation;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEnglishName() {
        return companyEnglishName;
    }

    public void setCompanyEnglishName(String companyEnglishName) {
        this.companyEnglishName = companyEnglishName;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public Date getListedDate() {
        return listedDate;
    }

    public void setListedDate(Date listedDate) {
        this.listedDate = listedDate;
    }

    public BigDecimal getIssuePrice() {
        return issuePrice;
    }

    public void setIssuePrice(BigDecimal issuePrice) {
        this.issuePrice = issuePrice;
    }

    public String getUnderwritingManager() {
        return underwritingManager;
    }

    public void setUnderwritingManager(String underwritingManager) {
        this.underwritingManager = underwritingManager;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    public BigDecimal getRegisteredCapital() {
        return registeredCapital;
    }

    public void setRegisteredCapital(BigDecimal registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getTypeOfOrganization() {
        return typeOfOrganization;
    }

    public void setTypeOfOrganization(String typeOfOrganization) {
        this.typeOfOrganization = typeOfOrganization;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    public String getSecretaryTel() {
        return secretaryTel;
    }

    public void setSecretaryTel(String secretaryTel) {
        this.secretaryTel = secretaryTel;
    }

    public String getCompanyFax() {
        return companyFax;
    }

    public void setCompanyFax(String companyFax) {
        this.companyFax = companyFax;
    }

    public String getSecretaryFax() {
        return secretaryFax;
    }

    public void setSecretaryFax(String secretaryFax) {
        this.secretaryFax = secretaryFax;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getSecretaryEmail() {
        return secretaryEmail;
    }

    public void setSecretaryEmail(String secretaryEmail) {
        this.secretaryEmail = secretaryEmail;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getInformationDisclosureSite() {
        return informationDisclosureSite;
    }

    public void setInformationDisclosureSite(String informationDisclosureSite) {
        this.informationDisclosureSite = informationDisclosureSite;
    }

    public String getNameHistory() {
        return nameHistory;
    }

    public void setNameHistory(String nameHistory) {
        this.nameHistory = nameHistory;
    }

    public String getRegisteredAddress() {
        return registeredAddress;
    }

    public void setRegisteredAddress(String registeredAddress) {
        this.registeredAddress = registeredAddress;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getCompanyDesc() {
        return companyDesc;
    }

    public void setCompanyDesc(String companyDesc) {
        this.companyDesc = companyDesc;
    }

    public String getBusinessInformation() {
        return businessInformation;
    }

    public void setBusinessInformation(String businessInformation) {
        this.businessInformation = businessInformation;
    }

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
