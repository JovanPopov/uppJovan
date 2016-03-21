package activiti.spring.loanRequest.springweb.controllers;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import activiti.spring.tender.entity.Ponudjac;

@Controller
@RequestMapping(value="/application")
public class OglasiController {
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private RuntimeService runtimeService;
	
	@RequestMapping(value="/oglasi")
	private String Oglasi(ModelMap model){
		
		
		
		try{			
		String pid = processInstance();
		
		boolean oglasotvoreni= (Boolean) runtimeService.getVariable(pid, "oglasOtvoreniVidljiv");
		boolean oglasKvalifikacije=(Boolean) runtimeService.getVariable(pid, "oglasKvalifikacijeVidljiv");
		boolean oglasRestriktivni=(Boolean) runtimeService.getVariable(pid, "oglasRestriktivniVidljiv");
		
		
		
		model.addAttribute("oglasOtvoreni",oglasotvoreni);
		model.addAttribute("oglasKvalifikacije",oglasKvalifikacije);
		model.addAttribute("oglasRestriktivni",oglasRestriktivni);
		}catch(Exception ex){
			
		}
		return "application/oglasi";
	}
	
	//prijava na otvoreni
	@RequestMapping(value="/oglasi/prijavaOtvoreni", method=RequestMethod.GET)
	public String OglasiOtvoreni(ModelMap model){
		User user;
		String message="";
		
		String pid = processInstance();
		
		try {
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception ex) {
			return "redirect:/login";
		}
		
		String id = user.getUsername();
		List<Ponudjac> ponudjaciubazi=(List<Ponudjac>) runtimeService.getVariable(pid, "ponudjaci");
		for(Ponudjac pon:ponudjaciubazi){
			if(pon.getId().equals(id)) {
				message = "Ne mozete se prijaviti, vec se nalazite na listi!";
				model.addAttribute("message", message);
				return Oglasi(model);
			}
		}
		Execution execution= runtimeService.createExecutionQuery().processInstanceId(pid).messageEventSubscriptionName("porukaOtvoreni").singleResult();
		runtimeService.messageEventReceived("porukaOtvoreni", execution.getId(), null);
		runtimeService.setVariable(pid, "ponudjac", id);
		message = "Uspesno ste se prijavili!";
		
		
		
			

		model.addAttribute("message", message);
		return Oglasi(model);
		
				
		
	}
	
	//prijava na kvalifikacije
	@RequestMapping(value="/oglasi/prijavaKvalifikacije", method=RequestMethod.GET)
	public String OglasiKvalifikacije(ModelMap model){
		User user;
		String pid = processInstance();
		String message="";
		try {
			user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception ex) {
			return "redirect:/login";
		}
		
		String id = user.getUsername();
		List<Ponudjac> ponudjaciubazi=(List<Ponudjac>) runtimeService.getVariable(pid, "kandidati");
		if(!ponudjaciubazi.isEmpty()){
		for(Ponudjac pon:ponudjaciubazi){
			if(pon.getId().equals(id)) {
				message = "Ne mozete se prijaviti, vec se nalazite na listi!";
				model.addAttribute("message", message);
				return Oglasi(model);
			}
		}
		}
		Execution execution= runtimeService.createExecutionQuery().processInstanceId(pid).messageEventSubscriptionName("porukaKvalifikacije").singleResult();
		runtimeService.messageEventReceived("porukaKvalifikacije", execution.getId(), null);
		
		message = "Uspesno ste se prijavili!";
		

		model.addAttribute("message", message);
		return Oglasi(model);
		
		
	}

	//prijava na restriktivni
		@RequestMapping(value="/oglasi/prijavaRestriktivni", method=RequestMethod.GET)
		public String OglasiRestrikvitni(ModelMap model){
			User user;
			String pid = processInstance();
			String message="";
			try {
				user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			}
			catch (Exception ex) {
				return "redirect:/login";
			}
			
			
			
			String id = user.getUsername();
			
			List<Ponudjac> ponudjaciubazi=(List<Ponudjac>) runtimeService.getVariable(pid, "ponudjaci");
			for(Ponudjac pon:ponudjaciubazi){
				if(pon.getId().equals(id)) {
					message = "Ne mozete se prijaviti, vec se nalazite na listi!";
					model.addAttribute("message", message);
					return Oglasi(model);
				}
			}
			
			List<Ponudjac> kandidati=(List<Ponudjac>) runtimeService.getVariable(pid, "kandidati");
			for(Ponudjac pon:kandidati){
				if(pon.getId().equals(id)) {
					Execution execution= runtimeService.createExecutionQuery().processInstanceId(pid).messageEventSubscriptionName("porukaRestriktivni").singleResult();
					runtimeService.messageEventReceived("porukaRestriktivni", execution.getId(), null);
					runtimeService.setVariable(pid, "ponudjac", id);
					message = "Uspesno ste se prijavili!";
								

					model.addAttribute("message", message);
					return Oglasi(model);
					
					
					
					
				}
			}
			
			message = "Ne mozete se prijaviti, ne nalazite se na listi kandidata!";
			model.addAttribute("message", message);
			return Oglasi(model);
			
			
		}
		
		private String processInstance(){
			
			List<ProcessInstance> procDefl = runtimeService.createProcessInstanceQuery().processDefinitionKey("loanRequest").orderByProcessInstanceId().desc().list();
			ProcessInstance procDef=procDefl.get(0);
			
			return procDef.getId();
			
		}

}
