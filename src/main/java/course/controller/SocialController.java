package course.controller;

import course.dao.UserRepository;
import course.domain.CustomString;
import course.domain.TestUser;
import course.domain.URL;
import course.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * Created by Alex on 10.12.2016.
 */
@Controller
@RequestMapping("/")

public class SocialController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String menu() {
        return "index";
    }

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/create/user", method = RequestMethod.POST)
    public void CreateUser(HttpSession httpSession, @RequestBody TestUser user){
        User test = new User(user.getName(), user.getPassword(), user.getPhone(), user.getAddress());
        if (!Optional.ofNullable(userRepository.findTop1ByName(user.getName())).isPresent()) {
            userRepository.save(test);
        }
        else System.out.println("Exists!");

    }

    @RequestMapping(value = "/user/name", method = RequestMethod.GET)
    public @ResponseBody
    CustomString ViewName(HttpSession httpSession) {
        if (httpSession.getAttribute("name") != null) {
            return new CustomString(httpSession.getAttribute("name").toString());
        }
        return new CustomString("null");
    }

    @RequestMapping(value = "/login/user", method = RequestMethod.POST)
    public void LoginUser(HttpSession httpSession, @RequestBody TestUser user){
        User test = userRepository.findTop1ByName(user.getName());
        httpSession.setAttribute("name", null);
        if (Optional.ofNullable(userRepository.findByName(user.getName())).isPresent())
                if (test.getPassword().equals(user.getPassword())) {
            httpSession.setAttribute("name", user.getName());
            httpSession.setAttribute("role", test.getRole());
        }
    }

    @RequestMapping(value = "/login/user2", method = RequestMethod.GET)
    public @ResponseBody URL LoginUserGet(HttpSession httpSession){
        if (httpSession.getAttribute("role").equals("admin")) {
            return new URL("http://localhost:8080/admin");
        }
        if (httpSession.getAttribute("name") != null) {
            return new URL("http://localhost:8080/menu");
        }
        else return new URL("http://localhost:8080/userisnotexist");
    }

}
