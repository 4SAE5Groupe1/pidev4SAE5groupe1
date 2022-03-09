package tn.esprit.spring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSub;
    private boolean status;
    private String details;
    private String token;
    private String email;
    private float prix;
    @Temporal(TemporalType.DATE)
    private Date dateExp;
    @OneToOne
    private User user;
    public Subscription (boolean status,String details){
        super();
        this.status = status;
        this.details = details;
    }
    public boolean isStatus() {
        return status;
    }
}
