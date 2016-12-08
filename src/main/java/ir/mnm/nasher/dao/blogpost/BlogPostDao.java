package ir.mnm.nasher.dao.blogpost;

import ir.mnm.nasher.dao.Dao;
import ir.mnm.nasher.entity.BlogPost;

/**
 * Definition of a Data Access Object that can perform CRUD Operations for {@link BlogPost}s.
 *
 * @author Philip W. Sorst <philip@sorst.net>
 */
public interface BlogPostDao extends Dao<BlogPost, Long>
{
}
