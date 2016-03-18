package activity.spring.tender.serviceTasks;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import activiti.spring.tender.entity.Ponudjac;

public class ProveraBazePonudjaca implements JavaDelegate {


	
		
	
	public void execute(DelegateExecution execute) throws Exception {
		boolean ubazi = false;
	

		User user;
		user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = user.getUsername();
		List<Ponudjac> ponudjaciubazi=(List<Ponudjac>) execute.getVariable("ponudjaciubazi");
		for(Ponudjac pon:ponudjaciubazi){
			if(pon.getId().equals(id)){
				ubazi=true;
				break;
			}
		}
		
		execute.setVariable("ubazi", ubazi);
	}

}
