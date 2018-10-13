package io.khasang.ba.controller;

import io.khasang.ba.entity.Fox;
import io.khasang.ba.service.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fox")
public class FoxController {
    @Autowired
    private FoxService foxService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Fox addFox(@RequestBody Fox fox) {
        return foxService.addFox(fox);
    }

    @ResponseBody
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public Fox getFoxById(@PathVariable(value = "id") long id) {
        return foxService.getFoxById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/get/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public List<Fox> getAllFoxes() {
        return foxService.getAllFoxes();
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public Fox updateFox(@RequestBody Fox fox) {
        return foxService.updateFox(fox);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public Fox deleteFox(@PathVariable(value = "id") long id) {
        return foxService.deleteFox(id);
    }
}
