/*package com.webstore.services;

import com.webstore.entities.CourseEntity;
import com.webstore.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public CourseEntity getCourse(long id) throws CourseNotFoundException {
        Optional<CourseEntity> result = repository.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new CourseNotFoundException("Could not find course with id="+id);
    }

    public void deleteCourse(long id) throws CourseNotFoundException {
        Long count = repository.countCourseEntityByCourseId(id);
        if(count == null || count == 0){
            throw new CourseNotFoundException("Could not find course with id="+count);
        }
        repository.deleteById(id);
    }

    public List<CourseEntity> getAllCourses(){
        return (List<CourseEntity>) repository.findAll();
    }
}

 */
