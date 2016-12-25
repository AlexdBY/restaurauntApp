package course.controller;

import course.dao.MenuRepository;
import course.domain.Meal;
import course.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Created by Alex on 17.12.2016.
 */
@Controller
@RequestMapping("/")
public class AdminAddController {

    @RequestMapping(value = "/addmeal", method = RequestMethod.GET)
    public String menu() {
        return "addmeal";
    }

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    public AdminAddController(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public void AddMeal(HttpSession httpSession, @RequestBody Menu meal){
        Menu newMeal = new Menu(meal.getPhoto(), meal.getMealName(), meal.getPrice(), meal.getDescription());
        if (!Optional.ofNullable(menuRepository.findTop1ByMealName(meal.getMealName())).isPresent()) {
            menuRepository.save(newMeal);
        }
        else System.out.println("Exists!");
    }
}
