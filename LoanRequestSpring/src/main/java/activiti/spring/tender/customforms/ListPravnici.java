package activiti.spring.tender.customforms;

import org.activiti.engine.form.AbstractFormType;

public class ListPravnici extends AbstractFormType{

	@Override
	public String getName() {
		return "listPravnici";
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		if (modelValue == null) {
			return null;
		}
		return modelValue.toString();
	}

}
