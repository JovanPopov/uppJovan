package activiti.spring.loanRequest.springweb.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import activiti.spring.loanRequest.enitity.Loan;

public class LoanService {

	/* Properties */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* API */
	
	public Loan buildLoan(String clientsName,String clientsSurname,
			 String clientsEmail,Long clientsIncome,Long requestedLoan,Boolean creditOk) {
		 Loan loan = new Loan();
		 loan.setClientsEmail(clientsEmail);
		 loan.setClientsIncome(clientsIncome);
		 loan.setClientsName(clientsName);
		 loan.setClientsSurname(clientsSurname);
		 loan.setCreditOk(creditOk);
		 loan.setRequestedLoan(requestedLoan);
		 
		 entityManager.persist(loan);
		 return loan;
	}
}
