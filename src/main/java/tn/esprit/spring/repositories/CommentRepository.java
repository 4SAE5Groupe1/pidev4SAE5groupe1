package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.Comment;


public interface CommentRepository extends CrudRepository<Comment, Long> {

}
