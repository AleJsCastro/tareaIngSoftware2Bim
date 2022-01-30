package com.seaz.proyectospringboot.controller;

import com.seaz.proyectospringboot.entity.Customer;
import com.seaz.proyectospringboot.entity.Membership;
import com.seaz.proyectospringboot.entity.User;
import com.seaz.proyectospringboot.service.CustomerService;
import com.seaz.proyectospringboot.service.MembershipService;
import com.seaz.proyectospringboot.service.SecurityService;
import com.seaz.proyectospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MembershipService membershipService;

    @GetMapping("/registration")
    public String registration(Model model) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        if (error != null)
            model.addAttribute("error", "Su nombre de usuario y contraseña no son válidos.");

        if (logout != null)
            model.addAttribute("message", "Ha sido desconectado con éxito.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        List<Customer> customerList = customerService.getAll();
        model.addAttribute("customers",customerList);
        return "welcome";
    }
    @GetMapping({ "/resgistercustomer"})
    public String resgistercustomer(Model model) {

        model.addAttribute("customer",new Customer());
        return "newcustomer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditCustomer(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("newcustomer");
        Customer customer = customerService.getById(id);
        mav.addObject("customer", customer);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        customerService.delete(id);
        return "redirect:/";
    }
    @GetMapping("/memberships/{id}")
    public String memberships(@PathVariable(name = "id") Long id,Model model) {
        List<Membership> membershipList = membershipService.getMemberships(id);
        Customer customer = customerService.getById(id);
        model.addAttribute("customer",customer);
        model.addAttribute("memberships",membershipList);
        Membership membership = new Membership();
                membership.setCustomer(customer);
        model.addAttribute("membership",membership);
        return "menberships";
    }

    @RequestMapping(value = "/savemembership", method = RequestMethod.POST)
    public String saveMembership(@ModelAttribute("membership")Membership menberships) {
        membershipService.save(menberships);
        return "redirect:/memberships/"+menberships.getCustomer().getId();
    }

}
