package cn.jiyun.Service;


import cn.jiyun.Mapper.EmpMapper;
import cn.jiyun.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmpService {
    @Autowired
    private EmpMapper empMapper;
    public void addEmp(Emp emp){
        empMapper.addEmp(emp);
    }
    public List<Emp> findAll(){

        return empMapper.findAll();
    }
    public void delEmpById(Integer eid){
        empMapper.delEmpById(eid);
    }
    public Emp findById(Integer eid){
        return empMapper.findById(eid);
    }
    public void updateEmp(Emp emp){
        empMapper.updateEmp(emp);
    }
}
