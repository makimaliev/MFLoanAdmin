package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.IdentityDocGivenBy;
import kg.gov.mf.loan.admin.org.service.IdentityDocGivenByService;
 
@Component
public class IdentityDocGivenByConverter implements Converter<String, IdentityDocGivenBy>{
 
    @Autowired
    IdentityDocGivenByService identityDocGivenByService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public IdentityDocGivenBy convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        IdentityDocGivenBy identityDocGivenBy = identityDocGivenByService.findById((long)id);
        return identityDocGivenBy;
    }
     
}