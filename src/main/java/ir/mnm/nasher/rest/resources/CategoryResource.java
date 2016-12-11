package ir.mnm.nasher.rest.resources;

import ir.mnm.nasher.JsonViews;
import ir.mnm.nasher.dao.blogpost.BlogPostDao;
import ir.mnm.nasher.dao.category.CategoryDao;
import ir.mnm.nasher.entity.BlogPost;
import ir.mnm.nasher.entity.Category;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
        List<Category> allEntries = this.categoryDao.findAll();

        return viewWriter.writeValueAsString(allEntries);
    }
}
