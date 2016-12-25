package course.controller;

import course.dao.BasketRepository;
import course.dao.MenuRepository;
import course.domain.Basket;
import course.domain.Meal;
import course.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * Created by Alex on 11.12.2016.
 */
@Controller
@RequestMapping("/")
public class MenuController {

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String menu() {
        return "menu";
    }


    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    public MenuController(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }

    @RequestMapping(value = "/meal/info/", method = RequestMethod.GET)
    public @ResponseBody
    List<Menu> ViewMeals(HttpSession httpSession){
        List<Menu> meals;
        meals = menuRepository.findAll();
        return meals;
    }

    @RequestMapping(value = "/meal/order", method = RequestMethod.POST)
    public void OrderMeal(HttpSession httpSession, @RequestBody Menu meal){
        Basket test = new Basket(meal.getPhoto(), meal.getMealName(), meal.getPrice(), meal.getDescription());
        basketRepository.save(test);
    }
}

