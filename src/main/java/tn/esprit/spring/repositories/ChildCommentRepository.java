package tn.esprit.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entites.ChildComment;


public interface ChildCommentRepository extends CrudRepository<ChildComment, Long> {

}
