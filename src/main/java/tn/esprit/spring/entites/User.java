package tn.esprit.spring.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String userName;
	private String email;
	private String password;
	private String name;
	private String lastName;
	private Boolean active;
	//@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	//private Set<Role> roles;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Training> trainings;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
	private Set<Event> events;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Offer> offers;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Complaint> complaints;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Appointment> appointments;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Donation> donations;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Candidacy> candidacies;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<ResponseLearner> ResponseLearners;
    @OneToOne(mappedBy = "user")
    private  Feedback Feedback;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private Set<Result> results ;

}
