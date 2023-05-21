package gp8.itc.cafe.Controller;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.io.File;
import java.io.IOException;

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
    //@ModelAttribute("User") this allows us to access method in User class and also add class in view file html
    public Object processLoginForm(@ModelAttribute("User") User login) {
        String username = login.getUsername();
        String password = login.getPassword();
        String type = login.getType();
        // User user = repositoryLogin.getUserByEmail(login.getEmail());
        if (userService.loginTest(username, password, type)){
            if(type.equals("admin")) {
                return new RedirectView("/adminDashboard");
            }
            else{
                return new RedirectView("/tableSelect");
            }
            // return new ModelAndView("loginSuccess");
        } else {
            return new ModelAndView("redirect:/login");
        }
    }


    //User
    //Add cashier
    @Autowired
    private RepositoryUser addCashierRepos;
    @GetMapping("/adminDashboard/addCashier")
    public Object addCashier() {
        return new ModelAndView("addCashierNew");
    }

    @PostMapping("/adminDashboard/addCashier")
    @ResponseBody
    // MultipartFile is a class in Spring Framework that represents a file that has been uploaded via a form in a web application. It is typically used for handling file uploads in Spring applications
    public Object processAddCashierForm(@RequestParam("name") String nom, @RequestParam("sex") String gender, @RequestParam("dob") String dateOfBirth, @RequestParam("username") String unom, @RequestParam("password") String pass, @RequestParam("hd") String hiredDate ,@RequestParam("file") MultipartFile limage) {

        User user = new User();
        user.setName(nom);
        user.setSex(gender);
        user.setDob(dateOfBirth);
        user.setUsername(unom);
        user.setPassword(pass);
        user.setHiredDate(hiredDate);
        user.setType("cashier");
        // the .getOriginalFileName extract image name
        String fileName = limage.getOriginalFilename();
        //if fileName is "C:/path/to/my_image.jpg", then cleanFileName will contain "my_image.jpg", which is the extracted filename from the file path.
        String cleanFileName = new File(fileName).getName();
        if(cleanFileName.contains("..")){
            System.out.println("not a valid file");
        }
        //encode from imagefile to string
        try {
            user.setImage(Base64.getEncoder().encodeToString(limage.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        addCashierRepos.save(user);

        return new RedirectView("/adminDashboard/addCashier");  
    }

    //delete user
    @Autowired
    RepositoryUser userRepository;
    @GetMapping("/user/delete/{id}")
    public Object deleteUser(@PathVariable Integer id) {
        //User user = userRepository.findById(id).get();
        userRepository.deleteById(id);
        return new RedirectView("/adminDashboard");
    }

    //edit user
    @GetMapping("/user/edit/{id}")
    public Object editUser(@PathVariable Integer id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return new ModelAndView("/editUser");
    }

    @PostMapping("/user/{id}")
    public Object userUpdated(@PathVariable Integer id,
                            @RequestParam("name") String nom, @RequestParam("sex") String gender, @RequestParam("dob") String dobirth,
                            @RequestParam("username") String myusername,
                            @RequestParam("password") String passmot, @RequestParam("hd") String hiredDate  ,@RequestParam("file") MultipartFile limage) {
        User user = userRepository.findById(id).get();
        String fileName = limage.getOriginalFilename();
        //if fileName is "C:/path/to/my_image.jpg", then cleanFileName will contain "my_image.jpg", which is the extracted filename from the file path.
        String cleanFileName = new File(fileName).getName();
        if(cleanFileName.contains("..")){
            System.out.println("not a valid file");
        }
        //encode from imagefile to string
        try {
            user.setImage(Base64.getEncoder().encodeToString(limage.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setName(nom);    
        user.setSex(gender);    
        user.setDob(dobirth);                
        user.setUsername(myusername);
        user.setPassword(passmot);
        user.setHiredDate(hiredDate);

        userRepository.save(user);

        return new RedirectView("/adminDashboard");
    }


    //admin dashboard
    @Autowired
    private RepositoryDrink repositoryDrink;
    @Autowired
    private RepositoryUser repositoryUser;
    @Autowired
    private RepositoryDrinkCategory repositoryDrinkCategory;
    

    @GetMapping("/adminDashboard")
    public ModelAndView adminDashboard1() {
        // Retrieve drinks
        List<Drink> drinks = repositoryDrink.findAll();
    
        // Retrieve users
        List<User> users = repositoryUser.findAll();

        List<DrinkCategory> drinkCategories = repositoryDrinkCategory.findAll();
    
        // Create a class to hold both drinks and users
        class DashboardData {
            private List<Drink> drinks;
            private List<User> users;
            private List<DrinkCategory> drinkCategories;
    
            public DashboardData(List<Drink> drinks, List<User> users, List<DrinkCategory> drinkCategories) {
                this.drinks = drinks;
                this.users = users;
                this.drinkCategories = drinkCategories;
            }
    
            public List<Drink> getDrinks() {
                return drinks;
            }
    
            public List<User> getUsers() {
                return users;
            }

            public List<DrinkCategory> getDrinkCategories() {
                return drinkCategories;
            }
        }
    
        // Create an instance of DashboardData and pass drinks and users to it
        DashboardData dashboardData = new DashboardData(drinks, users, drinkCategories);
    
        // Create a ModelAndView object and add the dashboardData object to it
        ModelAndView modelAndView = new ModelAndView("/adminDashboardTest");
        modelAndView.addObject("dashboardData", dashboardData);
    
        return modelAndView;
    }

    @Autowired
    private RepositoryUser repositoryUser1;
    @GetMapping("/user/cashier/view/{id}")
    public ModelAndView getUserDetails(@PathVariable Integer id) {
        // Retrieve the user details based on the provided ID from the database
        User user = repositoryUser1.findById(id).get();
    
        // Create a ModelAndView object and pass the user details to it
        ModelAndView modelAndView = new ModelAndView("adminDashboardTest");
        modelAndView.addObject("user", user);
    
        return modelAndView;
    }


    

    //table
    @Autowired
    private RepositoryCafeTable repositoryCafeTable;
    //manage table
    @GetMapping("/adminDashboard/manageTable")
    public Object test() {
        return new ModelAndView("manageTable");
    }

    @PostMapping("/adminDashboard/manageTable")
    public Object processLoginForm(@ModelAttribute("CafeTable") CafeTable cafeTable){
        repositoryCafeTable.save(cafeTable);
        return new RedirectView("/adminDashboard/manageTable");  
    }

    //table selection
    @GetMapping("/tableSelect")
    public Object tableView(Model model) {
        model.addAttribute("tables", repositoryCafeTable.findAll());
        return new ModelAndView("CashierPart/tableSelection");
    }

    //add table
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/tableSelect")
    public Object addTable(@RequestParam("tablenumber") Integer number) {

        if (number > 0 && number <= 100) {
            Long rowExisted = repositoryCafeTable.count();
            if (rowExisted > number) {
                for (int i = 1; i <= rowExisted; i++) {
                    if (i > number) {
                        repositoryCafeTable.deleteById(i);
                    }
                }
            } else if (rowExisted < number) {
                String sql = "ALTER TABLE cafe_table AUTO_INCREMENT = 1";
                jdbcTemplate.execute(sql);

                for (int i = (int) (rowExisted + 1); i <= number; i++) {
                    CafeTable cafeTable = new CafeTable();
                    cafeTable.setTablenumber(i);
                    cafeTable.setAvailability(1);
                    repositoryCafeTable.save(cafeTable);
                }
            }
            Long newRowCount = repositoryCafeTable.count();
            if (newRowCount % 2 == 0) {
                for (int i = 1; i <= newRowCount; i++) {
                    CafeTable cafeTable = repositoryCafeTable.findById(i).get();
                    if (i <= newRowCount / 2) {
                        cafeTable.setAvailability(1);
                    } else {
                        cafeTable.setAvailability(0);
                    }
                    repositoryCafeTable.save(cafeTable);
                }
            } else {
                for (int i = 1; i <= newRowCount; i++) {
                    CafeTable cafeTable = repositoryCafeTable.findById(i).get();
                    if (i <= (newRowCount / 2) + 1) {
                        cafeTable.setAvailability(1);
                    } else {
                        cafeTable.setAvailability(0);
                    }
                    repositoryCafeTable.save(cafeTable);
                }
            }
            return new RedirectView("/manageTable");
        }
        return new RedirectView("/manageTable?invalid");
    }

    //drink

    //add drink
    @Autowired
    RepositoryDrink drinkRepository;
    @Autowired
    RepositoryDrinkSize drinkSizeRepository;
    @Autowired
    RepositoryDrinkCategory drinkCategoryRepository;

    @GetMapping("/adminDashboard/addDrink")
    public Object addDrink() {
        return new ModelAndView("addDrink");
    }

    @PostMapping("/adminDashboard/addDrink")
    @ResponseBody
    // MultipartFile is a class in Spring Framework that represents a file that has been uploaded via a form in a web application. It is typically used for handling file uploads in Spring applications
    public Object processAddDrinkForm(@RequestParam("drinkName") String drinkNom, @RequestParam("drinkPrice") double drinkPrix, @RequestParam("drinkNote") String note, @RequestParam("categoryName") String categoryNom, @RequestParam("file") MultipartFile limage) {

        Drink drinkName = new Drink();
        drinkName.setDrinkName(drinkNom);
        // the .getOriginalFileName extract image name
        String fileName = limage.getOriginalFilename();
        //if fileName is "C:/path/to/my_image.jpg", then cleanFileName will contain "my_image.jpg", which is the extracted filename from the file path.
        String cleanFileName = new File(fileName).getName();
        if(cleanFileName.contains("..")){
            System.out.println("not a valid file");
        }
        //encode from imagefile to string
        try {
            drinkName.setImage(Base64.getEncoder().encodeToString(limage.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        DrinkSize drinkSize = new DrinkSize();
        drinkSize.setPrice(drinkPrix);

        DrinkCategory drinkCategory = new DrinkCategory();
        drinkCategory.setDescription(note);
        drinkCategory.setName(categoryNom);

        // drinkRepository.save(drinkName);
        drinkSizeRepository.save(drinkSize);
        drinkCategoryRepository.save(drinkCategory);
        
        //insert foreign key
        drinkName.setCategory_id(drinkCategory);
        // drinkRepository.save(drinkName);

        drinkName.setSizeId(drinkSize);
        drinkRepository.save(drinkName);

        return new RedirectView("/adminDashboard/addDrink");  
    }

    //add drink category
    @Autowired
    RepositoryDrinkCategory catRepos;
    @GetMapping("/adminDashboard/addDrinkCategory")
    public Object addDrinkCategory() {
        return new ModelAndView("addCategory");
    }


    @PostMapping("/adminDashboard/addDrinkCategory")
    public Object addDrinkCategoryToDB(@RequestParam("category") String cat) {
        DrinkCategory category = new DrinkCategory();
        category.setName(cat);
        catRepos.save(category);

        return new RedirectView("/adminDashboard/addDrinkCategory");
    }

    //delete drink
    @GetMapping("/drink/delete/{id}")
    public Object deleteDrink(@PathVariable Integer id) {
        Drink drink = drinkRepository.findById(id).get();
        int cateID = drink.getCategory_id().getDrink_categoryId();
        int sizeID = drink.getSizeId().getDrink_sizeId();
        
        drinkRepository.deleteById(id);
        drinkCategoryRepository.deleteById(cateID);
        drinkSizeRepository.deleteById(sizeID);

        return new RedirectView("/adminDashboard");
    }

    

    //dit drink
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
        int sizeID = drink.getSizeId().getDrink_sizeId();

        DrinkCategory drinkCategory = drinkCategoryRepository.findById(cateID).get();
        DrinkSize drinkSize = drinkSizeRepository.findById(sizeID).get();
    
        drink.setDrinkName(drinkNom);
        drinkSize.setPrice(drinkPrix);
        drinkCategory.setDescription(note);

        drinkRepository.save(drink);
        drinkCategoryRepository.save(drinkCategory);
        drinkSizeRepository.save(drinkSize);

        return new RedirectView("/drinkDE");
    }

    //header of admin dashboard
    // @GetMapping(path = "/adminDashboard/newCashier")
    // public Object newCashier(){
    //     return new ModelAndView("addCashierNew");
    // }

    // @GetMapping(path = "/new_drink")
    // public Object newDrink(){
    //     return new ModelAndView("newDrink");
    // }

    // @GetMapping(path = "/new_food")
    // public Object newFood(){
    //     return new ModelAndView("newFood");
    // }

    // @GetMapping(path = "/adminDashboard/addDrinkCategory")
    // public Object newCategory(){
    //     return new ModelAndView("addCategory");
    // }

    // @GetMapping(path = "/order_histories")
    // public Object orderHistories(){
    //     return new ModelAndView("orderHistories");
    // }

    // @GetMapping(path = "/manage_table")
    // public Object manageTable(){
    //     return new ModelAndView("manageTable");
    // }


    // Drink selection

    @GetMapping("/drinkSelect")
    public Object drinkSelection(Model model) {
        model.addAttribute("categories", drinkCategoryRepository.findAll());
        return new ModelAndView("CashierPart/drinkSelection");
    }

    @GetMapping("/drinkSelect/{id}")
    public Object showDrinkByCategory(@PathVariable Integer id, Model model) {

        List<Integer> num = new ArrayList<Integer>();

        List<Drink> drinks = repositoryDrink.findAll();
        
        for(Drink drink : drinks) {
            if(id == drink.getCategory_id().getDrink_categoryId()) {
                num.add(drink.getDrink_id());
            }
        }
        model.addAttribute("categories", repositoryDrinkCategory.findAll());
        model.addAttribute("drinks", repositoryDrink.findAllById(num));
        num.clear();
        return new ModelAndView("CashierPart/drinkSelectById");
    }

    //Cashier Dashboard
    @GetMapping("/cashierDashboard")
    public Object cashierDashboard() {
        return new ModelAndView("cashierDashboard");
    }
}
