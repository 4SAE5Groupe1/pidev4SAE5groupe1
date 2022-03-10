package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entites.EmojiComment;

@Repository
public interface EmojiCommentRepository extends CrudRepository<EmojiComment, Long> {

    @Query("SELECT e from EmojiComment e where e.typeComment =:commentType ") 
	List<EmojiComment> findByCommentType(@Param("commentType") String commentType);      // using method
}
