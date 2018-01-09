package kg.gov.mf.loan.admin.sys.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import kg.gov.mf.loan.admin.sys.model.Information;
import kg.gov.mf.loan.admin.sys.model.Permission;
import kg.gov.mf.loan.admin.sys.service.PermissionService;
 
@Service
public class PermissionFormatter implements Formatter<Permission> {

    @Autowired
    PermissionService permissionService;//Service -> DB

    @Override
    public String print(Permission object, Locale locale) {
    	
        return (object != null ? (String.valueOf(object.getId())) : "");
    }

	@Override
	public Permission parse(String text, Locale locale) throws ParseException {
		
		Integer id = Integer.valueOf(text);
		
        return this.permissionService.findById(id);
		
		
	}
}