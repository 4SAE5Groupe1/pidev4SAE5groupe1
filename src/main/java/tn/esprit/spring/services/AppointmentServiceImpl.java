package tn.esprit.spring.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;

import tn.esprit.spring.entites.Appointment;
import tn.esprit.spring.entites.Expert;
import tn.esprit.spring.entites.QRCodeGenerator;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.AppointmentRepository;
import tn.esprit.spring.repositories.ExpertRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class AppointmentServiceImpl implements IServiceAppointment {

	@Autowired
	AppointmentRepository appointmentRepository ;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ExpertRepository expertRepository ;
	
	private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png"; 
	
	@Override
	public Appointment addAppointment(Appointment appointment , Long idUser , Long idExpert) throws WriterException, IOException  {
		
		String codeText = appointment.getEmail();
		
		appointmentRepository.save(appointment);
		
		User user = userRepository.findById(idUser).orElse(null);
		Expert expert = expertRepository.findById(idExpert).orElse(null);
		appointment.setUser(user);
		appointment.setExpert(expert);
		appointmentRepository.save(appointment);
		
       //SimpleMailMessage message = new SimpleMailMessage();
       MimeMessage message = javaMailSender.createMimeMessage() ;
		
		/*  message.setFrom("nadia.wanness@esprit.tn");
		message.setTo(appointment.getEmail());
		message.setSubject("You have an appointment");
		message.setText("Hello Mr/Mrs we have to confirm that you have an appointment with Dr "  + appointment.getExpert() +  " on "+ "date" + appointment.getDate()
		+ "This is your QRCode " +  QRCodeGenerator.getQRCodeImage(codeText, 350, 350)
		
		); */
       
      
       
		/* MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
				StandardCharsets.UTF_8.name() 
				); */
		
		 try {
			 MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
						StandardCharsets.UTF_8.name() 
						);
			helper.setFrom("nadia.wanness@esprit.tn");
			helper.setTo(appointment.getEmail());
			helper.setSubject("You have an appointment");
			helper.setText("Hello Mr/Mrs we have to confirm that you have an appointment with Dr "  + appointment.getExpert().getNomExpert() +  " on "+ "date" + appointment.getDate()
			+ "This is your QRCode " 
			
			);
			
			 helper.addAttachment("qrCode.png",  new ByteArrayResource(QRCodeGenerator.getQRCodeImage("Appointment Id :" + appointment.getIdAppointment()
			 + "Email : " +appointment.getEmail()+ "Date : " +appointment.getDate()+ "Expert : " +appointment.getExpert().getNomExpert()  
			  , 350, 350)));
			
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
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
