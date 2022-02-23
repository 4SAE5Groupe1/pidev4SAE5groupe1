package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImp implements IServiceAppointment {

	
	@Autowired
	AppointmentRepository appointmentRepository ;
	
	@Override
	public void addAppointment(Appointment appointment) {
		appointmentRepository.save(appointment);
		
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

}
