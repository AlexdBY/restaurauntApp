package course.controller;

import course.dao.BasketRepository;
import course.dao.OrdersRepository;
import course.domain.Basket;
import course.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Alex on 12.12.2016.
 */
@Controller
@RequestMapping("/")
public class BasketController {
    @RequestMapping(value = "/basket", method = RequestMethod.GET)
    public String basket() {
        return "basket";
    }

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    @RequestMapping(value = "/basket/info/", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Basket> ViewMeals(HttpSession httpSession) {
        List<Basket> meals;
        meals = basketRepository.findAll();
        return meals;
    }

    @RequestMapping(value = "/basket/delete/{mealId}", method = RequestMethod.GET)
    public String RemoveFromBasket(HttpSession httpSession, @PathVariable("mealId") long mealId) {
        basketRepository.delete(mealId);
        return "redirect:/basket";
    }

    @RequestMapping(value = "/basket/delete", method = RequestMethod.GET)
    public void RemoveAllFromBasket(HttpSession httpSession) {
        List<Basket> meals;
        meals = basketRepository.findAll();
        for (Basket meal : meals) {
            basketRepository.delete(meal.getMealId());
        }
    }

    @RequestMapping(value = "/basket/order", method = RequestMethod.POST)
    public void MakeOrder(HttpSession httpSession) {
        List<Basket> meals;
        meals = basketRepository.findAll();
        for (Basket meal : meals) {
            Orders order = new Orders(httpSession.getAttribute("name").toString(), meal.getMealName(), meal.getPrice(), meal.getDescription());
            ordersRepository.save(order);
        }
    }
}
