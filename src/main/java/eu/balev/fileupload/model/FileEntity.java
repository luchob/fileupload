package eu.balev.fileupload.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FileEntity {

  @Id //ID
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String fileName;

  @Lob
  @Basic(fetch = FetchType.LAZY)
  @Column(length=Integer.MAX_VALUE)
  private byte[] fileData;

  private String contentType;

  public String getContentType() {
    return contentType;
  }

  public FileEntity setContentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public byte[] getFileData() {
    return fileData;
  }

  public void setFileData(byte[] fileData) {
    this.fileData = fileData;
  }
}