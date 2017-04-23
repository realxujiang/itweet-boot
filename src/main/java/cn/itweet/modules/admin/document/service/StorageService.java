package cn.itweet.modules.admin.document.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.document.entiry.Document;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by whoami on 22/04/2017.
 */
public interface StorageService {
    /**
     * 文件默认栏目: 文章栏目
     * @param file
     * @param path
     * @return
     * @throws SystemException
     */
    String store(MultipartFile file, String path) throws SystemException;

    /**
     * 指定存储图片的栏目
     * @param file
     * @param path
     * @param columnd
     * @return
     * @throws SystemException
     */
    String store(MultipartFile file, String path,String columnd) throws SystemException;

    Page<Document> loadAll(Integer page);

    Document loadById(Integer id);

    String loadRuleFilenameById(Integer id);

    void deleteById(Integer id, String filePath);

    void deleteByRuleFilename(String ruleFilename, String filePath);

    void deleteAll(String filePath);
}
