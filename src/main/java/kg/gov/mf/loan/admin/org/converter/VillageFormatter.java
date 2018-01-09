package kg.gov.mf.loan.admin.org.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.Village;
import kg.gov.mf.loan.admin.org.model.Organization;
import kg.gov.mf.loan.admin.org.service.VillageService;
import kg.gov.mf.loan.admin.org.service.OrganizationService;
 
@Component
public class VillageFormatter implements Formatter<Village>{
 
    @Autowired
    VillageService villageService;//Service -> DB

    @Override
    public String print(Village object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public Village parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.villageService.findById(id);
		
		
	}
 

}