package activity.spring.tender.serviceTasks;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import activiti.spring.tender.entity.Ponudjac;

public class KvalifikacijeUpisUlistu implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execute) throws Exception {
			
			List<Ponudjac> kandidati=(List<Ponudjac>) execute.getVariable("kandidati");
			Ponudjac ponudjac = new Ponudjac();
			
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String id = user.getUsername();
			String p=(String) execute.getVariable("pon");
			ponudjac.setId(p);
			ponudjac.setNaziv((String)execute.getVariable("nazivPonudjaca"));
			ponudjac.setEmail((String)execute.getVariable("emailPonudjaca"));
			
			
			kandidati.add(ponudjac);
			
			long brojKandidata = kandidati.size();
			
			execute.setVariable("kandidati", kandidati);
			execute.setVariable("brojKandidata", brojKandidata);
			
			
			
		
		
	}

}
