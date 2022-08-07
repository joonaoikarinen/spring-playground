package com.example.springplayground.hello;

import com.example.springplayground.config.PlaygroundConfigProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("")
public class HelloController {

    PlaygroundConfigProperties playgroundConfigProperties;

    public HelloController(PlaygroundConfigProperties playgroundConfigProperties) {
        this.playgroundConfigProperties = playgroundConfigProperties;
    }

    @GetMapping("/")
    public String getHello() {
        return "Hello Auth0 world!";
    }

    @GetMapping("/user")
    public String getUser(Principal principal) { return "User: " + principal.getName() ; }

    @GetMapping("/login")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        if (principal != null) {
            model.addAttribute("profile", principal.getClaims());
        }
        return "index";
    }
}
