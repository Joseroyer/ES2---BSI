package es2.projeto.librarytree.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomErrorController implements ErrorController {


  @RequestMapping("/error")
  @ResponseBody
  void error(HttpServletRequest request) {
  }

}