package com.example.department.controller;

import com.example.department.model.Department;
import com.example.department.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    // POST /departments
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return service.addDepartment(department);
    }

    // GET /departments
    @GetMapping
    public List<Department> getDepartments() {
        return service.getAllDepartments();
    }

    // PUT /departments/{id}
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable int id,
                                       @RequestBody Department department) {
        return service.updateDepartment(id, department);
    }

    // DELETE /departments/{id}
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return service.deleteDepartment(id);
    }
}
