package activity.spring.tender.serviceTasks;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.annotation.Autowired;

public class PostavljanjeKomisije implements JavaDelegate {
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		IdentityService identityService = execution.getEngineServices().getIdentityService();
			
		String ck1 = (String) execution.getVariable("clanKomisije1");
		String ck2 = (String) execution.getVariable("clanKomisije2");
		String ck3 = (String) execution.getVariable("clanKomisije3");
		
		List<User> clanoviKomisijeTemp1 = identityService.createUserQuery().memberOfGroup("clanoviKomisije").list();
		
		if(clanoviKomisijeTemp1.size()<3){
		identityService.createMembership(ck1, "clanoviKomisije");
		identityService.createMembership(ck2, "clanoviKomisije");
		identityService.createMembership(ck3, "clanoviKomisije");
		}
		
		List<User> clanoviKomisijeTemp = identityService.createUserQuery().memberOfGroup("clanoviKomisije").list();
		List<String> clanoviKomisije = new ArrayList<String>();
		for(User user : clanoviKomisijeTemp)
			clanoviKomisije.add(user.getId());
		
		execution.setVariable("clanoviKomisije", clanoviKomisije);
	}

}
