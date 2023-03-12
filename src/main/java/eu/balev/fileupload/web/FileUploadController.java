package eu.balev.fileupload.web;

import eu.balev.fileupload.model.FileUploadModel;
import eu.balev.fileupload.service.FileService;
import java.io.IOException;
import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

  private final FileService fileService;

  public FileUploadController(FileService fileService) {
    this.fileService = fileService;
  }

  @GetMapping("/upload")
  public String upload() {
    return "upload";
  }


  @PostMapping("/upload")
  public String uploadModel(FileUploadModel modelUploadDTO) throws IOException {
    return "redirect:/show/" + fileService.upload(modelUploadDTO);
  }

}
