package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
@Table(name = "Offer")

public class Offer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idOffer")
	private Long IdOffer;
	@Column(name="domainOffer")
	private String domain;
	@Column(name="titleOffer")
	private String Title;
	@Column(name="descriptionOffer")
	private String Description;
	@Column(name="likeOffer")
	private int Like = 0 ;
	@ElementCollection(targetClass=Long.class)
	// a changer vers String !! 
	private Set<Long>likesUsers;
	
	@JsonIgnore
	@ManyToOne()
	private User user;
}
