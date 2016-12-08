package ir.mnm.nasher.dao.accesstoken;

import ir.mnm.nasher.dao.Dao;
import ir.mnm.nasher.entity.AccessToken;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public interface AccessTokenDao extends Dao<AccessToken, Long>
{
    AccessToken findByToken(String accessTokenString);
}
