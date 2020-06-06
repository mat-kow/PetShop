package pl.teo.petshop.service;

import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.entity.FileMetadata;

import javax.servlet.http.HttpServletResponse;

public interface FileService {
     FileMetadata uploadFile(MultipartFile file);
     void getFile(String fileName, HttpServletResponse response);

    }
