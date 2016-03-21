package activiti.spring.tender.customforms;

import org.activiti.engine.form.AbstractFormType;


@SuppressWarnings("serial")
public class ListFormType extends AbstractFormType{

	@Override
	public String getName() {
		return "list";
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
