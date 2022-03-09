package tn.esprit.spring.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

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
    private TypeEvent Typeevent ;

    private float price ;


    @ManyToOne
    private User user;


    @ManyToOne
	private Categorieevent categorieevent;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Set <ParticipationEvent>  participationEvent ;

    private Integer NumberLike =0 ;
    private Integer NumberDislike = 0 ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Set <LikeEvent>  LikeEvent ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Set <DislikeEvent>  DislikeEvent ;


  
}
