package technicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import technicalblog.Model.Post;
import technicalblog.Service.PostService;

import java.util.ArrayList;

@Controller

public class HomeController {

    public HomeController()
    {
        System.out.println("*** Home Controller ***");
    }

    @Autowired
    private PostService postservice;

    @RequestMapping("/")
    public String getAllPosts(Model model) {


        ArrayList<Post> posts = postservice.getAllPosts();
        model.addAttribute("posts", posts);

        return "index";

    }

}