package ir.mnm.nasher.dao.user;

import ir.mnm.nasher.dao.Dao;
import ir.mnm.nasher.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDao extends Dao<User, Long>
{
    User loadUserByUsername(String username) throws UsernameNotFoundException;

    User findByName(String name);
}
