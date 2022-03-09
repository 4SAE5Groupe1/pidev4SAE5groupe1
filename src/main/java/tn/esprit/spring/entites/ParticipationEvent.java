package tn.esprit.spring.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
@JsonIgnore
  @ManyToOne
    private User user;
@JsonIgnore
    @ManyToOne
    private Event event;
}
