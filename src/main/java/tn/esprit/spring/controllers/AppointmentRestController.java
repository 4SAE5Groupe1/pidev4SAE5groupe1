package tn.esprit.spring.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.WriterException;

import tn.esprit.spring.entites.Appointment;
import tn.esprit.spring.entites.Expert;
import tn.esprit.spring.services.IServiceAppointment;
import tn.esprit.spring.services.IServiceExpert;

@RestController
public class AppointmentRestController {
	
	@Autowired
	IServiceAppointment appointmentService;
	
	@Autowired
	IServiceExpert expertService;
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";
	
	@PostMapping("/addAppointment/{idUser}/{idExpert}")
	@ResponseBody
	public Appointment addAppointment(@RequestBody Appointment appointment , @PathVariable("idUser") Long idUser , @PathVariable("idExpert") Long idExpert )throws WriterException, IOException {
		
		
		return appointmentService.addAppointment(appointment , idUser , idExpert);
		
		//appointmentService.generateQRCodeImage(appointment.getEmail(), 350, 350, QR_CODE_IMAGE_PATH);
	
	}
	
	 /* @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
		public void download(
				@PathVariable("codeText") String codeText,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height
				)
			    throws Exception {
			         QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
			    } */

	
	@GetMapping("/getAppointments")
	@ResponseBody
	public List<Appointment> getAllAppointments (){
		 return appointmentService.getAllAppointments();
		 }
	
	@GetMapping("/getExperts")
	@ResponseBody
	public List<Expert> getAllExperts (){
		 return expertService.getAllExperts();
		 }
	@PostMapping("/addExpert")
	@ResponseBody
	public void addExpert (@RequestBody Expert expert){
		 expertService.addExpert(expert);
		 }
	
	/* @DeleteMapping("/deleteAppointment/{idAppointment}")
	@ResponseBody
	
	public void removeAppointment(@RequestBody Appointment a) {
		
		appointmentService.deleteAppointment(a.getIdAppointment());
	} */
	
	@DeleteMapping("/deleteAppointment")
	@ResponseBody
	
	public void removeAppointment(@RequestBody Appointment a) {
		
		appointmentService.deleteAppointment(a.getIdAppointment());
	}
	
	@PutMapping("/modifyAppointment/{idAppointment}")
	@ResponseBody
	public Appointment modifyAppointment(@RequestBody Appointment a) {
	return appointmentService.updateAppointment(a);
	}
	
	/* @GetMapping("/sendEmail")
	@ResponseBody
	public String sendEmail(){
		return appointmentService.sendEmail();
	} */
	

}
