package TouristPathfinder2024.service;

import TouristPathfinder2024.model.User;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.SessionScope;

@Component
//@Scope(value = WebApplicationContext.SCOPE_REQUEST,proxyMode = ScopedProxyMode.TARGET_CLASS)
@SessionScope
public class CurrentUser {

    private User user;

    public boolean isLoggedIn(){
        return this.user != null;
    }

    public boolean isAdmin(){
        return
                this.user.getRoles()
                .stream().anyMatch(role -> role.getName()
                        .equals("ADMIN"));
    }
    public User getUser() {
        return user;
    }

    public CurrentUser setUser(User user) {
        this.user = user;
        return this;
    }

}

