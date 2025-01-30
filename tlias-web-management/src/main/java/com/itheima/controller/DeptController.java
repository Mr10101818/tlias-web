package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list() {
        log.info("查询全部部门的数据");
        //System.out.println("查询全部部门的数据");
        List<Dept> deptList = deptService.findall();
        return Result.success(deptList);
    }
//    @DeleteMapping("/depts")
//    public  Result delete(@RequestParam(value = "id", required = false)  Integer depId) {
//        System.out.println("删除部门的数据"+ depId);
//        return Result.success();
    @DeleteMapping
    public  Result delete(Integer id) {
        log.info("删除部门的数据"+ id);
        //System.out.println("删除部门的数据"+ id);
        deptService.deleteById(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("新增部门的数据"+ dept);
        System.out.println("新增部门的数据"+ dept);
        deptService.add(dept);
        return Result.success();

    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("查询部门的数据"+ id);
        //System.out.println("查询部门的数据"+ id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门的数据"+ dept);
        //System.out.println("修改部门的数据"+ dept);
        deptService.update(dept);
        return Result.success();
    }
}
