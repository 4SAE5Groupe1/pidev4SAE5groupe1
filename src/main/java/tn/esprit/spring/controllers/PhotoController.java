package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.services.PhotoService;

import java.io.IOException;

@CrossOrigin()
@RestController
@RequestMapping("/api/test")
public class PhotoController {
    @Autowired
    PhotoService ice;
    @PostMapping("/upload/image/{id}")
    public String uplaodImage(@PathVariable("id") int id, @RequestParam("photo") MultipartFile file)
            throws IOException {
        ice.SavePhoto(file, id);

        return "Image uploaded successfully: " + file.getOriginalFilename();
    }
}
