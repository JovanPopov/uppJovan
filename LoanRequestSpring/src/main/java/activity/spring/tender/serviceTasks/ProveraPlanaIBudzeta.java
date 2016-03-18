package activity.spring.tender.serviceTasks;

import java.util.Random;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class ProveraPlanaIBudzeta implements JavaDelegate {

	@Override
	public void execute(DelegateExecution exection) throws Exception {
		
		boolean odbijen;
		
		Random rand = new Random();
		int value = rand.nextInt(50);
		
		/*
		if(value>45){
			odbijen = false;
		}else{
			odbijen = true;
		}
		*/
		odbijen=false;
		exection.setVariable("odbijen", odbijen);
	}

}
