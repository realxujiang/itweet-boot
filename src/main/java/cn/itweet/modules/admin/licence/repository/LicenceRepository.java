package cn.itweet.modules.admin.licence.repository;

import cn.itweet.modules.admin.licence.entity.Licence;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 说明：
 * 包名：cn.itweet.modules.admin.licence
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Repository
public interface LicenceRepository extends CrudRepository<Licence, Integer> {

    @Query(value = "select * from licence l  where l.l_company like CONCAT('%',:companyName,'%')",nativeQuery = true)
    public List<Licence> getByCompany(@Param("companyName") String companyName);

}
