package com.ssm.crud.mapper;

import com.ssm.crud.domain.Department;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentMapper {

    @Select("select * from tbl_dept where dept_id = #{id}")
    @Results(id = "deptMap",
        value = {
            @Result(id = true, column = "dept_id", property = "id"),
            @Result(column = "dept_name", property = "name")
        })
    Department getDepartmentById(Integer id);

}
