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

		execution.setVariable("oglasOtvoreniVidljiv", false);
		execution.setVariable("oglasKvalifikacijeVidljiv", false);
		execution.setVariable("oglasRestriktivniVidljiv", false);
		
		execution.setVariable("ponudjaciSortirano", ponudjaciSortirano);
		
		//List<User> clanoviKomisijeTemp = identityService.createUserQuery().memberOfGroup("clanoviKomisije").list();
		//for(User user : clanoviKomisijeTemp)
			//identityService.deleteMembership(user.getId(), "clanoviKomisije");
		
		//List<User> clanoviKomisijeTemp = identityService.createUserQuery().memberOfGroup("clanoviKomisije").list();
		//for(User user : clanoviKomisijeTemp)
		//	identityService.deleteMembership(user.getId(), "clanoviKomisije");
		
		//identityService.createMembership("pera","clanoviKomisije");
		
		
	}

}
