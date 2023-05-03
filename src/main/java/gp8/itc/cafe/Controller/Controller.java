package gp8.itc.cafe.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import gp8.itc.cafe.Controller.DB.RepositoryCafeTable;
import gp8.itc.cafe.Controller.DB.RepositoryDrinkCategory;
import gp8.itc.cafe.Controller.DB.RepositoryUser;
import gp8.itc.cafe.Controller.DataStructure.CafeTable;

import gp8.itc.cafe.Controller.DataStructure.DrinkCategory;
import gp8.itc.cafe.Controller.DataStructure.User;


@RestController
public class Controller {
    //
    // @Autowired
    // private RepositoryUser repositoryLogin;

    // @GetMapping("/login")
    // public Object login() {
    //     return new ModelAndView("login");
    // }

    // @RequestMapping(method=RequestMethod.POST, value="/login")
    // @ResponseBody
    // public Object processLoginForm(@ModelAttribute("User") User login) {
    //     //System.out.println(cafeTable.getTableNumber());
    //     repositoryLogin.save(login);
    //     return new RedirectView("/login");  
    // }

    //
    @Autowired
    private RepositoryUser repositorySignup;

    @GetMapping("/signup")
    public Object signup() {
        return new ModelAndView("/signup");
    }

    @RequestMapping(method=RequestMethod.POST, value="/signup")
    @ResponseBody
    public Object processSignupForm(@ModelAttribute("User") User signup) {
        //System.out.println(cafeTable.getTableNumber());
        repositorySignup.save(signup);
        return new RedirectView("/signup");  
    }
    //
    @Autowired
    private RepositoryCafeTable repositoryCafeTable;

    @GetMapping("/index")
    public Object test() {
        return new ModelAndView("index");
    }

    @RequestMapping(method=RequestMethod.POST, value="/index")
    @ResponseBody
    public Object processLoginForm(@ModelAttribute("CafeTable") CafeTable cafeTable) {
        //System.out.println(cafeTable.getTableNumber());
        repositoryCafeTable.save(cafeTable);
        return new RedirectView("/index");  
    }
    
    //drink
    // @Autowired
    // private RepositoryDrink repositoryDrink;

    // @GetMapping("/drink")
    // public Object drink() {
    //     return new ModelAndView("drink");
    // }

    // @RequestMapping(method=RequestMethod.POST, value="/drink")
    // @ResponseBody
    // public Object processDrink(@ModelAttribute("Drink") Drink drink) {
    //     //System.out.println(cafeTable.getTableNumber());
    //     repositoryDrink.save(drink);
    //     return new RedirectView("/drink");  
    // }

    //drink category
    @Autowired
    private RepositoryDrinkCategory repositoryDrinkCat;

    @GetMapping("/drinkCat")
    public Object drinkCat() {
        return new ModelAndView("drinkCat");
    }

    @RequestMapping(method=RequestMethod.POST, value="/drinkCat")
    @ResponseBody
    public Object processDrinkCat(@ModelAttribute("DrinkCategory") DrinkCategory drinkCat) {
        //System.out.println(cafeTable.getTableNumber());
        repositoryDrinkCat.save(drinkCat);
        return new RedirectView("/drinkCat");  
    }
}
