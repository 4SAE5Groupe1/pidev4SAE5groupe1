package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Appointment")
public class Appointment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAppointment")
	private Long IdAppointment;
	@Column(name="dateAppointment")
	private Date Date;
	@Column(name="emailAppointment")
	private String Email; 
	
	/* @Column(name="ExpertAppointment")
	private String Expert; */
	
	
	/*@Column(name="codeQrAuthentif")
	private String codeQrAuthentif ; */
	
	@JsonIgnore
	@ManyToOne()
	private User user;
	@JsonIgnore
	@ManyToOne()
	private Expert expert;
	
}
