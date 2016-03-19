package activity.spring.tender.serviceTasks;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.identity.User;

import activiti.spring.tender.entity.Ponudjac;

public class Inicijalizacija implements JavaDelegate  {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		IdentityService identityService = execution.getEngineServices().getIdentityService();
		
		List<Ponudjac> ponudjaciSortirano = new ArrayList<Ponudjac>(); 
		
		boolean oglasOtvoreniVidljiv=false;
		execution.setVariable("oglasOtvoreniVidljiv", oglasOtvoreniVidljiv);
		
		boolean oglasKvalifikacijeVidljiv=false;
		execution.setVariable("oglasKvalifikacijeVidljiv", oglasKvalifikacijeVidljiv);
		
		boolean oglasRestriktivniVidljiv=false;
		execution.setVariable("oglasRestriktivniVidljiv", oglasRestriktivniVidljiv);
		
		execution.setVariable("ponudjaciSortirano", ponudjaciSortirano);
		
		//List<User> clanoviKomisijeTemp = identityService.createUserQuery().memberOfGroup("clanoviKomisije").list();
		//for(User user : clanoviKomisijeTemp)
			//identityService.deleteMembership(user.getId(), "clanoviKomisije");
	}

}
