package pl.teo.petshop.service.impl;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pl.teo.petshop.entity.FileMetadata;
import pl.teo.petshop.repository.FileMetadataRepository;
import pl.teo.petshop.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.UUID;

//@Service
public class AwsFileService implements FileService {
    private final String bucketName = "pierwszy-kubel";
    private final Regions clientRegion = Regions.EU_CENTRAL_1;

    private final FileMetadataRepository fileMetadataRepository;

    @Autowired
    public AwsFileService(FileMetadataRepository fileMetadataRepository) {
        this.fileMetadataRepository = fileMetadataRepository;
    }

    @Transactional
    @Override
    public FileMetadata uploadFile(MultipartFile file) {
        FileMetadata fileMetadata = null;
        if (!file.isEmpty()) {
            try {
                UUID uuid = UUID.randomUUID();
                String filename = "images/image_" + uuid.toString();
                byte[] bytes = file.getBytes();
                InputStream inputStream = new ByteArrayInputStream(bytes);
                //localhost
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withCredentials(new ProfileCredentialsProvider())
                        .withRegion(clientRegion)
                        .build();

                //elastic beanstalk
//                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                        .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
//                        .withRegion(clientRegion)
//                        .build();

                s3Client.putObject(new PutObjectRequest(bucketName, filename, inputStream, new ObjectMetadata()));
                System.out.println("File upload success");
                fileMetadata = new FileMetadata(file,filename);
                fileMetadataRepository.save(fileMetadata);
            } catch (Exception e) {
                System.out.println("File has not been uploaded: " + e);
            }
        } else {
            System.out.println("Uploaded file is empty");
        }
        return fileMetadata;
    }

    @Override
     public void getFile(String fileName, HttpServletResponse response){
         try {
             //localhost
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withCredentials(new ProfileCredentialsProvider())
                        .withRegion(clientRegion)
                        .build();

             //elastic beanstalk
//             AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                     .withCredentials(DefaultAWSCredentialsProviderChain.getInstance())
//                     .withRegion(clientRegion)
//                     .build();

             S3Object object = s3Client.getObject(new GetObjectRequest(bucketName, fileName));
             InputStream is = object.getObjectContent();
             FileMetadata metadata = (fileMetadataRepository.findByName(fileName)).get();
             response.setContentType(metadata.getContentType());
             response.setContentLength((int) metadata.getSize());
             org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
             response.flushBuffer();
         } catch (IOException ex) {
             System.out.println("Download file error " + ex);
             response.setStatus(404);
         }
     }
}
