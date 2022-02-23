package tn.esprit.spring.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Donation  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCategorieEvent ;
    @Temporal(TemporalType.DATE)
    private Date dateDonation ;
    private float Amount ;
	@ManyToOne
	private User user;
	@ManyToOne
	private Pot pot;

   
}
