package activity.spring.tender.serviceTasks;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import activiti.spring.tender.entity.Ponudjac;

public class RestriktivniUpisUListu implements JavaDelegate {
	
	@SuppressWarnings("unchecked")
	@Override
	public void execute(DelegateExecution execute) throws Exception {
		
		//boolean var1 = (Boolean) execute.getVariable("dokumentacija");
		
		String var2 = "ne";
		Boolean var3=false;
		boolean upisi=false;
		try{
			var2 = (String)execute.getVariable("potvrdaKomisije");
		}catch(Exception e){			
		}
		try{			
			var3 = (Boolean)execute.getVariable("ubazi");
		}catch(Exception e){
		}
		if(var2==null) var2="ne";
		if(var3==null) var3=false;
		if(var2.equals("da") || var3) upisi=true;
		
		User user = null;
		
		try {
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception ex) {
			
		}
		
		String id = user.getUsername();
		
		
		if(upisi){
			List<Ponudjac> ponudjaci=(List<Ponudjac>) execute.getVariable("ponudjaci");
			List<Ponudjac> kandidati=(List<Ponudjac>) execute.getVariable("kandidati");
			Ponudjac kandidat = null;
			for(Ponudjac pon:kandidati)
				if(pon.getNaziv().equals(id)) {
					kandidat = 	pon;
					break;
				}
			Ponudjac ponudjac = kandidat;
			ponudjac.setDokumentacija(true);
			
			ponudjaci.add(ponudjac);
			execute.setVariable("ponudjaci", ponudjaci);
			
		}
	}
}
