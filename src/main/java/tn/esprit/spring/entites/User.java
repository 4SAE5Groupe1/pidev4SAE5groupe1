package tn.esprit.spring.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(	name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String token;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime tokenCreationDate;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Photo photo;

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Training> trainings;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Offer> offers;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Complaint> complaints;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Appointment> appointments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Candidacy> candidacies;*/

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set <ParticipationEvent>  participationEvent ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set <LikeEvent>  LikeEvent ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set <DislikeEvent>  DislikeEvent ;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Donation> donations;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private Set<Event> events;


}

