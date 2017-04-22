package cn.itweet.modules.admin.document.repository;

import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by whoami on 22/04/2017.
 */
public interface DocumentRepository extends JpaRepository<Document,Integer> {

}
