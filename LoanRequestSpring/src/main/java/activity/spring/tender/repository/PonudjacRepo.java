package activity.spring.tender.repository;

import activiti.spring.tender.entity.Ponudjac;

public interface PonudjacRepo {
	
		public Ponudjac findPonudjac(String nazivPonudjaca);
		public Ponudjac createPonudjac(Ponudjac data);
				
}
