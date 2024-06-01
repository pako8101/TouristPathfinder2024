package TouristPathfinder2024.web;

import TouristPathfinder2024.web.dto.UserRegisterDto;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
@ModelAttribute ("userRegisterDto")
public UserRegisterDto userRegisterDto(){
    return  new UserRegisterDto();
}
    @GetMapping("users/register")

    public String viewRegister(Model model){

        if (!model.containsAttribute("userRegisterDto" )){
            model.addAttribute("userRegisterDto", new UserRegisterDto());
        }
        return "register";
    }
    @PostMapping("users/register")

    public String doRegister(@Valid UserRegisterDto userRegisterDto, BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){

                if (bindingResult.hasErrors() || !userRegisterDto.getPassword()
                .equals(userRegisterDto.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRegisterDto", userRegisterDto);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterDto", bindingResult);

            return "redirect:users/register";
        }

        return "redirect:login";
    }
    @GetMapping("users/login")

    public String viewLogin(){
        return "login";
    }

    @GetMapping("/users/logout")
    public String logout(HttpSession httpSession){
httpSession.invalidate();
        return "redirect:/";
    }

}
