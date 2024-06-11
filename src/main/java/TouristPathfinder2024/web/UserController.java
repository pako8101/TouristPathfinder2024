package TouristPathfinder2024.web;

import TouristPathfinder2024.model.UserLevel;
import TouristPathfinder2024.service.CurrentUser;
import TouristPathfinder2024.service.UserService;
import TouristPathfinder2024.web.dto.UserLoginDto;
import TouristPathfinder2024.web.dto.UserRegisterDto;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userRegisterDto")
    public UserRegisterDto userRegisterDto() {
        return new UserRegisterDto();
    }
    @ModelAttribute("loginDto")
    public UserLoginDto loginDto() {
        return new UserLoginDto();
    }

    @GetMapping("/register")

    public String viewRegister(Model model) {

//        if (!model.containsAttribute("userRegisterDto" )){
//
//
//        }
        model.addAttribute("userRegisterDto", new UserRegisterDto());
        model.addAttribute("level", UserLevel.values());
        return "register";
    }

    @PostMapping("/register")

    public String doRegister(@Valid UserRegisterDto userRegisterDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

//                if (bindingResult.hasErrors() || !userRegisterDto.getPassword()
//                .equals(userRegisterDto.getConfirmPassword())) {
//            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
//            redirectAttributes.addFlashAttribute(
//                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);
//
//            return "redirect:/users/register";
//        }

        userService.register(userRegisterDto);
        return "redirect:/users/login";
    }

    @GetMapping("/login")

    public String viewLogin() {
        ModelAndView modelAndView = new ModelAndView("login");

        modelAndView.addObject("loginDto",new UserLoginDto());
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")

    public String login(@Valid UserLoginDto loginDto) {

        userService.login(loginDto);

        return "redirect:/";
    }
    @GetMapping("/profile")
    public ModelAndView profile(){
        ModelAndView modelAndView = new ModelAndView("profile");

        modelAndView.addObject("profileData",userService.getProfileData());
        return modelAndView;
    }
}
