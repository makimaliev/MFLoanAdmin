package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.IdentityDocType;
import kg.gov.mf.loan.admin.org.service.IdentityDocTypeService;
 
@Component
public class IdentityDocTypeConverter implements Converter<String, IdentityDocType>{
 
    @Autowired
    IdentityDocTypeService identityDocTypeService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public IdentityDocType convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        IdentityDocType identityDocType = identityDocTypeService.findById((long)id);
        return identityDocType;
    }
     
}