package TouristPathfinder2024.web;

import TouristPathfinder2024.model.CategoryType;
import TouristPathfinder2024.model.UserLevel;
import TouristPathfinder2024.model.dto.RouteShortInfoDto;
import TouristPathfinder2024.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.logging.Level;

@Controller
public class RoutsController {

private final RouteService routeService;

    public RoutsController(RouteService routeService) {
        this.routeService = routeService;
    }


    @GetMapping("/routes")
    public String routes(Model model){
    //    RouteShortInfoDto randomRoute = routeService.getRandomRoute();
        List<RouteShortInfoDto> routs = routeService.getAll();
        model.addAttribute("allRoutes",routs);

        return "routes";
    }

    @GetMapping("add-route")
    public ModelAndView addRoute(){

        ModelAndView modelAndView = new ModelAndView("add-route");

        modelAndView.addObject("route", new RouteShortInfoDto());
        modelAndView.addObject("levels", UserLevel.values());
        modelAndView.addObject("categoryType", CategoryType.values());




        return modelAndView;
    }






}
