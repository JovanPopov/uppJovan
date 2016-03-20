package activiti.spring.loanRequest.springweb.controllers;

import java.util.List;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import activiti.spring.tender.entity.Ponudjac;

@Controller
@RequestMapping(value="/application")
public class ProcesiController {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/procesi")
	public String Procesi(ModelMap model){
		
		List<ProcessInstance> procDefl = runtimeService.createProcessInstanceQuery().processDefinitionKey("loanRequest").list();
		model.addAttribute("listaInstanci", procDefl);
		
		List<HistoricProcessInstance> history=historyService.createHistoricProcessInstanceQuery().finished().list();
		model.addAttribute("history", history);
		
		List<Task> tasks = taskService.createTaskQuery().active().list();
		model.addAttribute("tasks", tasks);
		return "application/procesi";
	}

	@RequestMapping(value="/procesi/kill/{taskId}")
	public String Kill(@PathVariable String taskId, ModelMap model){
		
		runtimeService.deleteProcessInstance(taskId, "Rucno ugasen");
		
				
		return "redirect:/application/procesi";
	}
}
