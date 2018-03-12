package kg.gov.mf.loan.admin.sys.converter;

import kg.gov.mf.loan.admin.sys.model.User;
import kg.gov.mf.loan.admin.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class UserFormatter implements Formatter<User> {

    @Autowired
    UserService userService;//Service -> DB

    @Override
    public String print(User object, Locale locale) {

        return (object != null ? (String.valueOf(object.getId())) : "");
    }

    @Override
    public User parse(String text, Locale locale) throws ParseException {

        long id = Integer.valueOf(text);
        if(id == 0) {
            User user = new User();
            user.setId(id);
            return user;
        }
        else
            return this.userService.findById(id);


    }
}
