package eu.balev.fileupload.web;

import eu.balev.fileupload.model.FileDownloadModel;
import eu.balev.fileupload.service.FileService;
import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FileDownloadController {

  private final FileService fileService;

  public FileDownloadController(FileService fileService) {
    this.fileService = fileService;
  }

  @GetMapping("/show/{fileId}")
  public String show(@PathVariable("fileId") int fileId, Model model) {
    model.addAttribute("fileId", fileId);
    return "show";
  }

  @GetMapping("/download/{fileId}")
  public HttpEntity<byte[]> downLoad(
      @PathVariable("fileId") int fileId)  {

    FileDownloadModel fdm = fileService.download(fileId);

    HttpHeaders header = new HttpHeaders();
    header.setContentType(new MediaType(MimeTypeUtils.parseMimeType(fdm.getContentType())));
    header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fdm.getName());
    header.setContentLength(fdm.getDocument().length);

    return new HttpEntity<>(fdm.getDocument(), header);
  }


}
