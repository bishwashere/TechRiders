<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/controllers/ErrorsController.java
package com.techriders.logisticservice.controllers;
=======
package com.warehouseService.rabbitmq.controllers;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/controllers/ErrorsController.java

import org.springframework.boot.web.servlet.error.ErrorController;
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
