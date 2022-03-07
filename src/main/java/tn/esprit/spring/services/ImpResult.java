package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Result;
import tn.esprit.spring.repositories.ResultRepository;

@Service
@Slf4j
public class ImpResult implements IResult{

	@Autowired
	ResultRepository resultRepository;
	@Override
	public List<Result> GetAllResults() {
		// TODO Auto-generated method stub
		List<Result> lco = (List<Result>) resultRepository.findAll();
		 for (Result result : lco) {
			log.info("this is the Result ");
		}
		 return lco;
		}
	}


