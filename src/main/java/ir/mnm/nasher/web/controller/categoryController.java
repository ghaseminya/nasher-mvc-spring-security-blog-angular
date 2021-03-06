package ir.mnm.nasher.web.controller;

import ir.mnm.nasher.dao.blogpost.BlogPostDao;
import ir.mnm.nasher.dao.category.CategoryDao;
import ir.mnm.nasher.entity.BlogPost;
import ir.mnm.nasher.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mghasemy on 12/9/16.
 */
@Controller
public class categoryController {
    private BlogPostDao blogPostDao;
    private CategoryDao categoryDao;

    public categoryController(BlogPostDao blogPostDao, CategoryDao cd) {
        this.blogPostDao = blogPostDao;
        this.categoryDao = cd;
    }
    @RequestMapping(value = "category/{title}/{categid}", method = RequestMethod.GET)
    public ModelAndView listblogbycateg(@PathVariable int categid,@PathVariable String title){
        System.out.println(categid);

        List<BlogPost> allEntries=null;
        List<Category> allcateg=null;
        if(null!=blogPostDao)
            allEntries= blogPostDao.blogbycateg(categid);
        if(null!=categoryDao)
            allcateg=categoryDao.findAll();
        //return back to index.jsp
        ModelAndView model = new ModelAndView("category");
        model.addObject("categlists", allcateg);
        model.addObject("bloglists", allEntries);
        model.addObject("categtitle", title);

        model.addObject("tools", new ir.mnm.nasher.util.tools());
        return model;

    }
}
