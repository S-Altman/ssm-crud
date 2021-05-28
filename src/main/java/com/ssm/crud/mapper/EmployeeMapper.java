package com.ssm.crud.mapper;

import com.ssm.crud.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {


    @Select("select * from tbl_emp where emp_id = #{id}")
    @Results(id = "empMap",
        value = {
            @Result(id = true, column = "emp_id", property = "id"),
            @Result(column = "emp_name", property = "name"),
            @Result(column = "gender", property = "gender"),
            @Result(column = "email", property = "email"),
            @Result(column = "d_id", property = "department",
                    one = @One(select = "com.ssm.crud.mapper.DepartmentMapper.getDepartmentById",
                    fetchType = FetchType.EAGER))
        })
    Employee getEmployeeById(Integer id);

    @Select("select * from tbl_emp")
    @ResultMap("empMap")
    List<Employee> listEmployees();

    @Insert("insert into tbl_emp values(#{id}, #{name}, #{gender}, #{email}, #{department.id})")
    void insertEmployee(Employee employee);

    @Delete("delete from tbl_emp where emp_id = #{id}")
    void deleteEmployeeById(Integer id);

    @Update("update tbl_emp set emp_name = #{name}, gender = #{gender}, email = #{email}, " +
            "d_id = #{department.id} where emp_id = #{id}")
    void updateEmployee(Employee employee);
}
