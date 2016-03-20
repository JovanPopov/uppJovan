package activiti.spring.loanRequest.deploy;

import java.util.List;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.User;

public class Reset {
	
	
	private static ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	private static IdentityService identityService = processEngine.getIdentityService(); 

	public static void main(String[] args) {
		
		
		// TODO Auto-generated method stub
		//List<User> clanoviKomisijeTemp = identityService.createUserQuery().memberOfGroup("clanoviKomisije").list();
		//for(User user : clanoviKomisijeTemp)
			//identityService.deleteMembership(user.getId(), "clanoviKomisije");
		
		identityService.createMembership("pera","clanoviKomisije");
		System.out.println("Broj korisnika u grupi clanovi komisije:  " + identityService.createUserQuery().memberOfGroup("clanoviKomisije").count());
	}

}
