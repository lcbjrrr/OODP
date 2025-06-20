package org.acme.oo_103;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class WebController {
    @GetMapping("/")
    public String home() {
        return "index"; // Renders src/main/resources/templates/index.html
    }
    @PostMapping("/greet")
    public String greet(@RequestParam("userName") String userName, Model model) {
        model.addAttribute("name", userName); // Adds data to the model
        return "hello"; // Renders src/main/resources/templates/hello.html
    }
}
