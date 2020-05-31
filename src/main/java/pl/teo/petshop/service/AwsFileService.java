package pl.teo.petshop.service;

//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.*;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import pl.teo.petshop.entity.FileMetadata;
//import pl.teo.petshop.repository.FileMetadataRepository;
//
//import java.io.*;
//import java.util.UUID;

@Service
public class AwsFileService {
//    private final String bucketName = "pierwszy-kubel";
//    Regions clientRegion = Regions.EU_CENTRAL_1;
//
//    private FileMetadataRepository fileMetadataRepository;
//
//    @Autowired
//    public AwsFileService(FileMetadataRepository fileMetadataRepository) {
//        this.fileMetadataRepository = fileMetadataRepository;
//    }
//
//    public FileMetadata uploadFile(MultipartFile file) {
//        FileMetadata fileMetadata = null;
//        if (!file.isEmpty()) {
//            try {
//                UUID uuid = UUID.randomUUID();
//                String filename = "images/image_" + uuid.toString();
//                byte[] bytes = file.getBytes();
//                InputStream inputStream = new ByteArrayInputStream(bytes);
//                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                        .withCredentials(new ProfileCredentialsProvider())
//                        .withRegion(clientRegion)
//                        .build();
//                s3Client.putObject(new PutObjectRequest(bucketName, filename, inputStream, new ObjectMetadata()));
//                System.out.println("File upload success");
//                fileMetadata = new FileMetadata(file,filename);
//                fileMetadataRepository.save(fileMetadata);
//            } catch (Exception e) {
//                System.out.println("File has not been uploaded: " + e);
//            }
//        } else {
//            System.out.println("Uploaded file is empty");
//        }
//        return fileMetadata;
//    }
//
//
//     public S3Object getFile(String fileName){
//         AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                 .withCredentials(new ProfileCredentialsProvider())
//                 .withRegion(clientRegion)
//                 .build();
//         return s3Client.getObject(new GetObjectRequest(bucketName, fileName));
//
//     }
}
