package activity.spring.tender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import activiti.spring.tender.entity.Ponudjac;
import activity.spring.tender.repository.PonudjacRepo;
import activity.spring.tender.services.PonudjacService;


@Service
@Transactional
public class PonudjacServiceImpl implements PonudjacService {

	@Autowired
	private PonudjacRepo repo;

	public Ponudjac findPonudjac(String nazivPonudjaca) {
		
		return repo.findPonudjac(nazivPonudjaca);
	}

	public Ponudjac createPonudjac(Ponudjac data) {
		
		return repo.createPonudjac(data);
	}
}
