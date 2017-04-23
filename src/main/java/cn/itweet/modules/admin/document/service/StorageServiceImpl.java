package cn.itweet.modules.admin.document.service;

import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.TimeMillisUtils;
import cn.itweet.modules.admin.document.entiry.Document;
import cn.itweet.modules.admin.document.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by whoami on 22/04/2017.
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public String store(MultipartFile file,String filePath) throws SystemException {

        File f = new File(filePath);

        if (!f.exists()) {
            f.mkdirs();
        }

        String filename = file.getOriginalFilename();

        String suffix = filename.substring(filename.lastIndexOf(".")+1,filename.length());
        String ruleFilename = TimeMillisUtils.getTimeMillis()+"."+suffix;

        Path rootLocation = Paths.get(filePath);

        try {
            if (file.isEmpty()) {
                throw  new SystemException("Failed to store empty file " + filename);
            }
            Files.copy(file.getInputStream(), rootLocation.resolve(ruleFilename));
        } catch (IOException e) {
            throw new SystemException("Failed to store file " + filename, e);
        }

        Document document = new Document();
        document.setDate(new Date());
        document.setFilename(filename);
        document.setRuleFilename(ruleFilename);
        document.setType(suffix);
        documentRepository.save(document);

        return ruleFilename;
    }

    @Override
    public Page<Document> loadAll(Integer page) {
        return documentRepository.findAll(new PageRequest(page,10));
    }

    @Override
    public Document loadById(Integer id) {
        return documentRepository.findOne(id);
    }

    @Override
    public String loadRuleFilenameById(Integer id) {
        return documentRepository.loadRuleFilenameById(id);
    }

    @Override
    public void deleteById(Integer id,String filePath) {
        String ruleFilename = this.loadRuleFilenameById(id);
        try {
            System.out.println(Paths.get(filePath).resolve(ruleFilename));
            Files.deleteIfExists(Paths.get(filePath).resolve(ruleFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentRepository.delete(id);
    }

    @Override
    public void deleteByRuleFilename(String ruleFilename,String filePath) {
        try {
            System.out.println(Paths.get(filePath).resolve(ruleFilename));
            Files.deleteIfExists(Paths.get(filePath).resolve(ruleFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        documentRepository.deleteByRuleFilename(ruleFilename);
    }

    @Override
    public void deleteAll(String filePath) {
        FileSystemUtils.deleteRecursively(new File(filePath));
        documentRepository.deleteAll();
    }

}
