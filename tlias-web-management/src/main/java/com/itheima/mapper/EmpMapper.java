package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {
    //@Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    //public Long count();
    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize}")
    //public List<Emp> list(Integer start,Integer pageSize);
    //@Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc ")
    /*public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);*/
    public List<Emp> list(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username,password,name,gender,phone,job,entry_date,dept_id,create_Time,update_Time) " +
            "values(#{username},#{password},#{name},#{gender},#{phone},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();
    @Select("select id,username,name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
