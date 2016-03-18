package activiti.spring.loanRequest.deploy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Klasa zaduzena za deployment
 * @author xyz
 */
public class ProcessDeployer {

	/* Properties */
	
	private static final String filename = "diagrams/Tender.bpmn";
	private static Scanner scanner;

	/* Main method */
	
	public static void main (String[] args) {
		scanner = new Scanner(System.in);
		ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

		System.out.println("Deploy-ovati definiciju? [d/n]");
		Character reply = scanner.next().charAt(0);
		RepositoryService repositoryService = processEngine.getRepositoryService();

		if (reply == 'd') {
			System.out.println("Izbrisati prethodne deploymente? [d/n]");
			if (scanner.next().equalsIgnoreCase("d"))
				for (Deployment d : repositoryService.createDeploymentQuery().list())
					repositoryService.deleteDeployment(d.getId(), true);
			
			repositoryService.createDeployment().addClasspathResource(filename).deploy();
			System.out.println("Ukupan broj deployment-a: " + repositoryService.createDeploymentQuery().count());
		}
	}
}
