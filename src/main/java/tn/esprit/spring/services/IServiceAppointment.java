package tn.esprit.spring.services;

import java.io.IOException;
import java.util.List;

import com.google.zxing.WriterException;

import tn.esprit.spring.entities.Appointment;


public interface IServiceAppointment {

	public  Appointment addAppointment(Appointment appointment , Long idUser , Long idExpert) throws WriterException, IOException   ;
	
	public List<Appointment> getAllAppointments ();

	public void deleteAppointment(Long idAppointment);
	
	public Appointment updateAppointment(Appointment appointment);
	
	public String sendEmail();

	
	
}
