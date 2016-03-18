package activity.spring.tender.services;

import activiti.spring.tender.entity.Ponudjac;

public interface PonudjacService {

	public Ponudjac findPonudjac(String nazivPonudjaca);
	public Ponudjac createPonudjac(Ponudjac data);
}
