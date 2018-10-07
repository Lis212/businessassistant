package io.khasang.ba.controller;

import io.khasang.ba.Message;
import io.khasang.ba.config.service.BasicOperationDB;
import io.khasang.ba.config.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {
    @Autowired
    private Message message;

    @Autowired
    private BasicOperationDB basicOperationDB;

    @Autowired
    @Qualifier("main")
    private MyService myService;

    @RequestMapping("/")
    public String getHelloPage(Model model) {
        model.addAttribute("name", myService.getName());
        return "home";
    }

    @RequestMapping("/name/{name}")
    public String getName(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/basic-op/create")
    public String createTable(Model model) {
        model.addAttribute("status", basicOperationDB.getTableCreationStatus());
        return "create";
    }

    @RequestMapping("/basic-op/select")
    public String selectTable(Model model) {
        model.addAttribute("status", basicOperationDB.getTableSelectStatus());
        return "select";
    }

    @RequestMapping("/basic-op/insert")
    public String insertTable(Model model) {
        model.addAttribute("status", basicOperationDB.getTableInsertStatus());
        return "insert";
    }

    @RequestMapping(value = "/password/{password}", method = RequestMethod.GET)
    public String getCryptPassword(@PathVariable("password") String password, Model model) {
        model.addAttribute("password", password);
        model.addAttribute("encodePassword", new BCryptPasswordEncoder().encode(password));
        return "password";
    }
}
