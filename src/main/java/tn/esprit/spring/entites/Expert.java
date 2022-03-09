package tn.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Expert")
public class Expert implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idExpert")
	private Long IdExpert;
	@Column(name="nomExpert")
	private String nomExpert;
	@Column(name="fonctionExpert")
	private Fonction fonction ; 
	
	//@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "expert")
	private Set<Appointment> appointments;
}
