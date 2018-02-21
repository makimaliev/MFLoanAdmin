package kg.gov.mf.loan.admin.org.converter;

import kg.gov.mf.loan.admin.org.model.Staff;
import kg.gov.mf.loan.admin.org.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class StaffFormatter implements Formatter<Staff> {

    @Autowired
    StaffService staffService;//Service -> DB

    @Override
    public String print(Staff object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public Staff parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.staffService.findById(id);
		
		
	}
}