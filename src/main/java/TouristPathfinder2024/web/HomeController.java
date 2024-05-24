package TouristPathfinder2024.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        double sofiaTemp = new Random().nextDouble();
        model.addAttribute("sofiaTemp",sofiaTemp);
        return "index";
    }

}
