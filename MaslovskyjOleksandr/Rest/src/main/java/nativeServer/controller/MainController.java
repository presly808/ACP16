package nativeServer.controller;

import com.google.gson.Gson;
import nativeServer.httpExample.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String authorizationGet(){
        return new Gson().toJson("token");
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String authorizationPost(@RequestBody ResponseDTO responseDTO){
        String response = responseDTO.toString() + "thanks";
        return new Gson().toJson(response);
    }

    @RequestMapping(value = "/token", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody String authorizationDelete(){
        return new Gson().toJson("deleted");
    }
}
