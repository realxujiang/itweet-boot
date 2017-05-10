package cn.itweet.modules.admin.course.repository;

import cn.itweet.common.repository.BaseRepository;
import cn.itweet.modules.admin.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 09/05/2017.
 */
@Repository
@Transactional
public interface CourseRepository extends BaseRepository<Course,Integer> {

    @Query("select c from Course c where c.title like %:title%")
    Page<Course> searchByTitle(@Param("pageable") Pageable pageable, @Param("title") String title);

    Course findByTitle(String title);

    Course findByTag(String tag);
}
