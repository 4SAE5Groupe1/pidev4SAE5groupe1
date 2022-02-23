//package tn.esprit.spring.entites;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//public class Role implements Serializable {
//        /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//		@Id
//        @GeneratedValue(strategy = GenerationType.AUTO)
//        private int id;
//        @Enumerated(EnumType.STRING)
//        private RoleName role;
//        @ManyToMany(mappedBy="roles", cascade = CascadeType.PERSIST, fetch
//                = FetchType.EAGER)
//        private Set<User> Users;
//}
