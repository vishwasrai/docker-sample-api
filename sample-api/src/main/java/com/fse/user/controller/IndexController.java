package com.fse.user.controller;

import com.fse.user.dao.PostRepository;
import com.fse.user.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Logger;

@Controller
public class IndexController {
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    public PostRepository postRepository;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public ModelMap saveDetails(HttpServletRequest request, HttpServletResponse response) {
        ModelMap model = new ModelMap("index");
        postRepository.save( new Post(1, "This is first POST!!!!",  new Date()));
        model.addAttribute("newfeature", "I am running from Docker");
        return model;
    }
}
