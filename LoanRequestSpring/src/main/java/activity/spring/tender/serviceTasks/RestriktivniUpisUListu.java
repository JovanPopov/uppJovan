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
		
		
		boolean upisi=false;
		
		String var2 = (String)execute.getVariable("potvrdaKomisije");
				
		boolean var3 = (Boolean)execute.getVariable("ubazi");
		
		
		if(var2.equals("da") || var3) upisi=true;
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = user.getUsername();
		
		String p=(String) execute.getVariable("pon");
		
		if(upisi){
			List<Ponudjac> ponudjaci=(List<Ponudjac>) execute.getVariable("ponudjaci");
			List<Ponudjac> kandidati=(List<Ponudjac>) execute.getVariable("kandidati");
			Ponudjac kandidat = null;
			for(Ponudjac pon:kandidati)
				if(pon.getId().equals(p)) {
					kandidat = 	pon;
					break;
				}
			Ponudjac ponudjac = kandidat;
			ponudjac.setDokumentacija(true);
			ponudjac.setPonuda((Long)execute.getVariable("ponuda"));
			
			ponudjaci.add(ponudjac);
			execute.setVariable("ponudjaci", ponudjaci);
			
		}
	}
}
