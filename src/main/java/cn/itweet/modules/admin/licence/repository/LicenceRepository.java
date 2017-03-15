package cn.itweet.modules.admin.licence.repository;

import cn.itweet.modules.admin.licence.entity.Licence;
import cn.itweet.modules.admin.user.entry.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * 说明：
 * 包名：cn.itweet.modules.admin.licence
 * 项目名：itweet-boot
 * 创建人：孙大飞
 * 创建时间：2017/3/14.
 */
@Repository
public interface LicenceRepository extends CrudRepository<Licence, Integer> {
}
