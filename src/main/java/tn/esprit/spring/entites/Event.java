package tn.esprit.spring.entites;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.paypal.api.payments.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static tn.esprit.spring.entites.EtatPayement.disapproved;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Event implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idevent ;
    private String Name ;
    private String place  ;
    @Temporal(TemporalType.DATE)
    private Date Startdate ;
    @Temporal(TemporalType.DATE)
    private Date EndDate ;
    private Integer NumberParticipant  =0 ;
    private Integer NumberParticipantMax ;
    @Enumerated

    private EtatPayement etatPayement = disapproved ;
@Enumerated
    private TypeEvent Typeevent ;

    private float price ;
    @JsonIgnore

    @ManyToOne
    private User user;


    @ManyToOne
	private Categorieevent categorieevent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Set <ParticipationEvent>  participationEvent ;


  
}
