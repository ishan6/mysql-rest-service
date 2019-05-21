package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
/**
 * Created by Chathura 4/8/2019, Edited by Ishan CT/2015/036 from 20/04/2019 .
 */
@RestController
@RequestMapping(path="/demo")
public class MainController {

    private static final String SUCCESS= "Saved";

    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;


    /*
    * READ Operation
    * This method will list all the pizzas in the table
    * URI to access this: http://localhost:8080/demo/all
    */
    @GetMapping(path="/all")
    public @ResponseBody Iterable<PizzaDetails> getPizzaDetails() {
        return pizzaRepository.findAll();
    }




    /*
     * READ Operation
     * This method will list all the Orders in the table
     * URI to access this: http://localhost:8080/demo/allorders
     */
    @GetMapping(path="/allorders")
    public @ResponseBody Iterable<Cart> getCart() {
        return cartRepository.findAll();
    }




    /*
     * READ Operation
     * This method will list all the Users in the table
     * URI to access this: http://localhost:8080/demo/showusers
     */
    @GetMapping(path="/showusers")
    public @ResponseBody Iterable<Users> getUsers() {
        return userRepository.findAll();
    }



    /*
    * READ Operation based on Pizza ID
    * This method will return the details of a pizza specified by the id
    * URI to access this: http://localhost:8080/demo/findByPizzaId?id=2
    */
    @RequestMapping(path="/findByPizzaId")
    public @ResponseBody List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }



    /*
     * READ Operation based on Telephone and Password
     * This method will return the details of a Users specified by the Telephone and Password
     * URI to access this: http://localhost:8080/demo/findByTelephoneAndPassword?telephone=0754576062&password=123
     * I used AES Encryption Method to save password unfortunately it  does not work for this method
     */
    @RequestMapping(path="/findByTelephoneAndPassword")
    public @ResponseBody List<Users> findByTelephoneAndPassword(@RequestParam String telephone, @RequestParam String password) {
        return userRepository.findByTelephoneAndPassword(telephone, password);
    }



    /*
     * READ Operation based on Telephone
     * This method will return the details of a Users specified by the Telephone
     * URI to access this: http://localhost:8080/demo/findByTelephone?telephone=0754576062
     */
    @RequestMapping(path="/findByTelephone")
    public @ResponseBody List<Users> findByTelephone(@RequestParam String telephone) {
        return userRepository.findByTelephone(telephone);
    }


    /*
     * READ Operation based on Nic and Email and Telephone
     * This method will return the details of a Users specified by the Nic and Email and Email
     * URI to access this: http://localhost:8080/demo/findByNicandEmail?nic=9609789v&email=ishanmenaka6@gmail.com&telephone=0754576062
     */
    @RequestMapping(path="/findByNicOrEmailOrTelephone")
    public @ResponseBody List<Users> findByNicandEmail(@RequestParam String nic, @RequestParam String email, @RequestParam String telephone) {
        return userRepository.findByNicOrEmailOrTelephone(nic, email, telephone);
    }



    /*
     * READ Operation based on CartId
     * This method will return the details of a Cart specified by the CartId
     * URI to access this: http://localhost:8080/demo/findByCartId?100
     */
    @RequestMapping(path="/findByCartId")
    public @ResponseBody List<Cart> getCartById(@RequestParam Integer user_id) {
        return cartRepository.findByUserid(user_id);
    }



    /*
     * READ Operation based on Cartstatus and User Id
     * This method will return the details of a Cart specified by the Cartstatus and User Id
     * URI to access this: http://localhost:8080/demo/findByCartId?100&user_id=1&cartstatus=0
     */
    @RequestMapping(path="/findByCartIdAndUserId")
    public @ResponseBody List<Cart> getCartById1(@RequestParam Integer user_id, @RequestParam Integer cartstatus) {
        return cartRepository.findByUseridAndCartstatus(user_id, cartstatus);
    }



    /*
     * CREATE Operation
     * This method will crate new Users  in the database table of Users
     * and returns the Saved message
     * URI to access this: http://localhost:8080/demo/register
     */
    @RequestMapping("/register")
    public String addUsers(@RequestBody Users users){
        userRepository.save(users);
        return "Saved!";
    }



    /*
     * CREATE Operation
     * This method will crate new Cart item in the database table of order
     * and returns the Saved message
     * URI to access this: http://localhost:8080/demo/add_to_cart
     */
    @RequestMapping("/add_to_cart")
    public String cart(@RequestBody Cart cart){
        cartRepository.save(cart);
        return "Saved!";
    }


    /*
    * CREATE Operation
    * This method will crate new pizza item in the database table
    * and returns the SUCCESS message
    * URI to access this: http://localhost:8080/demo/add?name=VegiPizza&description=VegiSupreme&price=2500.75
    */
    @GetMapping(path="/add")
    public @ResponseBody String addNewPizza(@RequestParam String name, @RequestParam Double price, @RequestParam  Double medium_price, @RequestParam Double large_price, @RequestParam String description, @RequestParam String image_url ) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaDetails.setLiarge_price(large_price);
        pizzaDetails.setMedium_price(medium_price);
        pizzaDetails.setImageUrl(image_url);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;
    }


    /*
    * DELETE Operation
    * This method will delete existing pizza item by finding it using the ID
    * and returns the deleted item
    * URI to access this: http://localhost:8080/demo/deleteByPizzaId?id=2
    */
    @GetMapping(path="/deleteByPizzaId")
    public @ResponseBody List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }


    /*
     * DELETE Operation
     * This method will delete existing Cart item by finding it using the ID
     * and returns the deleted item
     * URI to access this: http://localhost:8080/demo/deleteByCartId?id=2
     */
    @GetMapping(path="/deleteByCartId")
    public @ResponseBody List<Cart> deleteAllById(@RequestParam Integer id) {
        return cartRepository.deleteAllById(id);
    }



    /*
    * UPDATE Operation
    * This method will update existing pizza details by finding it using the ID
    * and returns the updated data
    * URI to access this: http://localhost:8080/demo/update?id=1&name=updatedname&description=updated&price=1234.56
    */
    @GetMapping(path="/update")
    public @ResponseBody List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        //First get all the pizza details according to the provided ID
        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if(!pizzaDetailsList.isEmpty()) {
            //Iterate through the pizza list
            for(PizzaDetails pizzaDetails: pizzaDetailsList) {
                //Set new values
                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);
                //Update existing pizza item
                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }



    /*
     * UPDATE Operation
     * This method will update existing Cart details by finding it using the ID
     * and returns the updated data
     * URI to access this: http://localhost:8080/demo/updateCart?id=1&size=UpdatedSize&item=UpdatedItemcount&total=2000.00
     */
    @GetMapping(path="/updateCart")
    public @ResponseBody List<Cart> updateCartDetails(@RequestParam Integer id, @RequestParam String size, @RequestParam int item, @RequestParam Double total, @RequestParam String telephone , @RequestParam String address) {
        //First get all the Cart details according to the provided ID
        List<Cart> cartDetailsList = cartRepository.findByid(id);
        if(!cartDetailsList.isEmpty()) {
            //Iterate through the Cart list
            for(Cart cart: cartDetailsList) {
                //Set new values
                cart.setSize(size);
                cart.setItem(item);
                cart.setTotal(total);
                cart.setTelephone(telephone);
                cart.setAddress(address);
                //Update existing Cart item
                cartRepository.save(cart);
            }
        }
        return cartRepository.findByid(id);
    }

    @GetMapping(path="/updateCart1")
    public @ResponseBody List<Cart> updateCartDetails1(@RequestParam Integer id, @RequestParam String telephone , @RequestParam String address, @RequestParam int cart_status, @RequestParam String paymentMethod) {
        //First get all the Cart details according to the provided ID
        List<Cart> cartDetailsList1 = cartRepository.findByid(id);
        if(!cartDetailsList1.isEmpty()) {
            //Iterate through the Cart list
            for(Cart cart: cartDetailsList1) {

                //Set new values
                cart.setTelephone(telephone);
                cart.setAddress(address);
                cart.setCart_status(cart_status);
                cart.setPaymentMethod(paymentMethod);

                //Update existing Cart item
                cartRepository.save(cart);
            }
        }
        return cartRepository.findByid(id);
    }
}
