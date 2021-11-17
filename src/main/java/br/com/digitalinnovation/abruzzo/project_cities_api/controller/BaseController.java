package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class BaseController {

    @GetMapping("/")
    public RedirectView redirectWithUsingRedirectView() {
        return new RedirectView("/cities");
    }
}
