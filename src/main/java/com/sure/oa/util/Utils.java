package com.sure.oa.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sure.oa.base.PageParam;
import com.sure.oa.base.QueryAction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    //第一个<T>定义泛型T，即类型变量，表示数据记录的类型；第二个<T>使用已定义的泛型T
    public static <T> Map<String, Object> getPage(PageParam pageParam, QueryAction<T> queryAction){
        PageHelper.startPage(pageParam); //（必须紧跟查询之前）在执行查询之前使用PageHelper设置分页参数
        List<T> list = queryAction.query(); //此时该查询会自动分页，即SQL已经改变，加上了limit，执行结果是某一个数据记录
        PageInfo<T> pageInfo = new PageInfo<>(list); //（必须紧跟查询之后）以某页数据记录为参数，创建pageInfo对象，该对象已封装好分页信息
        Map<String, Object> page = new HashMap<>();
        page.put("curr", pageInfo.getPageNum()); //当前页
        page.put("first", 1); //首页
        page.put("pre", pageInfo.getPrePage()); //上页
        page.put("next", pageInfo.getNextPage()); //下页
        page.put("last", pageInfo.getPages()); //尾页
        page.put("pgSize", pageInfo.getPageSize()); //每页最大允许记录数
        page.put("total", pageInfo.getTotal()); //总记录数
        page.put("pgTotal", pageInfo.getPages()); //总页数
        page.put("currSize", pageInfo.getSize()); //当前页实际记录数
        page.put("rows", pageInfo.getList()); //当前页数据记录
        return page;
    }
}
