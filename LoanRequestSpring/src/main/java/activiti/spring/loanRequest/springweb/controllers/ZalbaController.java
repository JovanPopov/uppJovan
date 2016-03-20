package activiti.spring.loanRequest.springweb.controllers;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/application")
public class ZalbaController {
	
	@Autowired
	RuntimeService runtimeService;
	
	boolean odgovor=false;
	
	@RequestMapping(value="/zalba")
	public String zalba(ModelMap model){
		
		
		model.addAttribute("odgovor", odgovor);
		return "application/zalba";
		
	}
	
	
	@RequestMapping(value="/zalba/pokretanje", method=RequestMethod.POST)
	public String zalbaobrada(@RequestParam Map<String, String> params,ModelMap model){
		
		runtimeService.suspendProcessInstanceById(processInstance());
		odgovor=true;
		return "redirect:/application/zalba";	
		
	}
	
	@RequestMapping(value="/zalba/odgovor")
	public String odgovor(ModelMap model){
		
		String message="";
		
		
		Random rand = new Random();
		int value = rand.nextInt(50);
		
		
		if(value>45){
			
			runtimeService.deleteProcessInstance(processInstance(),"Zahtev za zastitu prava usvojen");
			message = "Zahtev usvojen, proces zaustavljen!";
			model.addAttribute("message", message);
			odgovor=false;
			return zalba(model);
			
		}else{
			runtimeService.activateProcessInstanceById(processInstance());
			message = "Zahtev odbijen, proces se nastavlja!";
			model.addAttribute("message", message);
			odgovor=false;
			return zalba(model);
			
		}
		
		
		
		
	}
	
	
	private String processInstance(){
		
		List<ProcessInstance> procDefl = runtimeService.createProcessInstanceQuery().processDefinitionKey("loanRequest").orderByProcessInstanceId().desc().list();
		ProcessInstance procDef=procDefl.get(0);
		
		return procDef.getId();
		
	}
	

}
