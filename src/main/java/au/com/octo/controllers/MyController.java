package au.com.octo.controllers;

import au.com.octo.exceptions.MyBusinessException;
import au.com.octo.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    private MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    @RequestMapping(value = "/api/v1/url/{param}", produces = { "application/json" }, method = RequestMethod.GET)
    ResponseEntity<String> get(@PathVariable("param") String param) throws MyBusinessException {
        String resultFromMyService = myService.processStuff(param);
        return new ResponseEntity<>("This is the param I received " + resultFromMyService, HttpStatus.OK);
    }
}
