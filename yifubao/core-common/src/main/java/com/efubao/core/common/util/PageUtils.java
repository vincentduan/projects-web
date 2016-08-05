/**
 * 
 */
package com.efubao.core.common.util;

import java.lang.reflect.Method;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.ReflectionUtils;

import com.efubao.common.util.Page;

/**
 * 分页工具类
 * 
 */
public abstract class PageUtils {

    /**
     * 设置page信息到example
     * eg:
     * <pre><code>
             public Page<GoGoods> findBySearch(List<Long> goodsIds, List<String> htNumbers, Page<GoGoods> page) {
                List<GoGoods> list = null;
                GoGoodsExample c = new GoGoodsExample();
                GoGoodsExample.Criteria ca = c.createCriteria();
                if (goodsIds != null && goodsIds.size() > 0) {
                    ca.andGoodsIdIn(goodsIds);
                }
                if (htNumbers != null && htNumbers.size() > 0) {
                    ca.andHtnumberIn(htNumbers);
                }
        //      if (page == null) {
        //          page = new Page<GoGoods>();
        //      } else {
        //          page2Exam(page, c);
        //      }
                page = PageUtils.setPageToExample(page, c);
                int total = goGoodsMapper.countByExample(c);
                list = goGoodsMapper.selectByExample(c);
                page.setTotalCount(total);
                page.setResult(list);
                return page;
            }
     * </code></pre>
     * @param page 分页对象
     * @param example domain对应的example类实例
     * @return 若参数page为null，则返回一个新建的Page对象（page = new Page<T>(8)），否则返回传入的参数page
     */
    public static <T> Page<T> setPageToExample(Page<T> page, Object example) {
        if (null == example) {
            throw new IllegalArgumentException("the 'example' argument can't be null");
        }
        if (null == page) {
            page = new Page<T>(8);
        }

        try {
            Method setLimitStart = example.getClass().getMethod("setLimitStart", int.class);
            ReflectionUtils.invokeMethod(setLimitStart, example,
                    page.getPageSize() * (page.getPageNo() - 1));

            Method setLimitEnd = example.getClass().getMethod("setLimitEnd", int.class);
            ReflectionUtils.invokeMethod(setLimitEnd, example, page.getPageSize());

            if (page.getOrderBy() != null && page.getOrderBy().length() < 20) {
                Method setOrderByClause = example.getClass().getMethod("setOrderByClause",
                        String.class);
                ReflectionUtils.invokeMethod(setOrderByClause, example,
                        StringEscapeUtils.escapeSql(page.getOrderBy()));
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException("Method not found: " + e.getMessage());
        }
        return page;
    }
}
