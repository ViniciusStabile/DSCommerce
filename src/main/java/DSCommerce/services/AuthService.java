package DSCommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DSCommerce.entities.User;
import DSCommerce.services.exceptions.ForbiddenException;

@Service
public class AuthService {

    @Autowired
    UserService userService;

    public void ValidateSelfOrAdmin(long userId) {
        User me = userService.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new ForbiddenException("Access denied");
        }
    }
}
