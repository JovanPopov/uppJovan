package activiti.spring.tender.customforms;

import org.activiti.engine.form.AbstractFormType;

public class ListStrucnjaci extends AbstractFormType{

	@Override
	public String getName() {
		return "listStrucnjaci";
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
