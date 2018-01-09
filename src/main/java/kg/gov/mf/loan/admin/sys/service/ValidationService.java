package kg.gov.mf.loan.admin.sys.service;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import kg.gov.mf.loan.admin.sys.model.*;

@Service
public class ValidationService {
	
	
	@Autowired
    private ObjectTypeService objectTypeService;
	
    public void setObjectTypeService(ObjectTypeService rs)
    {
        this.objectTypeService = rs;
    }
	
    public void validateObject(Object object, BindingResult result){
    	
    	System.out.println("test");
    	
    	Set<ObjectField> objectTypeFieldList = new HashSet<ObjectField>();
		
		objectTypeFieldList = this.objectTypeService.findByCode(object.getClass().getSimpleName()).getObjectField();
		
		for (ObjectField objectField : objectTypeFieldList) {
			
			
			for (ValidationTerm validationTerm : objectField.getValidationTerm()) {
			
				
				
				
				String sMethodName = "get"+objectField.getName().substring(0, 1).toUpperCase()+objectField.getName().substring(1, objectField.getName().length());
				
				try 
				{
					
					String objectToBeValidated = (object.getClass().getMethod(sMethodName, null).invoke(object)).toString();
					
					System.out.println(objectToBeValidated);
					
					if(validationTerm.getMax_length() >0)
					{
						if(objectToBeValidated.length()>validationTerm.getMax_length()) 
						{
							result.rejectValue(objectField.getName(), "error.cSystem.name.maxlength", "name must be < "+validationTerm.getMax_length());
						}
					}
					
					if(validationTerm.getMin_length() >0)
					{
						if(objectToBeValidated.length()<validationTerm.getMin_length()) 
						{
							result.rejectValue(objectField.getName(), "error.cSystem.name.mminlength", "name must be > "+validationTerm.getMin_length());
						}
					}
					
					
				} 
				catch 
				(	IllegalAccessException | 
					IllegalArgumentException | 
					InvocationTargetException | 
					NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				

			}
			
			
		}
    	
    }

}
