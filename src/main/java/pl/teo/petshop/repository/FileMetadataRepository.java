package pl.teo.petshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.teo.petshop.entity.FileMetadata;

import javax.persistence.Id;
import java.util.Optional;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Id> {
    Optional<FileMetadata> findByName(String fileName);
}
