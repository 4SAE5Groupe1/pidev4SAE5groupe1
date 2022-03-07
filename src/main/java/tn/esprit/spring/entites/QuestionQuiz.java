package tn.esprit.spring.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class QuestionQuiz implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int questionId ;
	private String questionBody ;
	private String option1 ;
	private String option2 ;
	private String option3 ;
	private String CorrectResponse ;
	
//	@OneToOne
//	private ResponseQuiz responseQuiz;
	@OneToOne(mappedBy="questionQuiz")
	private ResponseLearner responseLearner;
	@ManyToOne
	@JsonIgnore
	private Quiz quiz;


	
}
