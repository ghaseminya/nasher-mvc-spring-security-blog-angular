package ir.mnm.nasher.dao.blogpost;

import ir.mnm.nasher.dao.JpaDao;
import ir.mnm.nasher.entity.BlogPost;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * JPA Implementation of a {@link BlogPostDao}.
 *
 * @author Mohammad Mahdi mohammad.ghasemy@gmail.com
 */
public class JpaBlogPostDao extends JpaDao<BlogPost, Long> implements BlogPostDao
{
    public JpaBlogPostDao()
    {
        super(BlogPost.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BlogPost> findAll()
    {
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<BlogPost> criteriaQuery = builder.createQuery(BlogPost.class);

        Root<BlogPost> root = criteriaQuery.from(BlogPost.class);
        criteriaQuery.orderBy(builder.desc(root.get("date")));

        TypedQuery<BlogPost> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
    @Override
    @Transactional(readOnly = true)
    public List<BlogPost> blogbycateg(int categ){
        final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
        final CriteriaQuery<BlogPost> criteriaQuery = builder.createQuery(BlogPost.class);

        Root<BlogPost> root = criteriaQuery.from(BlogPost.class);
        Path<String> namePath = root.get("category");
        criteriaQuery.where(builder.equal(namePath, categ));
        criteriaQuery.orderBy(builder.desc(root.get("date")));

        TypedQuery<BlogPost> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }
}
