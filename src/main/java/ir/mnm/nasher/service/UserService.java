package ir.mnm.nasher.service;

import ir.mnm.nasher.entity.AccessToken;
import ir.mnm.nasher.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface UserService extends UserDetailsService
{
    User findUserByAccessToken(String accessToken);

    AccessToken createAccessToken(User user);
}
