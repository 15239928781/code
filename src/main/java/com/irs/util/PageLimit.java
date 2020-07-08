package com.irs.util;


import java.util.List;

public class PageLimit {


public static  <T> List<T> page(List<T> shopProducts, Integer page, Integer limit ){

    //数据总数
    int totalCount = shopProducts.size();
//总的页数
    int pageCount = 0;
//每页显示的总数
    int endNum = limit;
//当前页码
    int startNum = page;
    /*计算出总共能分成多少页*/
    if (totalCount % endNum > 0) {      //数据总数和每页显示的总数不能整除的情况
        pageCount = totalCount / endNum + 1;
    } else{   //数据总数和每页显示的总数能整除的情况
        pageCount = totalCount / endNum;
    }
    if(totalCount > 0) {
        if (startNum <= pageCount) {
            if (startNum == 1) { //当前页数为第一页
                if (totalCount <= endNum) {  //数据总数小于每页显示的数据条数
//截止到总的数据条数(当前数据不足一页，按一页显示)，这样才不会出现数组越界异常
                    shopProducts = shopProducts.subList(0, totalCount);
                    return shopProducts;
                } else {
                    shopProducts = shopProducts.subList(0, endNum);
                    return shopProducts;
                }
            } else {//截取起始下标

                int fromIndex = (startNum - 1) * endNum;
//截取截止下标
                int toIndex = startNum * endNum; /*计算截取截止下标*/
                if ((totalCount - toIndex) % endNum >= 0) {

                    toIndex = startNum * endNum;
                } else {
                    toIndex = (startNum - 1) * endNum + (totalCount % endNum);
                }
                if (totalCount >= toIndex) {
                    shopProducts = shopProducts.subList(fromIndex, toIndex);
                    return shopProducts;
                }
            }
        } else {
            shopProducts = null;
            return shopProducts;
        }


    }
   return null;
}


}
