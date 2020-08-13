package rabbitmq.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorsController implements ErrorController {

    @Override
    @RequestMapping("/error")
    public String getErrorPath() {
        return "404error";
    }

    @RequestMapping(value = "/forbidden")
    public  String forbiddenPage(){
        return "forbidden";
    }

}
