package technicalblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.Model.Post;
import technicalblog.Service.PostService;
import technicalblog.Service.UserService;

import java.util.ArrayList;

@Controller
public class PostController {

    @Autowired
    private PostService postservice;


    @RequestMapping("posts")
    public String getUserPosts(Model model) {
        ArrayList<Post> posts = postservice.getOnePost();
        model.addAttribute("posts", posts);
        return "posts";
        }

    @RequestMapping("/posts/newpost")
    public String newPost() {
        return "posts/create";
    }

    @RequestMapping(value = "/posts/create", method = RequestMethod.POST)
    public String createPost(Post newPost) {
        postservice.createPost(newPost);
        return "redirect:/posts";
    }
    }

