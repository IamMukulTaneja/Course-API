package io.javabrains.springbootstarter.course;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
class CourseController {
	
	@Autowired
	private CourseService courseService;
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id)
	{
		return courseService.getallCourses(id);
	
	}
	@RequestMapping("/topics/{topicID}/courses/{id}")
	public Course getCourse(@PathVariable String id)
	{
		return courseService.getCourse(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicID}/courses")
	public void addCourse(@RequestBody Course course,@PathVariable String topicID)
	{
	    course.setTopic(new Topic(topicID,"",""));
		courseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicID}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicID,@PathVariable String id)
	{
		 course.setTopic(new Topic(topicID,"",""));
		 courseService.updateCourse(course);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}

}
