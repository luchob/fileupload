package eu.balev.fileupload.service;

import eu.balev.fileupload.model.FileDownloadModel;
import eu.balev.fileupload.model.FileEntity;
import eu.balev.fileupload.model.FileUploadModel;
import eu.balev.fileupload.repository.FileRepository;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

  private FileRepository fileRepository;

  public FileService(FileRepository fileRepository) {

    this.fileRepository = fileRepository;
  }

  public int upload(FileUploadModel model) throws IOException {
    MultipartFile img = model.getImg();

    FileEntity newFile = new FileEntity();

    newFile.setFileData(img.getBytes());
    newFile.setContentType(img.getContentType());
    newFile.setFileName(img.getOriginalFilename());

    return fileRepository.save(newFile).getId();
  }

  public FileDownloadModel download(int fileId) {
    FileEntity file = fileRepository.findById(fileId).orElseThrow(() -> new IllegalArgumentException("File" + fileId + " not found!"));

    return new FileDownloadModel()
        .setContentType(file.getContentType())
        .setName(file.getFileName()).
        setDocument(file.getFileData());
  }

}
