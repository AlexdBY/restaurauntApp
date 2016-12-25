package course.controller;

import course.dao.MenuRepository;
import course.domain.Meal;
import course.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by Alex on 18.12.2016.
 */
@Controller
@RequestMapping("/")
public class AdminEditController {

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(value = "/editmeal", method = RequestMethod.GET)
    public String edit() {
        return "editmeal";
    }


    @RequestMapping(value = "/meal/edit", method = RequestMethod.POST)
    public void OrderMeal(HttpSession httpSession, @RequestBody Menu meal){
        httpSession.setAttribute("currentEditMeal", meal.getMealName());
    }

}
