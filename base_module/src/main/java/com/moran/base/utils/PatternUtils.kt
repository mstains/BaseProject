package com.moran.base.utils

import java.util.regex.Pattern


/**
 * @Package:
 * @ClassName:
 * @Description:    正则表达式工具类
 * @Author:         moran
 * @CreateDate:     2019-12-12 10:56
 * @UpdateUser:     更新者：moran
 * @UpdateDate:     2019-12-12 10:56
 * @UpdateRemark:   更新说明：
 * @Version:        1.0
 */
class PatternUtils {


    companion object {


        /**
         * 判断字符串是不是纯数字
         * @method
         * @date: 2019-12-12 11:00
         * @author: moran
         * @param str
         * @return
         */
        fun isNumeric(str: String): Boolean {

            val pattern = Pattern.compile("[0-9]+")

            val isNum = pattern.matcher(str)

            return isNum.matches()

        }


    }


}