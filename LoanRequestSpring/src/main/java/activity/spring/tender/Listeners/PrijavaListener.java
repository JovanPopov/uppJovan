package activity.spring.tender.Listeners;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import activiti.spring.loanRequest.springweb.controllers.ApplicationController;

@SuppressWarnings("serial")
public class PrijavaListener implements TaskListener{

	@Autowired
	private RuntimeService runtimeService;
	
	@Override
	public void notify(DelegateTask delegeTask) {
		// TODO Auto-generated method stub
		
		User user = null;
		
		try {
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception ex) {
			
		}
		
		String id = user.getUsername();
		
		//String pondujac = (String) runtimeService.getVariable(delegeTask.getProcessInstanceId(), "ponudjac");
		delegeTask.setAssignee(id);
		delegeTask.setVariable("pon", id);
	}

}
