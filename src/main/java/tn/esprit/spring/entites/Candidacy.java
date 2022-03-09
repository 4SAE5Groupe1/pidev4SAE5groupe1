package tn.esprit.spring.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;




@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Candidacy implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCandidacy;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String description;
	@Temporal (TemporalType.DATE)
	private Date date;
	@Enumerated(EnumType.STRING)
	private Nationality nationality;
	@ManyToOne
	private User user;
	@OneToOne
	private Establishment establishment;



}
