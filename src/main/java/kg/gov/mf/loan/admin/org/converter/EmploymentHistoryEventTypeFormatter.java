package kg.gov.mf.loan.admin.org.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import kg.gov.mf.loan.admin.org.model.*;
import kg.gov.mf.loan.admin.org.service.*;
 
@Service
public class EmploymentHistoryEventTypeFormatter implements Formatter<EmploymentHistoryEventType> {

    @Autowired
    EmploymentHistoryEventTypeService employmentHistoryEventTypeService;//Service -> DB

    @Override
    public String print(EmploymentHistoryEventType object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public EmploymentHistoryEventType parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.employmentHistoryEventTypeService.findById(id);
		
		
	}
}