package cn.itweet.modules.admin.document.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by whoami on 22/04/2017.
 */
public interface StorageService {
    void store(MultipartFile file,String path) throws SystemException;

    Page<Document> loadAll(Integer page);

    Document loadById(Integer id);

    String loadRuleFilenameByImageName(Integer id);

    void deleteById(Integer id);

    void deleteByRuleFilename(String ruleFilename);

    void deleteAll();
}
