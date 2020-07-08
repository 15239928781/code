package com.irs.service;
import com.irs.pojo.Company;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;

import javax.servlet.http.HttpServletRequest;


public interface CompanyService {
    Company findCompanyList(Integer id);

    void insCompany(Company company);

    void delCompanyByPid(Integer id);

    void updCompany(Company company);

    ResultUtil getCompanyList(Integer page, Integer limit);

    Company selectById(int i);

    WxResult companyList(HttpServletRequest request);
}