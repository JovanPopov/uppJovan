package activiti.spring.loanRequest.springweb.controllers;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import activiti.spring.tender.entity.Ponudjac;

@Controller
@RequestMapping(value="/application")
public class PonudeController {
	
	@Autowired
	RuntimeService runtimeService;
	
	@RequestMapping(value="/ponude")
	public String ponude(ModelMap model){
		try{
		
		List<ProcessInstance> procDefl = runtimeService.createProcessInstanceQuery().processDefinitionKey("loanRequest").orderByProcessInstanceId().desc().list();
		ProcessInstance procDef=procDefl.get(0);
		String pid=procDef.getId();
		
		List<Ponudjac> ponudjaci=(List<Ponudjac>) runtimeService.getVariable(pid, "ponudjaciSortirano");
		model.addAttribute("ponudjaci",ponudjaci);
		}catch(Exception e){}
		
		return "application/ponude";
		
	}

}
