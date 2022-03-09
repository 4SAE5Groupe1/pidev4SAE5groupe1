package tn.esprit.spring.entites;



import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
public class Quiz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int idQuiz ;
	private String domain ;
	//private int score ;
	@ManyToOne
	@JsonIgnore
	private Training training ;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
	private Set<QuestionQuiz> QuestionQuizs;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="quiz")
	private Set<Result> results;

}
