package tn.esprit.spring.entites;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
public class Training implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idTraining ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "/yyyy/MM/dd")
	private Date startDate ;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "/yyyy/MM/dd")
	private Date endDate ;
	private String domain ;
	private String details ;
	private int periode ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="training")
	private Set<Feedback> feedbacks;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="training")
	private Set<Quiz> Quizs;
	@ManyToOne
	@JsonIgnore
	private User user;


	
	   
}
