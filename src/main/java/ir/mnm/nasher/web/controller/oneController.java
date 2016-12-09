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
 * Created by mghasemy on 12/10/16.
 */
@Controller
public class oneController {
    private BlogPostDao blogPostDao;
    private CategoryDao categoryDao;

    public oneController(BlogPostDao blogPostDao, CategoryDao cd) {
        this.blogPostDao = blogPostDao;
        this.categoryDao = cd;
    }
    @RequestMapping(value = "one/{title}/{oneid}", method = RequestMethod.GET)
    public ModelAndView listblogbycateg(@PathVariable Long oneid){
        BlogPost post=null;
        List<Category> allcateg=null;
        if(null!=blogPostDao)
            post= blogPostDao.find(oneid);
        if(null!=categoryDao)
            allcateg=categoryDao.findAll();
        ModelAndView model = new ModelAndView("one");
        model.addObject("categlists", allcateg);
        model.addObject("post", post);
        model.addObject("tools", new ir.mnm.nasher.util.tools());
        return model;
    }
}
