package TouristPathfinder2024.service;

import TouristPathfinder2024.data.UserRepository;
import TouristPathfinder2024.model.User;
import TouristPathfinder2024.web.dto.UserLoginDto;
import TouristPathfinder2024.web.dto.UserProfileDto;
import TouristPathfinder2024.web.dto.UserRegisterDto;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    public void register(UserRegisterDto userRegisterDto) {

        User user = this.modelMapper.map(userRegisterDto, User.class);

        user.setPassword(passwordEncoder.encode(userRegisterDto.getPassword()));


        userRepository.save(user);


    }


    public void login(UserLoginDto loginDto) {
        User user =
                userRepository.findByUsername(loginDto.getUsername());

        if (user == null) {
            throw new RuntimeException("Username not found!");
        }
        if (passwordEncoder.matches(loginDto.getPassword(),
                user.getPassword()) && !currentUser.isLoggedIn()) {
            currentUser.setUser(user);

        }

    }
    public void logout(){
         currentUser.setUser(null);
    }
    public UserProfileDto getProfileData(){
        return modelMapper.map(currentUser.getUser(), UserProfileDto.class);
    }
}
