package com.sure.oa.func.info.emp.impl;

import com.sure.oa.base.QueryAction;
import com.sure.oa.dto.EmpDto;
import com.sure.oa.func.info.emp.InfoEmpDao;
import com.sure.oa.model.Emp;

import java.util.List;

public class InfoEmpQueryActionImpl implements QueryAction<Emp> {

    private InfoEmpDao infoEmpDao;
    private EmpDto empDto;

    public InfoEmpQueryActionImpl(InfoEmpDao infoEmpDao, EmpDto empDto){
        this.infoEmpDao = infoEmpDao;
        this.empDto = empDto;
    }


    @Override
    public List<Emp> query() {
        return infoEmpDao.findEmpList(empDto);
    }
}
