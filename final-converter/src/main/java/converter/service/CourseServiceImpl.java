package converter.service;

import converter.dao.CourseRepository;
import converter.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CourseServiceImpl implements CourseService {

	CourseRepository courseRepository;

	Date date = Calendar.getInstance().getTime();
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	String strDate = dateFormat.format(date);

	@Autowired
	public CourseServiceImpl (CourseRepository courseRepository) {

		this.courseRepository = courseRepository;

	}


	@Override
	public List<Course> findAll() {

		List<Course> courses = courseRepository.findAllByOrderByCharcode();
		boolean isNotToday = false;

		if (courses.size() == 0 || courses.get(0).getToday() == null) {
			forming();
			return courses;
		}

		for (Course c : courses) {

			if (!(c.getToday().equals(strDate))) {
				forming();
				return courses;

			}
		}

		return courses;
	}


	@Override
	public Course findById(int theId) {

		Optional<Course> course = courseRepository.findById(theId);
		Course tempCourse = null;

		if(course.isPresent()) {
			tempCourse = course.get();
			return tempCourse;
		}

		else throw new RuntimeException("there is no such id");

	}

	@Override
	public void save(Course course) {

		courseRepository.save(course);

	}

	@Override
	public void deleteById(int theId) {

		courseRepository.deleteById(theId);

	}

	@Override
	public void forming() {

		try {
			URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new URL("http://www.cbr.ru/scripts/XML_daily.asp").openStream());

			Element element = document.getDocumentElement();
			recursiveParsing(element);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void recursiveParsing (Element element) {

			if (element.getChildNodes().getLength() > 1) {

					NodeList nodeList = element.getChildNodes();

					List<String>list = new ArrayList<>();

					for(int i = 0; i<nodeList.getLength(); i++) {

						if(element.getTagName().equals("Valute"))
								list.add(nodeList.item(i).getTextContent());

						if(nodeList.item(i) instanceof Element) {

								Element innerElement = (Element) nodeList.item(i);
								recursiveParsing(innerElement);
						}
					}


					int id;
					String charcode;
					int nominal;
					String valutename;
					double valutevalue;
					String today = strDate;


					if (element.getTagName().equals("Valute")) {

							id = Integer.parseInt(list.get(0));
							charcode = list.get(1);
							nominal = Integer.parseInt(list.get(2));
							valutename = list.get(3);
							valutevalue = Double.parseDouble((list.get(4).replace(",",".")));

							Course course = new Course(id, charcode, nominal, valutename, valutevalue, today);

							courseRepository.save(course);
					}
			}
	}

}








