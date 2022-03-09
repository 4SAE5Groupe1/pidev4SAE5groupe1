package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.DAO.IPhotoService;
import tn.esprit.spring.entities.Photo;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.PhotoRepository;
import tn.esprit.spring.repositories.UserRepository;

import java.io.IOException;
import java.util.List;
@Service
public class PhotoService implements IPhotoService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PhotoRepository photoRepository;
    @Override
    public List<Photo> GetAllPhotos() {
        return null;
    }

    @Override
    public ResponseEntity<byte[]> GetPhotoById(Long id) {
        return null;
    }

    @Override

    public void SavePhoto(MultipartFile file, int userId) throws IOException {
        User user = userRepository.findById((long) userId).orElse(null);
        Photo photo = Photo.builder().name(file.getOriginalFilename()).type(file.getContentType())
                .image(file.getBytes()).build();
        photoRepository.save(photo);
        user.setPhoto(photo);
        userRepository.save(user);

    }
}
