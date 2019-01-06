package com.wsplanning.webapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wsplanning.webapp.utils.ColorPicker;
import com.wsplanning.webapp.utils.colorPickerDTO;;

/**
 * Created by ThuyetLV
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {      
        return "redirect:/mechanic";
    }

   
    @GetMapping("/403")
    public String accessDenied() {
        return "errors/403";
    }
}
