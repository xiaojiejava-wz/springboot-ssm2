package cn.jiyun.Controller;

import cn.jiyun.Service.DeptService;
import cn.jiyun.Service.EmpService;
import cn.jiyun.pojo.Dept;
import cn.jiyun.pojo.Emp;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private EmpService empService;
    @Value("${file.upload.path}")
    private String filePath;

    @PostMapping("addEmp")
    public String addEmp(@ModelAttribute(value = "emp")Emp emp, @RequestParam(value = "file")MultipartFile file) throws IOException {
        //获取文件名称
        String filename = file.getOriginalFilename();
        File photoFile= new File(filePath, filename);
        //判断当前系统是否在上传路径，如果不存在则新建
        if(photoFile.getParentFile().exists()){
            photoFile.getParentFile().mkdirs();
        }
        file.transferTo(new File(filePath+File.separator+filename));
        emp.setPhoto("/img/"+filename);
        empService.addEmp(emp);
        //保存完员工数据跳转到展示页面
        return "redirect:/emp/findAll";


    }
    @GetMapping("findAll")
    public String findAll(Model model){
        List<Emp> emps = empService.findAll();
        System.out.println("cccc:"+emps);
        model.addAttribute("emps",emps);
        return "empList";
    }


    @GetMapping("test")
    @ResponseBody
    public String tet(){
        return "Hello World";
    }


    @GetMapping("toAddEmp")
    public String toAddEmp(Model model){
        List<Dept> depts = deptService.findAll();
        model.addAttribute("depts",depts);
        return "addEmp";
    }
    @GetMapping("delEmpById")
    public String delEmpById(@RequestParam(value = "eid")Integer eid){
        empService.delEmpById(eid);
        return "redirect:/emp/findAll";
    }
    @GetMapping("findById")
    public String findById(Integer eid,Model model){
        List<Dept> depts = deptService.findAll();
          Emp emp=empService.findById(eid);
        model.addAttribute("depts",depts);
       model.addAttribute("emp",emp);
        return "updateList";
    }
    @PostMapping("updateEmp")
    public String updateEmp(@ModelAttribute(value = "emp")Emp emp,@RequestParam(value = "file")MultipartFile file) throws IOException {
        //获取文件名称
        String filename = file.getOriginalFilename();
        File photoFile= new File(filePath, filename);
        //判断当前系统是否在上传路径，如果不存在则新建
        if(photoFile.getParentFile().exists()){
            photoFile.getParentFile().mkdirs();
        }
        file.transferTo(new File(filePath+File.separator+filename));
        emp.setPhoto("/img/"+filename);
        empService.updateEmp(emp);
        return "redirect:/emp/findAll";
    }

}
