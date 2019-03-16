package com.epam.coursemvc.controllers;

import beans.models.User;
import beans.models.UserAccount;
import beans.services.UserAccountService;
import beans.services.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.security.Principal;

@Controller
@RequestMapping("/account")
public class UserAccountController {

    private Logger LOG = Logger.getLogger(UserAccountController.class);
    @Autowired
    private UserService userServiceImpl;

    @Autowired
    UserAccountService userAccountService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView openAccountPage(Principal principal) {

        ModelAndView mv = new ModelAndView("account");
        LOG.info("USERNAME: " + principal.getName());
        User user = userServiceImpl.getUserByEmail(principal.getName());
        UserAccount userAccount = userAccountService.getById(user.getId());
        if(userAccount==null){
            userAccountService.createUserAccount(new UserAccount(user.getId(), BigDecimal.valueOf(0)));
            userAccount = userAccountService.getById(user.getId());
        }
        mv.addObject("user", principal.getName());
        LOG.info(userAccount);
        mv.addObject("money", userAccount.getMoney());
        return mv;
    }


    @RequestMapping(path = "/replenish", method = RequestMethod.POST)
    public String replenishAccount(Principal principal,
                                   @RequestParam("amount") String amount){

        User user = userServiceImpl.getUserByEmail(principal.getName());
        UserAccount userAccount = userAccountService.getById(user.getId());

        if (userAccount==null) {
            userAccountService.createUserAccount(new UserAccount(user.getId(), BigDecimal.valueOf(Long.valueOf(amount))));
        } else {

            BigDecimal newAmount =  userAccount.getMoney().add(BigDecimal.valueOf(Long.valueOf(amount)));
            userAccount.setMoney(newAmount);
            userAccountService.updateUserAccount(userAccount);
        }

        return "redirect:/account";
    }

}
