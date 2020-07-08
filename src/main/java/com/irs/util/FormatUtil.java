package com.irs.util;

import java.text.DecimalFormat;

/**
 * @author zc
 * @create 2019 - 03 - 13
 **/
public  class FormatUtil {

     /*
      * DecimalFormat保留两位小数
      */
     public static String m2(Double f) {
         DecimalFormat df = new DecimalFormat("#.00");
         return df.format(f);
     }
}
