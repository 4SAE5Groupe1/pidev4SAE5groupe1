package tn.esprit.spring.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int badgeId;
    private String badgeType;
    @OneToOne
    private User user;

    public Badge(int badgeId, String badgeType) {
        this.badgeId = badgeId;
        this.badgeType = badgeType;
    }
}
