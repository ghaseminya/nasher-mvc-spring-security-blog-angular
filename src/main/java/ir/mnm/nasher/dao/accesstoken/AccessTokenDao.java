package ir.mnm.nasher.dao.accesstoken;

import ir.mnm.nasher.dao.Dao;
import ir.mnm.nasher.entity.AccessToken;

/**
 * @author Mohammad Mahdi mohammad.ghasemy@gmail.com
 */
public interface AccessTokenDao extends Dao<AccessToken, Long>
{
    AccessToken findByToken(String accessTokenString);
}
