package ir.mnm.nasher.rest.resources;

import ir.mnm.nasher.JsonViews;
import ir.mnm.nasher.dao.blogpost.BlogPostDao;
import ir.mnm.nasher.dao.category.CategoryDao;
import ir.mnm.nasher.entity.BlogPost;
import ir.mnm.nasher.entity.Category;
import ir.mnm.nasher.entity.Role;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

/**
 * Created by mghasemy on 12/11/16.
 */
@Component
@Path("/category")
public class CategoryResource {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ObjectMapper mapper;



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String list() throws IOException
    {
        this.logger.info("list()");

        ObjectWriter viewWriter;
        if (this.isAdmin()) {
            viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
        } else {
            viewWriter = this.mapper.writerWithView(JsonViews.User.class);
        }
        List<Category> allEntries = this.categoryDao.findAll();

        return viewWriter.writeValueAsString(allEntries);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Category read(@PathParam("id") Long id)
    {
        this.logger.info("read(id)");

        Category categ = this.categoryDao.find(id);
        if (categ == null) {
            throw new WebApplicationException(404);
        }
        return categ;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Category create(Category categ)
    {
        this.logger.info("create(): " + categ);

        return this.categoryDao.save(categ);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Category update(@PathParam("id") Long id, Category categ)
    {
        this.logger.info("update(): " + categ);

        return this.categoryDao.save(categ);
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void delete(@PathParam("id") Long id)
    {
        this.logger.info("delete(id)");

        this.categoryDao.delete(id);
    }
    private boolean isAdmin()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        if ((principal instanceof String) && ((String) principal).equals("anonymousUser")) {
            return false;
        }
        UserDetails userDetails = (UserDetails) principal;

        return userDetails.getAuthorities().contains(Role.ADMIN);
    }
}
