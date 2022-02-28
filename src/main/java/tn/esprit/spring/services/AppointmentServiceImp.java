package tn.esprit.spring.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

//import tn.esprit.spring.QRCodeGenerator;
import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.QRCodeGenerator;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.AppointmentRepository;
import tn.esprit.spring.repositories.UserRepository;

/* import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;  */



@Service
public class AppointmentServiceImp implements IServiceAppointment {

	
	@Autowired
	AppointmentRepository appointmentRepository ;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	UserRepository userRepository;
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png"; 
	
	@Override
	public Appointment addAppointment(Appointment appointment , Long idUser) throws WriterException, IOException  {
		
		String codeText = appointment.getEmail();
		
		appointmentRepository.save(appointment);
		
		User user = userRepository.findById(idUser).orElse(null);
		appointment.setUser(user);
		appointmentRepository.save(appointment);
		
       SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("nadia.wanness@esprit.tn");
		message.setTo(appointment.getEmail());
		message.setSubject("You have an appointment");
		message.setText("Hello Mr/Mrs we have to comfirm that you have an appointment with Dr "+ appointment.getExpert() + " on "+ "date" + appointment.getDate()
		+ "This is your QRCode " +  QRCodeGenerator.getQRCodeImage(codeText, 350, 350)
		);
		
		javaMailSender.send(message); 
		
		//String codeText = appointment.getEmail();
		
		 //return generateQRCodeImage(codeText, 350, 350, QR_CODE_IMAGE_PATH);
		
		//return "Mail sent successfully";
		
		return appointment;
		
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return (List<Appointment>) appointmentRepository.findAll();
	}

	@Override
	public void deleteAppointment(Long idAppointment) {
		appointmentRepository.deleteById(idAppointment);
		
	}

	@Override
	public Appointment updateAppointment(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}
	
	public String sendEmail(){
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setFrom("nadia.wanness@esprit.tn");
		message.setTo("nadia.wanness@gmail.com");
		message.setSubject("You have an appointment");
		message.setText("Hello Mr/Mrs we have to comfirm that you have an appointment");
		
		javaMailSender.send(message);
		return "Mail sent successfully"; 
		
		/* MimeMessage mimeMessage;
		//MimeMessagePreparator preparator = new MimeMessagePreparator();
		mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress("nadia.wanness@gmail.com"));
        mimeMessage.setFrom(new InternetAddress("admin@gmail.com"));
        mimeMessage.setSubject("QRCode Appointment");
        mimeMessage.setText("your QRCode");

        //FileSystemResource file = new FileSystemResource(new File(fileToAttach));
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.addAttachment("logo.jpg", "./src/main/resources");//, file); */
	} 

        
	
	}
	
	
	

