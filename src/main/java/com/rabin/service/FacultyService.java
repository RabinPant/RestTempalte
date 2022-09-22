package com.rabin.service;

import com.rabin.dto.CourseRequestDTO;
import com.rabin.dto.CourseResponseDTO;
import com.rabin.dto.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FacultyService {

    private final static String BASE_URL ="http://localhost:9090";

    @Autowired
    private RestTemplate restTemplate;

    public ServiceResponse<CourseResponseDTO> addNewCourseToDashboard(CourseRequestDTO courseRequestDTO){
        return restTemplate.postForObject(BASE_URL+"/course",courseRequestDTO,ServiceResponse.class);
    }

    public ServiceResponse<List<CourseResponseDTO>> fetchAllCourses(){
        return restTemplate.getForObject(BASE_URL+"/course",ServiceResponse.class);
    }

    public ServiceResponse<CourseResponseDTO> findCourseById(Integer courseId){
        return restTemplate.getForObject(BASE_URL+"/course/search/path"+courseId,ServiceResponse.class);
    }

    public ServiceResponse<CourseResponseDTO> findCourseByIdusingRequestParam(Integer courseId){

        Map<String,Integer> requestMap = new HashMap<>();
        requestMap.put("courseId",courseId);
        return restTemplate.getForObject(BASE_URL+"/course/search/request",ServiceResponse.class,requestMap);

    }

    public void updateCourseInDashboard(int courseId, CourseRequestDTO courseRequestDTO){
        restTemplate.put(BASE_URL+"/course/"+courseId,courseRequestDTO);
    }
    public void deleteCourseFromDashBoard(int courseId){
        restTemplate.delete(BASE_URL+"/course/"+courseId);
    }
}
