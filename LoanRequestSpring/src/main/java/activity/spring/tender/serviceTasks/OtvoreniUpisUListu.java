package activity.spring.tender.serviceTasks;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import activiti.spring.tender.entity.Ponudjac;

public class OtvoreniUpisUListu implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execute) throws Exception {
		
		//boolean var1 = (Boolean) execute.getVariable("dokumentacija");
		
		String var2 = "ne";
		Boolean var3=false;
		boolean upisi=true;
		//try{
			var2 = (String)execute.getVariable("potvrdaKomisije");
		//}catch(Exception e){			
		//}
		//try{			
			var3 = (Boolean)execute.getVariable("ubazi");
		//}catch(Exception e){
	//	}
	//	if(var2==null) var2="ne";
	//	if(var3==null) var3=false;
		//if(var2.equals("da") || var3) upisi=true;
		
			User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String id = user.getUsername();
		
		if(upisi){
			List<Ponudjac> ponudjaci=(List<Ponudjac>) execute.getVariable("ponudjaci");
			Ponudjac ponudjac = new Ponudjac();
			ponudjac.setId(id);
			ponudjac.setNaziv((String)execute.getVariable("nazivPonudjaca"));
			ponudjac.setEmail((String)execute.getVariable("emailPonudjaca"));
			ponudjac.setPonuda((Long)execute.getVariable("ponuda"));
			ponudjac.setDokumentacija(true);
			
			ponudjaci.add(ponudjac);
			execute.setVariable("ponudjaci", ponudjaci);
			
		}
	}
	
	

}
