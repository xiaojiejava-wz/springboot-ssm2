package cn.jiyun.Mapper;

import cn.jiyun.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface DeptMapper {

    List<Dept> findAll();
}
