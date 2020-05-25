package pl.teo.petshop.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FileMetadata {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String originalName;
    private long size;
    private String contentType;


    public FileMetadata(MultipartFile multipartFile, String name) {
        this.name = name;
        this.originalName = multipartFile.getOriginalFilename();
        this.size = multipartFile.getSize();
        this.contentType = multipartFile.getContentType();
    }

    public FileMetadata() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
