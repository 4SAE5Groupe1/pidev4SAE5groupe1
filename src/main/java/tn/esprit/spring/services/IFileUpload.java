package tn.esprit.spring.services;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entites.UploadedFile;


public interface IFileUpload {
	public void uploadToLocal(MultipartFile file);
    public UploadedFile uploadToDb(MultipartFile file);
    public UploadedFile downloadFile(String fileId);
}
