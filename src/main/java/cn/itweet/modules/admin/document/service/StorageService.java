package cn.itweet.modules.admin.document.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by whoami on 22/04/2017.
 */
public interface StorageService {
    String store(MultipartFile file,String path) throws SystemException;

    Page<Document> loadAll(Integer page);

    Document loadById(Integer id);

    String loadRuleFilenameById(Integer id);

    void deleteById(Integer id,String filePath);

    void deleteByRuleFilename(String ruleFilename,String filePath);

    void deleteAll(String filePath);
}
