package com.rabin.controller;

import com.rabin.dto.CourseRequestDTO;
import com.rabin.dto.CourseResponseDTO;
import com.rabin.dto.ServiceResponse;
import com.rabin.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty-service")
public class FacultyController {

    @Autowired
    private FacultyService service;

    @PostMapping("/addNewCourse")
    public ServiceResponse<CourseResponseDTO> addNewCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        return service.addNewCourseToDashboard(courseRequestDTO);
    }
    
    @GetMapping("/allCourses")
    public ServiceResponse<List<CourseResponseDTO>> viewAllCourses(){
        return service.fetchAllCourses();
    }
    @GetMapping("/getCourse/{id}")
    public ServiceResponse<CourseResponseDTO> getCourseById(@PathVariable Integer id){
        return service.findCourseById(id);
    }
    @GetMapping("/getCourse/request")
    public ServiceResponse<CourseResponseDTO>getCourseByIdRequestParam(@RequestParam Integer courseId){
        return service.findCourseByIdusingRequestParam(courseId);
    }

    @PutMapping("/updateCourse/{courseId}")
    public ServiceResponse<CourseResponseDTO> updateCourse(@PathVariable int courseId, @RequestBody CourseRequestDTO courseRequestDTO){
        service.updateCourseInDashboard(courseId,courseRequestDTO);
        return service.findCourseById(courseId);
    }

    @DeleteMapping("/delete")
    public String deleteCourse(@PathVariable int courseId){
        service.deleteCourseFromDashBoard(courseId);
        return "Course deleted successfully with id"+ courseId;
    }
}
