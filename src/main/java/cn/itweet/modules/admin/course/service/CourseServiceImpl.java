package cn.itweet.modules.admin.course.service;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.SimplePageBuilder;
import cn.itweet.common.utils.SimpleSortBuilder;
import cn.itweet.modules.admin.course.entity.Course;
import cn.itweet.modules.admin.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by whoami on 09/05/2017.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ItweetProperties itweetProperties;

    @Override
    public Page<Course> list(Integer page) {
        return courseRepository.findAll(SimplePageBuilder.generate(page,itweetProperties.getPagSize(), SimpleSortBuilder.generateSort("createDate_d")));
    }

    @Override
    public List<Course> getCourseTopN(Integer topNum) {
        return courseRepository.findAll(SimplePageBuilder.generate(0,topNum, SimpleSortBuilder.generateSort("createDate_d"))).getContent();
    }

    @Override
    public Page<Course> searchByTitle(Integer page, String title) {
        return courseRepository.searchByTitle(SimplePageBuilder.generate(page,itweetProperties.getPagSize(), SimpleSortBuilder.generateSort("createDate_d")),title);
    }

    @Override
    public List<Course> list() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course findByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Override
    public void add(Course course) throws SystemException {
        Course c1 = courseRepository.findByTag(course.getTag());
        if (c1 != null)
            throw new SystemException("教程添加失败，教程标签已经存在，不可重复添加！");

        if (course.getCoverPicture() == null || "".equals(course.getCoverPicture()))
            course.setCoverPicture("no-images.png");

        if (course.getSlideOne() == null || "".equals(course.getSlideOne()))
            course.setSlideOne("no-images.png");

        if (course.getSlideTwo() == null || "".equals(course.getSlideTwo()))
            course.setSlideTwo("no-images.png");

        course.setCreateDate(new Date());
        courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        Course c1 = courseRepository.findOne(course.getId());

        if (c1 == null) return;

        c1.setCoverPicture(course.getCoverPicture());
        c1.setTitle(course.getTitle());
        c1.setClassify(course.getClassify());
        c1.setContent(course.getContent());
        c1.setDescription(course.getDescription());
        c1.setSlideOne(course.getSlideOne());
        c1.setSlideTwo(course.getSlideTwo());
        c1.setTag(course.getTag());
        c1.setWork(course.getWork());
        c1.setCreateDate(new Date());
        courseRepository.save(c1);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.delete(id);
    }

}
