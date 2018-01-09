package kg.gov.mf.loan.admin.sys.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.sys.model.*;
import kg.gov.mf.loan.admin.sys.service.*;
 
@Component
public class InformationConverter implements Converter<String, Information>{
 
    @Autowired
    InformationService informationService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Information convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        Information information = informationService.findById((long)id);
        return information;
    }
     
}