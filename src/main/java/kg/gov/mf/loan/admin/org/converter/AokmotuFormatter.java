package kg.gov.mf.loan.admin.org.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.Aokmotu;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.service.AokmotuService;
import kg.gov.mf.loan.admin.org.service.OrganizationService;
 
@Component
public class AokmotuFormatter implements Formatter<Aokmotu>{
 
    @Autowired
    AokmotuService aokmotuService;//Service -> DB

    @Override
    public String print(Aokmotu object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public Aokmotu parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.aokmotuService.findById(id);
		
		
	}
 

}