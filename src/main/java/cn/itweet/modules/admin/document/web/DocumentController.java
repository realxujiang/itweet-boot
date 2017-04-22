package cn.itweet.modules.admin.document.web;

import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.document.service.StorageFileNotFoundException;
import cn.itweet.modules.admin.document.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Created by whoami on 22/04/2017.
 */
@Controller
@RequestMapping("/admin/document")
public class DocumentController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String listUploadedFiles(Model model) throws IOException {
//        model.addAttribute("files", storageService
//                .loadAll()
//                .map(path ->
//                        MvcUriComponentsBuilder
//                                .fromMethodName(DocumentController.class, "serveFile", path.getFileName().toString())
//                                .build().toString())
//                .collect(Collectors.toList()));

        return "admin/document/uploadForm";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/upload/files/");
        try {
            storageService.store(file,rootPath);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/admin/document/upload";
    }

    @RequestMapping(value = "/files/{filename:.+}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
