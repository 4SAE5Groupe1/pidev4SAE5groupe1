
package tn.esprit.spring.entites;
import java.io.Serializable;



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
import tn.esprit.spring.entites.User;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Complaint")
public class Complaint implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idComplaint")
	private Long IdComplaint;
	@Column(name="contentComplaint")
	private String Content;
	@Column(name="titleComplaint")
	private String Title;
	@Column(name="decisionComplaint")
	private String decision = "Pas de decision" ;
	
	//@JsonIgnore
	@ManyToOne()
	private User user;
}