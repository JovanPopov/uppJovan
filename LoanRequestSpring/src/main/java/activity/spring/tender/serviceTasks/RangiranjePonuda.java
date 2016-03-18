package activity.spring.tender.serviceTasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.spring.tender.entity.Ponudjac;

public class RangiranjePonuda implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execute) throws Exception {
		List<Ponudjac> ponudjaci= (List<Ponudjac>) execute.getVariable("ponudjaci");
		
		Collections.sort(ponudjaci);
		
	
	        execute.setVariable("ponudjaciSortirano", ponudjaci);
	        
	  
	}
}
