package tn.esprit.spring.entites;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Comment")
public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Column(name="body")
	 String body;
	
	@Column(name="date")
	 Date date;	
	
	@ManyToOne
	Publication publication;
	
	@ManyToOne
	User user;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="comment")
	 Set<ChildComment> childsComment;
	
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy="comment")
	 Set<EmojiComment> emojisComment;

}
