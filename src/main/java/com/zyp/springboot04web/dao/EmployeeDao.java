package com.zyp.springboot04web.dao;

import com.zyp.springboot04web.pojo.Department;
import com.zyp.springboot04web.pojo.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Service
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees=null;
    private DepartmentDao departmentDao;

    static {
        employees=new HashMap<Integer,Employee>();//创建一个表
        employees.put(101,new Employee(1001,"AA","23345667@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002,"BB","23345668@qq.com",1,new Department(102,"市场部")));
        employees.put(1003,new Employee(1003,"CC","23345669@qq.com",0,new Department(103,"教研部")));
        employees.put(1004,new Employee(1004,"DD","23345665@qq.com",0,new Department(104,"运营部")));
        employees.put(1005,new Employee(1005,"EE","23345664@qq.com",1,new Department(105,"后勤部")));
    }
    //主键自增
    private static Integer initId=1006;
    //增加一个员工
    public void save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
   //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id查询
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工通过id
    public void deleteById(Integer id){
        employees.remove(id);
    }
}
