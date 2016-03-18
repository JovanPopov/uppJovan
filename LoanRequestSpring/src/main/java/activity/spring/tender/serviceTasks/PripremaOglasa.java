package activity.spring.tender.serviceTasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class PripremaOglasa implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execute) throws Exception {
		// TODO Auto-generated method stub
		
		Boolean tajmeristekaorest=false;
		execute.setVariable("tajmeristekaorest", tajmeristekaorest);
		
	}
	

}
