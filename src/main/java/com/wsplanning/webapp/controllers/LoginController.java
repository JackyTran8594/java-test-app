package com.wsplanning.webapp.controllers;

import com.wsplanning.webapp.clients.MechanicClient;
import com.wsplanning.webapp.clients.SiteClient;
import com.wsplanning.webapp.utils.ColorPicker;
import com.wsplanning.webapp.utils.colorPickerDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    protected SiteClient siteClient;

    @Autowired
    private ColorPicker colorpicker;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        String listSite = siteClient.getSites();
        // String referrer = request.getHeader("Referer");
        // request.getSession().setAttribute("url_prior_login", referrer);

        return "login";
    }


}
