package cn.itweet.modules.admin.document.web;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.exception.SystemException;
import cn.itweet.modules.admin.document.entiry.Document;
import cn.itweet.modules.admin.document.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by whoami on 22/04/2017.
 */
@Controller
@RequestMapping("/admin/document")
public class DocumentController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private ItweetProperties itweetProperties;

    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String uploadFiles(Model model) throws IOException {
        model.addAttribute("upload_files_type",itweetProperties.getUploadTypeFiles());
        model.addAttribute("upload_image_type",itweetProperties.getUploadTypeImage());
        return "admin/document/uploadForm";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("file") MultipartFile file,Model model, HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/")+itweetProperties.getUploadSuffix();
        try {
            storageService.store(file,rootPath);
        } catch (SystemException e) {
            e.printStackTrace();
        }

        model.addAttribute("message","<script>toastr.error(\"" + "You successfully uploaded" + file.getOriginalFilename() + "!" + "\")</script>");

        return "redirect:/admin/document/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(Model model,Integer page) {
        Page<Document> documentPage = storageService.loadAll(0);
        model.addAttribute("documentList",documentPage.getContent());
        return "admin/document/d_list";
    }

    @RequestMapping(value = "/files",method = RequestMethod.GET)
    @ResponseBody
    public List<Document> loadAll(Integer page) {
        Page<Document> documentPage = storageService.loadAll(0);
        return documentPage.getContent();
    }

}
