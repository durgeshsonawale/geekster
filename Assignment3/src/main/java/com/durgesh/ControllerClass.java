package com.durgesh;

import email.MailHandler;
import email.MailMetaData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class ControllerClass {
    @Autowired
    public Car car; //when we write autowired on car object..spring will identify car as a bean ..and it will look fr it through component scan..
    @GetMapping("name")

    public Car getName1() throws MessagingException {
        MailHandler mh=new MailHandler();
        mh.t=car.toString();
        mh.sendMail();

        return car;
    }


}
