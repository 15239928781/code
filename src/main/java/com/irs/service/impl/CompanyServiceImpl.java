package com.irs.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.irs.mapper.CompanyMapper;
import com.irs.pojo.CommentExample;
import com.irs.pojo.Company;


import com.irs.pojo.CompanyExample;
import com.irs.service.CompanyService;

import com.irs.util.HtmlUtils;
import com.irs.util.ResultUtil;
import com.irs.util.WxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyMapper companyMapper;


    @Override
    public Company findCompanyList(Integer id) {

        Company company=companyMapper.selectByPrimaryKey(id);

        return company;
    }

    @Override
    public void insCompany(Company company) {
        companyMapper.insert(company);
    }

    @Override
    public void delCompanyByPid(Integer id) {
        companyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updCompany(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
    }

    @Override
    public ResultUtil getCompanyList(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        CompanyExample example=new CompanyExample();
        example.setOrderByClause("id desc");
        List<Company> companyList=companyMapper.selectByExample(example);
        PageInfo<Company> pageInfo=new PageInfo<>(companyList);
        ResultUtil resultUtil = new ResultUtil();
        resultUtil.setCode(0);
        resultUtil.setCount(pageInfo.getTotal());
        resultUtil.setData(pageInfo.getList());
        return resultUtil;
    }

    @Override
    public Company selectById(int i) {
        return companyMapper.selectByPrimaryKey(i);
    }

    @Override
    public WxResult companyList(HttpServletRequest request) {
        String saveUrl=request.getScheme() + "://"+request.getServerName()+":" +
                request.getServerPort();
       CompanyExample example=new CompanyExample();
       example.setOrderByClause("id desc");
        CompanyExample.Criteria criteria=example.createCriteria();
        List<Company> companyList=companyMapper.selectByExample(example);
       /* if (companyList.size()>0){
            if(companyList.get(0).getCompanyDesc()!=null && !"".equals(companyList.get(0).getCompanyDesc())){
                String newStr= HtmlUtils.replaceHtmlTag(companyList.get(0).getCompanyDesc(),"img", "src", "src=\""+saveUrl+"", "\"");
                companyList.get(0).setCompanyDesc(newStr);
            }
        }*/
        return WxResult.ok(companyList.get(0));
    }


}
