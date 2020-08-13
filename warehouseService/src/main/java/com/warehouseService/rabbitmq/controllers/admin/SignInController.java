<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/controllers/user/SignInController.java
package com.techriders.logisticservice.controllers.user;
=======
package com.warehouseService.rabbitmq.controllers.admin;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/controllers/admin/SignInController.java

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @GetMapping(value = "/")
    public String login(){
        return "user/loginform";
    }
}
