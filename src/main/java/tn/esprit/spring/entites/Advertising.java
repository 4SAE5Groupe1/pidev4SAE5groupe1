package tn.esprit.spring.entites;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Advertising")

public class Advertising implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Transient
	private static int adv_price_per_minute = 1;
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name="name")
	 String name;
	
	@Column(name="PaymentType") // BTC or credit card
	@Enumerated(EnumType.STRING)
	 PaymentType paymentType;
	
	@Column(name="filePath") // each user have unique folder contain her documents
	 String filePath;
	
	@Column(name="totalAmount") // duration in minute x adv_price_per_minute
	 double cost;

	@Column(name="startDate")
	 Date startDate;
	
	@Column(name="duration")
	long duration; // duration in minute
	
	@Column(name="advStatus") // offline or online or deleted
	 String advStatus;
	
	@Column(name="advType") // image, or video
	 String advType;
	
	@Column(name="paymentStatus") // PAID , CONFIRMED or CANCELLED
	 String paymentStatus;
	
	@Column(name="link") // when click in adv redirect to this link
	 String link;
	
	@Column(name="AdvertisingCategory")
	@Enumerated(EnumType.STRING)
	AdvertisingCategory advertisingCategory;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private User user;
	
	

}
