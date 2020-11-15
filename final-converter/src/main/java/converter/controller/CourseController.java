package converter.controller;

import converter.entity.Convertation;
import converter.entity.Course;
import converter.service.ConvertationService;
import converter.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;
    private ConvertationService convertationService;


    @Autowired
    public CourseController(CourseService courseService, ConvertationService convertationService) {

        this.courseService = courseService;
        this.convertationService = convertationService;

    }



    @GetMapping("/list")
    public String listCourses(Model model) {

        List<Course> theCourses = courseService.findAll();
        model.addAttribute("courses", theCourses);
        return "courses/list-courses";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {

        Course course = new Course();
        model.addAttribute("course", course);

        return "courses/course-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("courseId") int courseId, Model model) {

        Course course = courseService.findById(courseId);

        model.addAttribute("course", course);

        return "courses/course-form";

    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course course) {

        System.out.println(course);
        courseService.save(course);

        return "redirect:/courses/list";

    }

    @GetMapping("/delete")
    public String deleteCourse(@RequestParam("courseId") int courseId) {

        courseService.deleteById(courseId);

        return "redirect:/courses/list";
    }

    @GetMapping("/convertForm")
    public String convert( Model model )  {

        Convertation convertation = new Convertation();
        model.addAttribute(convertation);
        model.addAttribute("convertation", convertation);
        model.addAttribute("courses", courseService.findAll());

        return "courses/convert-form";

    }


    @PostMapping("/convertResult")
    public  String result(
                         Model model,
                         @RequestParam(value = "from", required = false) String from,
                         @RequestParam(value = "to", required = false) String to,
                         @RequestParam(value = "number") String numberS) {

        Course courseFrom = courseService.findById(Integer.parseInt(from));
        Course courseTo = courseService.findById(Integer.parseInt(to));

        try {
                double number = Double.parseDouble(numberS);
                if(number <= 0) return convert(model);
                double res = number * ((courseFrom.getValutevalue() / courseTo.getValutevalue())) * 10000 / 10000;
                Convertation convertation = new Convertation
                        (courseFrom.getValutename(), courseTo.getValutename(),
                                courseTo.getId(), courseFrom.getId(), courseFrom.getValutevalue(),
                                courseTo.getValutevalue(), courseFrom.getToday(), courseFrom.getCharcode(),
                                courseTo.getCharcode(), number, res);

                model.addAttribute(convertation);
                model.addAttribute("from", courseFrom);
                model.addAttribute("to", courseTo);

                convertationService.save(convertation);

                return "courses/result";

        } catch (Exception e) {

            return convert(model);
        }
    }

    @GetMapping("/history")
    public String history(Model model) {

        List<Convertation>convertations = convertationService.findAll();

        List<LocalDate>dates = new ArrayList<>();
        List<String>froms = new ArrayList<>();
        List<String>tos = new ArrayList<>();

        for(Convertation c : convertations) {

            String dateInString = c.getConvertationday();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
            LocalDate dateTime = LocalDate.parse(dateInString, formatter);
            dates.add(dateTime);

            froms.add(c.getValutefrom());
            tos.add(c.getValuteto());

        }

        model.addAttribute(convertations);
        model.addAttribute(dates);
        model.addAttribute(froms);
        model.addAttribute(tos);

        return "courses/history";

    }

}











