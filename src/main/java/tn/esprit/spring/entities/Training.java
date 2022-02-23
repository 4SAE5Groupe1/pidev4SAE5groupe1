package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
public class Training implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTraining ;
	private Date startDate ;
	private Date endDate ;
	private String domain ;
	private String details ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="training")
	private Set<feedback> feedbacks;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="training")
	private Set<Quiz> Quizs;
	@ManyToOne
	private User user;


	
	   
}
