package cn.itweet.modules.admin.document.web;

import cn.itweet.common.config.ItweetProperties;
import cn.itweet.common.exception.SystemException;
import cn.itweet.common.utils.PageUtils;
import cn.itweet.modules.admin.document.entiry.Document;
import cn.itweet.modules.admin.document.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String uploadFiles(Model model) throws IOException {
        model.addAttribute("upload_files_type",itweetProperties.getUploadTypeFiles());
        model.addAttribute("upload_image_type",itweetProperties.getUploadTypeImage());
        return "admin/document/d_add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String uploadFiles(@RequestParam("file") MultipartFile file,String columnd,Model model,HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding( "utf-8" );
            response.setHeader( "Content-Type" , "text/html" );
            String rootPath = request.getSession().getServletContext().getRealPath("/")+itweetProperties.getUploadSuffix();
            storageService.store(file,rootPath,columnd);
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        model.addAttribute("message","<script>toastr.error(\"" + "You successfully uploaded" + file.getOriginalFilename() + "!" + "\")</script>");

        return "redirect:/admin/document/list";
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String list(@RequestParam(value = "page", defaultValue = "0") Integer page, Model model) {

        if(page !=0) page = page -1;

        Page<Document> documentList = storageService.list(page);
        model.addAttribute("documentList",documentList);

        PageUtils pageUtils = new PageUtils("/admin/document/list?",page,documentList.getTotalPages(),documentList.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        return "admin/document/d_list";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id,HttpServletRequest request) {
        String rootPath = request.getSession().getServletContext().getRealPath("/")+itweetProperties.getUploadSuffix();
        storageService.deleteById(id,rootPath);
        return "redirect:/admin/document/list";
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public String select(@RequestParam(value = "columnd") String columnd, @RequestParam(value = "page", defaultValue = "0") Integer page,Model model) {
        if(page !=0) page = page -1;
        Page<Document> documentList = storageService.selectByColumnd(page,columnd);
        model.addAttribute("documentList",documentList);

        PageUtils pageUtils = new PageUtils("/admin/document/select?name="+ columnd+"&",page,documentList.getTotalPages(),documentList.getTotalElements(),itweetProperties.getPagSize());
        model.addAttribute("pb",pageUtils);

        model.addAttribute("columnd",columnd);
        return "admin/document/d_list";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET)
    public String edit(Model model,@PathVariable Integer id) {
        Document document = storageService.loadById(id);
        model.addAttribute("form",document);
        return "admin/document/d_edit";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(Model model,HttpServletRequest request,Document document) {

        return "redirect:/admin/document/d_list";
    }



}
