package cn.itweet.modules.admin.document.repository;

import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by whoami on 22/04/2017.
 */
@Repository
@Transactional
public interface DocumentRepository extends JpaRepository<Document,Integer> {

    @Query(value = "select rule_filename from document where id=?1",nativeQuery = true)
    String loadRuleFilenameById(Integer id);

    @Query(value = "delete from document where rule_filename=?1",nativeQuery = true)
    @Modifying
    void deleteByRuleFilename(String ruleFilename);
}
