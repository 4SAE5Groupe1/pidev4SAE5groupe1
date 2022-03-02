package tn.esprit.spring.services;
import java.io.File;
import java.io.IOException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	public void uploadFile(MultipartFile file) throws IllegalStateException, IOException{
		file.transferTo(new File("C:\\Users\\Achref\\Desktop\\pidev\\src\\upload\\"+file.getOriginalFilename()));
		
	}
}
