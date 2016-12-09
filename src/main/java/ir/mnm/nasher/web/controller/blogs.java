package ir.mnm.nasher.web.controller;

import ir.mnm.nasher.dao.blogpost.BlogPostDao;
import ir.mnm.nasher.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mghasemy on 12/9/16.
 */
@Controller
public class blogs {

    @Autowired
    private BlogPostDao blogPostDao;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView listblog(){
        List<BlogPost> allEntries=null;
        if(null!=blogPostDao)
            allEntries= blogPostDao.findAll();
        //return back to index.jsp
        ModelAndView model = new ModelAndView("index");
        model.addObject("lists2", "NUmber=0");
        model.addObject("lists", allEntries);
        return model;

    }
}
