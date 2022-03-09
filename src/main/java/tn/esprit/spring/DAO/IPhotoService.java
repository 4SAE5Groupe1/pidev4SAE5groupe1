package tn.esprit.spring.DAO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.entites.Photo;

import java.io.IOException;
import java.util.List;

public interface IPhotoService {
    public List<Photo> GetAllPhotos();

    public ResponseEntity<byte[]> GetPhotoById(Long id);

    public void SavePhoto(MultipartFile file, int userId) throws IOException;
}