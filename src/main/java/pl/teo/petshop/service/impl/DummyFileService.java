package pl.teo.petshop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.entity.FileMetadata;
import pl.teo.petshop.service.FileService;

import javax.servlet.http.HttpServletResponse;
@Service
public class DummyFileService implements FileService {
    @Override
    public FileMetadata uploadFile(MultipartFile file) {
        return null;
    }

    @Override
    public void getFile(String fileName, HttpServletResponse response) {

    }
}
