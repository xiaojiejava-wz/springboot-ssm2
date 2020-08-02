package cn.jiyun.Mapper;

import cn.jiyun.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface EmpMapper{
    void addEmp(@Param("emp")Emp emp);
    List<Emp> findAll();
    void delEmpById(@Param(value = "eid") Integer eid);
    Emp findById(Integer eid);
    void updateEmp(@Param("emp")Emp emp);
}
