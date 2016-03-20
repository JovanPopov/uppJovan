package activity.spring.tender.serviceTasks;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import activiti.spring.tender.entity.BazaPonudjac;
import activiti.spring.tender.entity.Ponudjac;

public class ProveraBazePonudjaca implements JavaDelegate {

	
	
		
	
	public void execute(DelegateExecution execute) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loanRequest");
		  EntityManager em = emf.createEntityManager();
		boolean ubazi = false;
		
		 em.getTransaction().begin();

		User user;
		user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = user.getUsername();
		
		/*
		List<Ponudjac> ponudjaciubazi=(List<Ponudjac>) execute.getVariable("ponudjaciubazi");
		for(Ponudjac pon:ponudjaciubazi){
			if(pon.getId().equals(id)){
				ubazi=true;
				break;
			}
		}
		*/
		
		long bid=1;
		BazaPonudjac st = em.find(BazaPonudjac.class, bid);    
		List<Boolean> result = (List<Boolean>) em.createNativeQuery("select bazaponudjac.dokumentacija from bazaponudjac where bazaponudjac.id like :custName")
		.setParameter("custName", id).getResultList();
	    em.getTransaction().commit();

	  if(result.isEmpty()){
		  ubazi=false;
	  }
		else{
	  if(result.get(0)) ubazi=true;
		}
		execute.setVariable("ubazi", ubazi);
		  em.close();
		    emf.close();
	}

}
