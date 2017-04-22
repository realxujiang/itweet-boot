package cn.itweet.modules.admin.document.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * Created by whoami on 22/04/2017.
 */
public interface StorageService {
    void init();

    void store(MultipartFile file,String path);

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
