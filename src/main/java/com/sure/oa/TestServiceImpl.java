package com.sure.oa;

import com.sure.oa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//说明这是一个业务（模型）组件，并受Spring管理
public class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Override
    //控制器中通过调用这个方法获得DAO的查询结果
    public List<User> getUserList() {
        return testDao.findUserList();
    }
}
