package tn.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Appointment")
public class Appointment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAppointment")
	private Long IdAppointment;
	
	
	@Column(name="dateAppointment")
	private Date Date;
	
	@Column(name="emailAppointment")
	private String Email; 
	

	
	//@JsonIgnore
	@ManyToOne()
	private User user;
	
	@JsonIgnore
	@ManyToOne()
	private Expert  expert;
	
}