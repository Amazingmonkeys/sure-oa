package com.sure.oa.base;

import java.util.List;

//<T>定义泛型T，即类型变量，表示数据记录的类型
@FunctionalInterface //如果接口中只有一个方法，则可以使用该注解说明这是一个函数接口
public interface QueryAction<T> {

    List<T> query(); //执行查询，获得封装了T类型的数据记录
}
