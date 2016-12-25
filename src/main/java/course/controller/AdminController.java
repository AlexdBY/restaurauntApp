package course.controller;

import course.dao.OrdersRepository;
import course.dao.UserRepository;
import course.domain.Orders;
import course.domain.TestUser;
import course.domain.User;
import course.domain.UserMeals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 14.12.2016.
 */

@Controller
@RequestMapping("/")
public class AdminController {

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String menu() {
        return "admin";
    }

    public AdminController() {
    }


    private OrdersRepository ordersRepo;

    @Autowired
    private UserRepository userRepository;

    @Inject
    public AdminController(OrdersRepository ordersRepo){
        this.ordersRepo = ordersRepo;
    }

    @RequestMapping(value = "/admin/info/", method = RequestMethod.GET)
    public
    @ResponseBody
    ArrayList<UserMeals> ViewOrders(HttpSession httpSession) {
        List<Orders> orders;
        orders = ordersRepo.findAll();
        int i = 0, k = 0;
        ArrayList users = new ArrayList();
        ArrayList<UserMeals> userMeals = new ArrayList();
        String userName;
        User user;
        for (Orders order: orders) {
            if (i > 0) for (int j = 0; j < i; j++) {
                if (users.get(j).equals(order.getUser())) { k = 1; }
            }
                if ((i == 0) || (i != 0 & !(users.get(i - 1).equals(order.getUser())) & (k == 0))) {
                    userName = order.getUser();
                    user = userRepository.findTop1ByName(userName);
                    UserMeals userMeal = new UserMeals(userName, user.getPhone(), user.getAddress(), ordersRepo.findByUser(userName));
                    userMeals.add(userMeal);
                    users.add(order.getUser());
                    i++;
                }
            k = 0;
        }
        return userMeals;
    }

    @RequestMapping(value = "/admin/applyorder", method = RequestMethod.POST)
    public String ApplyOrder(@RequestBody TestUser testUser) {
        List<Orders> orders;
        String user = testUser.getName();
        orders = ordersRepo.findByUser(user);
        for (Orders order : orders) {
            ordersRepo.delete(order.getMealId());
        }
        return "redirect:/admin/info/";
    }
}
