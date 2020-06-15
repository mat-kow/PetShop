package pl.teo.petshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity @Getter @Setter @NoArgsConstructor
public class FileMetadata {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String originalName;
    private Long size;
    private String contentType;


    public FileMetadata(MultipartFile multipartFile, String name) {
        this.name = name;
        this.originalName = multipartFile.getOriginalFilename();
        this.size = multipartFile.getSize();
        this.contentType = multipartFile.getContentType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileMetadata that = (FileMetadata) o;
        return Objects.equals(id, that.id) &&
                name.equals(that.name) &&
                originalName.equals(that.originalName) &&
                size.equals(that.size) &&
                contentType.equals(that.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, originalName, size, contentType);
    }
}
