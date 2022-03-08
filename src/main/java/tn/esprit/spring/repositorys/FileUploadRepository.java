package tn.esprit.spring.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.UploadedFile;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadedFile,String> {
}
