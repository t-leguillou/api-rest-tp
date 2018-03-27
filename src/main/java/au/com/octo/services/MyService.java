package au.com.octo.services;

import au.com.octo.exceptions.MyBusinessException;
import org.springframework.stereotype.Service;

@Service
public class MyService {


    public String processStuff( String input) throws MyBusinessException {
        if("coucou".equals(input)) {
            throw new MyBusinessException("Not working");
        }
        return input.toUpperCase();
    }
}
