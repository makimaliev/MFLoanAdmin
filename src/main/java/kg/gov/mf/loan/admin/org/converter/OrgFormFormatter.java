package kg.gov.mf.loan.admin.org.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.OrgForm;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.service.OrgFormService;
 
@Component
public class OrgFormFormatter implements Formatter<OrgForm>{
 
    @Autowired
    OrgFormService orgFormService;
 
    @Override
    public String print(OrgForm object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public OrgForm parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.orgFormService.findById(id);
		
		
	}    
}