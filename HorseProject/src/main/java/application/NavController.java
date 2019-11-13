package application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nav")
public class NavController {

    @RequestMapping(method = RequestMethod.POST)
    public String horses(Model model) {
        return "nav";
    }

}
