package demo.chat.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class ChatController {

    @RequestMapping("/hello")
    public @ResponseBody String hello() {
        return "Hello world!"
    }

}
