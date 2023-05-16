package gp8.itc.cafe.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import gp8.itc.cafe.Controller.DB.RepositoryCafeTable;
import gp8.itc.cafe.Controller.DB.RepositoryDrink;
import gp8.itc.cafe.Controller.DB.RepositoryDrinkCategory;
import gp8.itc.cafe.Controller.DB.RepositoryDrinkSize;
import gp8.itc.cafe.Controller.DB.RepositoryUser;
import gp8.itc.cafe.Controller.DataStructure.CafeTable;
import gp8.itc.cafe.Controller.DataStructure.Drink;
import gp8.itc.cafe.Controller.DataStructure.DrinkCategory;
import gp8.itc.cafe.Controller.DataStructure.DrinkSize;
import gp8.itc.cafe.Controller.DataStructure.User;

import gp8.itc.cafe.Controller.Service.UserService;




@RestController
public class Controller {


    //login
    @GetMapping("/login")
    public Object login() {
        // a constructor of the ModelAndView class in Spring MVC. It is used to create a new instance of ModelAndView with the specified view name.
        // In Spring MVC, ModelAndView is a class that represents a model and view in the MVC pattern. It combines a model object, which holds the data to be displayed, and a view name, which specifies the template or view to render.
        return new ModelAndView("login");
    }
    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.POST, value="/login")
    @ResponseBody
    public Object processLoginForm(@ModelAttribute("User") User login) {
        String username = login.getUsername();
        String password = login.getPassword();
        String type = login.getType();
        // User user = repositoryLogin.getUserByEmail(login.getEmail());
        if (userService.loginTest(username, password, type)) {
            return new ModelAndView("loginSuccess");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }


    //add cashier
    @Autowired
    private RepositoryUser addCashierRepos;
    @GetMapping("/addCashier")
    public Object addCashier() {
        return new ModelAndView("addCashier");
    }

    @PostMapping("/addCashier")
    @ResponseBody
    public Object processAddCashierForm(@ModelAttribute("User") User addCashier) {
        addCashierRepos.save(addCashier);
        return new RedirectView("/addCashier");  
    }


    //admin dashboard
    @Autowired
    private RepositoryDrink repositoryDrink;
    @Autowired
    private RepositoryUser repositoryUser;
    

    // @GetMapping("/testThemeLeaf")
    // public ModelAndView adminDashboard() {
    //     List<Drink> drinks = repositoryDrink.findAll(); 
    //     ModelAndView modelAndView = new ModelAndView("/testThemeLeaf");
    //     modelAndView.addObject("drinks", drinks); // Add the drinks to the model
    //     return modelAndView;
    // }

    @GetMapping("/adminDashboard")
    public ModelAndView adminDashboard1() {
        // Retrieve drinks
        List<Drink> drinks = repositoryDrink.findAll();
    
        // Retrieve users
        List<User> users = repositoryUser.findAll();
    
        // Create a class to hold both drinks and users
        class DashboardData {
            private List<Drink> drinks;
            private List<User> users;
    
            public DashboardData(List<Drink> drinks, List<User> users) {
                this.drinks = drinks;
                this.users = users;
            }
    
            public List<Drink> getDrinks() {
                return drinks;
            }
    
            public List<User> getUsers() {
                return users;
            }
        }
    
        // Create an instance of DashboardData and pass drinks and users to it
        DashboardData dashboardData = new DashboardData(drinks, users);
    
        // Create a ModelAndView object and add the dashboardData object to it
        ModelAndView modelAndView = new ModelAndView("/adminDashboard");
        modelAndView.addObject("dashboardData", dashboardData);
    
        return modelAndView;
    }
    

    //sign up, will be deleted soon
    @Autowired
    private RepositoryUser repositorySignup;

    @GetMapping("/signup")
    public Object signup (){
        return new ModelAndView("/signup");
    }

    @RequestMapping(method=RequestMethod.POST, value="/signup")
    @ResponseBody
    public Object processSignupForm(@ModelAttribute("User") User signup) {
        //System.out.println(cafeTable.getTableNumber());
        repositorySignup.save(signup);
        return new RedirectView("/signup");  
    }
    

    //table
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

    //add drink
    @Autowired
    RepositoryDrink drinkRepository;
    @Autowired
    RepositoryDrinkSize drinkSizeRepository;
    @Autowired
    RepositoryDrinkCategory drinkCategoryRepository;

    @GetMapping("/addDrink")
    public Object addDrink() {
        return new ModelAndView("addDrink");
    }

    @PostMapping("/addDrink")
    @ResponseBody
    public Object processAddDrinkForm(@RequestParam("drinkName") String drinkNom, @RequestParam("drinkPrice") double drinkPrix, @RequestParam("drinkNote") String note, @RequestParam("categoryName") String categoryNom, @RequestParam("file") String limage) {

        Drink drinkName = new Drink();
        drinkName.setDrinkName(drinkNom);
        drinkName.setImage(limage);

        DrinkSize drinkSize = new DrinkSize();
        drinkSize.setPrice(drinkPrix);

        DrinkCategory drinkCategory = new DrinkCategory();
        drinkCategory.setDescription(note);
        drinkCategory.setName(categoryNom);

        drinkRepository.save(drinkName);
        drinkSizeRepository.save(drinkSize);
        drinkCategoryRepository.save(drinkCategory);
        
        //insert foreign key
        drinkName.setCategory_id(drinkCategory);
        drinkRepository.save(drinkName);

        drinkName.setSize_id(drinkSize);
        drinkRepository.save(drinkName);

        return new RedirectView("/addDrink");  
    }

    //delete drink
    @GetMapping("/drink/delete/{id}")
    public Object deleteDrink(@PathVariable Integer id) {
        Drink drink = drinkRepository.findById(id).get();
        int cateID = drink.getCategory_id().getDrink_categoryId();
        int sizeID = drink.getSize_id().getDrink_sizeId();
        
        drinkRepository.deleteById(id);
        drinkCategoryRepository.deleteById(cateID);
        drinkSizeRepository.deleteById(sizeID);

        return new RedirectView("/drink");
    }

    //edit drink
    @GetMapping("/drink")
    public Object drinkCategory(Model model) {
        model.addAttribute("drinks", drinkRepository.findAll());
        return new ModelAndView("drinkMenu");
    }
    @GetMapping("/drink/edit/{id}")
    public Object editDrink(@PathVariable Integer id, Model model) {
        Drink drink = drinkRepository.findById(id).get();
        model.addAttribute("drink", drink);
        return new ModelAndView("/editDrink");
    }
    
    @PostMapping("/drink/{id}")
    public Object drinkUpdated(@PathVariable Integer id,
                            @RequestParam("drinkName") String drinkNom, 
                            @RequestParam("drinkPrice") double drinkPrix, 
                            @RequestParam("drinkNote") String note) {
        Drink drink = drinkRepository.findById(id).get();
        int cateID = drink.getCategory_id().getDrink_categoryId();
        int sizeID = drink.getSize_id().getDrink_sizeId();

        DrinkCategory drinkCategory = drinkCategoryRepository.findById(cateID).get();
        DrinkSize drinkSize = drinkSizeRepository.findById(sizeID).get();
    
        drink.setDrinkName(drinkNom);
        drinkSize.setPrice(drinkPrix);
        drinkCategory.setDescription(note);

        drinkRepository.save(drink);
        drinkCategoryRepository.save(drinkCategory);
        drinkSizeRepository.save(drinkSize);

        return new RedirectView("/drink");
    }
}
