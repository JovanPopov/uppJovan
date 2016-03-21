package activiti.spring.tender.customforms;

import org.activiti.engine.form.AbstractFormType;

public class EmailFormType extends AbstractFormType{
	@Override
	public String getName() {
		return "email";
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
