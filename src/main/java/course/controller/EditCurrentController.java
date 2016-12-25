package course.controller;

import course.dao.MenuRepository;
import course.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Alex on 18.12.2016.
 */
@Controller
@RequestMapping("/")
public class EditCurrentController {
    @RequestMapping(value = "/editcurrentmeal", method = RequestMethod.GET)
    public String edit() {
        return "editcurrentmeal";
    }

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(value = "/edit/currentmeal", method = RequestMethod.GET)
    public @ResponseBody
    Menu ViewFavorite(HttpSession httpSession) {
        Menu meal = menuRepository.findTop1ByMealName(httpSession.getAttribute("currentEditMeal").toString());
        return meal;
    }

    @RequestMapping(value = "/meal/deleteprev", method = RequestMethod.POST)
    public void DeletePrev(HttpSession httpSession, @RequestBody Menu meal){
        menuRepository.delete(meal.getMealId());
    }

    @RequestMapping(value = "/meal/addnew", method = RequestMethod.POST)
    public void AddNew(HttpSession httpSession, @RequestBody Menu meal){
        menuRepository.save(meal);
    }
}
