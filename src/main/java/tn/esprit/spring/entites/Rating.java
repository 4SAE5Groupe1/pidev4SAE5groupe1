package tn.esprit.spring.entites;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Rating")
public class Rating implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name="nbStars")
	 int nbStars;
	
	@Column(name="date")
	 Date date;
	
	@ManyToOne
	private Publication publication;
	
	@ManyToOne
	private User user;

}
