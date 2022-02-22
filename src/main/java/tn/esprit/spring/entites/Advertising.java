package tn.esprit.spring.entites;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
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
	
	@Column(name="PaymentType")
	@Enumerated(EnumType.STRING)
	 PaymentType paymentType;
	
	@Column(name="filePath")
	 String filePath;
	
	@Column(name="totalAmount")
	 double cost;
	
	@Column(name="startDate")
	 Date startDate;
	
	@Column(name="endDate")
	 Date endDate;
	@ManyToOne
	private User user;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
