package tn.esprit.spring.scheduledEmail;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.repositories.AppointmentRepository;
import tn.esprit.spring.services.IServiceAppointment;



public class Job1 implements Job{
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	IServiceAppointment appointmentService;
	 // List<Appointment>   appointments;
	public void execute(JobExecutionContext context ) throws JobExecutionException {
		
		//Date date = new Date(2022,03,09);
		//Appointment app = new Appointment(1L,,"nadia.wanness@gmail.com",1L,1L);
		
		//Appointment appointment = appointmentRepository.findById(idAppointment).orElse(null);
		
		
		//System.out.println("execution");
		/* System.out.println("nadia");
		System.out.println("Job1 --->>> Time is " + new Date());
		
		EmailUtil.sendEmail("nadia.wanness@gmail.com","Email Testing Subject1", "Email Testing Body1"); 
		
		System.out.println("nadia");*/
       Date date  = new Date() ;
  
       //LocalDate datel = LocalDate.now();
       //date.equals(datel) ;
       //datel.getDayOfMonth();
		
		
			//
			//LocalDate ldate = LocalDate.now();
		System.out.println("nadia");
		System.out.println("Job1 --->>> Time is " + new Date());
    	  List<Appointment> appointments = appointmentRepository.getAllApp() ;  
   
			  //System.out.println("nadia");
			
			 for(Appointment appointment : appointments){
				
				if(appointment.getDate().compareTo(date)==0){
				
					EmailUtil.sendEmail(appointment.getEmail(),"Appointment Reminder", "We send you this email "
							+ "to remind you that you have an appointment today  " +appointment.getDate()+ "with " +appointment.getExpert().getNomExpert()+ ""
									+ "have a nice day we are waiting for you !!");
				
				}
			} 
				
		
			
			
		}
	} 

