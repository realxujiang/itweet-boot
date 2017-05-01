package cn.itweet.modules.admin.document.repository;

import cn.itweet.common.repository.BaseRepository;
import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whoami on 22/04/2017.
 */
@Repository
@Transactional
public interface DocumentRepository extends BaseRepository<Document,Integer> {

    @Query(value = "select rule_filename from document where id=?1",nativeQuery = true)
    String loadRuleFilenameById(Integer id);

    @Query(value = "delete from document where rule_filename=?1",nativeQuery = true)
    @Modifying
    void deleteByRuleFilename(String ruleFilename);

    @Query("select d from Document d where d.columnd like %:columnd%")
    Page<Document> selectByColumnd(@Param("pageable") Pageable pageable, @Param("columnd") String columnd);

    /**
     * 继承自定义BaseRepository , 原来JPARepository的方法依然可以使用
     * @param columnd
     * @param type
     * @return
     */
    List<Document> findByColumndAndType(String columnd, String type);

    @Query(value = "select * from document where columnd = ?1 order by date desc limit ?2",nativeQuery = true)
    List<Document> getNewDocumentTopN(String columd,Integer topN);
}
