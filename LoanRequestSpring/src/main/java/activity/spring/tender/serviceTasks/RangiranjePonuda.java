package activity.spring.tender.serviceTasks;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import activiti.spring.tender.entity.Ponudjac;

public class RangiranjePonuda implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execute) throws Exception {
		List<Ponudjac> ponudjaci= (List<Ponudjac>) execute.getVariable("ponudjaci");
		
		 Ponudjac temp;
	        for(int i=0; i < ponudjaci.size()-1; i++){
	 
	            for(int j=1; j < ponudjaci.size()-i; j++){
	                if(ponudjaci.get(j-1).getPonuda() > ponudjaci.get(j).getPonuda()){
	                    temp=ponudjaci.get(j-1);
	                    ponudjaci.add(j-1, ponudjaci.get(j)); 
	                    ponudjaci.add(j, temp); ;
	                }
	            }
		
	        }
	        
	        execute.setVariable("ponudjaciSortirano", ponudjaci);
	        
	  
	}
}
