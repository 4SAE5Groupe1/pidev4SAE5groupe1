package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Appointment;


public interface IServiceAppointment {

	public void addAppointment(Appointment appointment);
	
	public List<Appointment> getAllAppointments ();

	public void deleteAppointment(Long idAppointment);
	
	public Appointment updateAppointment(Appointment appointment);
	
}
