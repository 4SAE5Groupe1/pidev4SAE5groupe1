package tn.esprit.spring.entites;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class pot implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpot ;
    private String Name ;
     private Long totalAmount ;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pot")
    private Set<Donation> donations ;

    private boolean archiver ;
}
