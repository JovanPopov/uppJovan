package activity.spring.tender.serviceTasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.apache.commons.lang3.time.DateUtils;

import activiti.spring.tender.entity.Ponudjac;

public class KvalifikacijePozivZaPodnosenjePonuda implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execute) throws Exception {
		
		List<Ponudjac> kandidati=new ArrayList<Ponudjac>();
		boolean tajmeristekao=false;
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Date newDate = DateUtils.addMinutes(date, 2);		
		String vremeIstekaTajmeraTemp = dateFormat.format(newDate);
		String[] tokens = vremeIstekaTajmeraTemp.split(" ");
		String vremeIstekaTajmera = tokens[0] + "T" + tokens[1];
		
		execute.setVariable("vremeIstekaTajmera", vremeIstekaTajmera);
		execute.setVariable("kandidati", kandidati);
		execute.setVariable("tajmeristekao", tajmeristekao);
		execute.setVariable("oglasKvalifikacijeVidljiv", true);
	}

}
