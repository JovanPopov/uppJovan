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

public class OtvoreniPozivZaPodnosenjePonuda implements JavaDelegate{

	@Override
	public void execute(DelegateExecution execute) throws Exception {
		
		List<Ponudjac> ponudjaci=new ArrayList<Ponudjac>();
		boolean tajmeristekao=false;
		List<Ponudjac> ponudjaciubazi= new ArrayList<Ponudjac>();
		Ponudjac mita=new Ponudjac("mita","Mita","mitinmejl", true, 10000000);
		ponudjaciubazi.add(mita);
		
		String tajmer =tajmer();
		
		
		execute.setVariable("ubazi", false);
		execute.setVariable("potvrdaKomisije", "ne");
		
		execute.setVariable("vremeIstekaTajmera", tajmer);
		execute.setVariable("ponudjaciubazi", ponudjaciubazi);
		execute.setVariable("tajmeristekao", tajmeristekao);
		execute.setVariable("ponudjaci", ponudjaci);
		execute.setVariable("oglasOtvoreniVidljiv", true);
	}
	public String tajmer(){
		String timer= new String();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Date newDate = DateUtils.addMinutes(date, 2);		
		String vremeIstekaTajmeraTemp = dateFormat.format(newDate);
		String[] tokens = vremeIstekaTajmeraTemp.split(" ");
		timer = tokens[0] + "T" + tokens[1];
		
		return timer;
	}
}
