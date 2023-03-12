package eu.balev.fileupload.model;

public class FileDownloadModel {

  private String contentType, name;
  private byte[] document;

  public String getContentType() {
    return contentType;
  }

  public FileDownloadModel setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public String getName() {
    return name;
  }

  public FileDownloadModel setName(String name) {
    this.name = name;
    return this;
  }

  public byte[] getDocument() {
    return document;
  }

  public FileDownloadModel setDocument(byte[] document) {
    this.document = document;
    return this;
  }
}
