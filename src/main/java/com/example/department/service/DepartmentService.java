package com.example.department.service;

import com.example.department.model.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private List<Department> departments = new ArrayList<>();
    private int count = 1;

    // CREATE
    public Department addDepartment(Department department) {
        department.setId(count++);
        departments.add(department);
        return department;
    }

    // READ ALL
    public List<Department> getAllDepartments() {
        return departments;
    }

    // UPDATE
    public Department updateDepartment(int id, Department updatedDept) {
        for (Department dept : departments) {
            if (dept.getId() == id) {
                dept.setName(updatedDept.getName());
                dept.setLocation(updatedDept.getLocation());
                return dept;
            }
        }
        return null;
    }

    // DELETE
    public String deleteDepartment(int id) {
        departments.removeIf(dept -> dept.getId() == id);
        return "Department deleted successfully";
    }
}
