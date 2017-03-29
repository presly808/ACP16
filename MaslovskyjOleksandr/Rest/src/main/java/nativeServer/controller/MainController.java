package nativeServer.controller;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MainController {


    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public @ResponseBody String authorization(){
        return new Gson().toJson("token");
    }

    @RequestMapping(value = "/t")
    public @ResponseBody String test(){
        return new Gson().toJson("test");
    }

}
