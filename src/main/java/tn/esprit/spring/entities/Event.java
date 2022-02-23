package tn.esprit.spring.entities;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    private Integer NumberParticipant ;
    private float price ;
    @ManyToOne
    private User user;
    @ManyToOne
	private Categorieevent categorieevent;
    

  
}
