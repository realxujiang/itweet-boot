package cn.itweet.modules.admin.course.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.course.entity.Course;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by whoami on 09/05/2017.
 */
public interface CourseService {

    Page<Course> list(Integer page);

    /**
     * 获取Course教程最新的TopN列表
     * @param topNum
     * @return
     */
    List<Course> getCourseTopN(Integer topNum);

    Page<Course> searchByTitle(Integer page, String title);

    List<Course> list();

    Course findById(Integer id);

    Course findByTitle(String title);

    void add(Course course) throws SystemException;

    void update(Course course);

    void deleteById(Integer id);
}
