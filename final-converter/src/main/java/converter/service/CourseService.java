package converter.service;

import converter.entity.Course;
import org.w3c.dom.Element;

import java.util.List;

public interface CourseService {

	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void save(Course course);
	
	public void deleteById(int theId);

	public void forming();

	public void recursiveParsing (Element element);
	
}
