package tn.esprit.spring.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParticipationEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParticipationEvent ;

    @Temporal(TemporalType.DATE)
    private Date DateParticipation = new Date() ;
  // private long DateParticipation  = System.currentTimeMillis();
 // private SimpleDateFormat DateParticipation = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @ManyToOne
    private User user;

    @ManyToOne
    private Event event;
}
