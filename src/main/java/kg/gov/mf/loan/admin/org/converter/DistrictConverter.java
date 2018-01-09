package kg.gov.mf.loan.admin.org.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import kg.gov.mf.loan.admin.org.model.District;
import kg.gov.mf.loan.admin.org.service.DistrictService;
 
@Component
public class DistrictConverter implements Converter<String, District>{
 
    @Autowired
    DistrictService districtService;
 
    /**
     * Gets UserProfile by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public District convert(String element) 
    {
        Integer id = Integer.parseInt((String)element);
        District district = districtService.findById((long)id);
        return district;
    }
     
}