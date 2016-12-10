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
public class signController {
    private BlogPostDao blogPostDao;
    private CategoryDao categoryDao;

    public signController(BlogPostDao blogPostDao, CategoryDao cd) {
        this.blogPostDao = blogPostDao;
        this.categoryDao = cd;
    }
    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView model = new ModelAndView("signup");
        model.addObject("tools", new ir.mnm.nasher.util.tools());
        return model;
    }
}
