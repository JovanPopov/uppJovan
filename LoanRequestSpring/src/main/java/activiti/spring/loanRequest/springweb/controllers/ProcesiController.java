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
public class ProcesiController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@RequestMapping(value="/procesi")
	public String Procesi(ModelMap model){
		
		List<ProcessInstance> procDefl = runtimeService.createProcessInstanceQuery().processDefinitionKey("loanRequest").list();
		ProcessInstance procDef=procDefl.get(0);
		
		//String pid = procDef.getId();
		model.addAttribute("listaInstanci", procDefl);
		
		
		
		
		return "application/procesi";
	}

}
