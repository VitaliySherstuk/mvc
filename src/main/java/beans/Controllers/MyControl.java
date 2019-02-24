package beans.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class MyControl {

    @RequestMapping(method= RequestMethod.GET)
    public String myMeth(){

        return "index";
    }
}
