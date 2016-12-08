package ir.mnm.nasher.service;

import ir.mnm.nasher.entity.AccessToken;
import ir.mnm.nasher.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Mohammad Mahdi mohammad.ghasemy@gmail.com
 */
public interface UserService extends UserDetailsService
{
    User findUserByAccessToken(String accessToken);

    AccessToken createAccessToken(User user);
}
