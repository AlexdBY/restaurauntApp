package course.controller;

import course.dao.MenuRepository;
import course.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Alex on 19.12.2016.
 */
@Controller
@RequestMapping("/")
public class AdminMenuController {
    @RequestMapping(value = "/adminmenu", method = RequestMethod.GET)
    public String menu() {
        return "adminmenu";
    }

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    public void DeleteMeal(HttpSession httpSession, @RequestBody Menu meal){
        menuRepository.delete(meal.getMealId());
    }
}
