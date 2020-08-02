package cn.jiyun.Service;

import cn.jiyun.Mapper.DeptMapper;
import cn.jiyun.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptService {

    @Autowired
    private DeptMapper deptMapper;
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

}
