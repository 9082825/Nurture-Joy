package com.nurturejoy.NurtureJoy;

import com.nurturejoy.NurtureJoy.chat.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class HomeController {

    private final ChatService chatService;

    public HomeController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "home";                // << this name MUST match home.html
    }

    @GetMapping("/")
    public String root(Principal principal) {
        if (principal != null) {
            return "redirect:/home";
        }
        return "redirect:/login";
    }
    @GetMapping("/appointment")
    public String appointment() {
        return "appointment"; // this loads appointment.html
    }

    /*@PostMapping("/chat")
    public String handleChat(@RequestParam("question") String question,
                             Model model,
                             Principal principal) {

        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }

        String answer = chatService.replyTo(question);

        model.addAttribute("chatQuestion", question);
        model.addAttribute("chatAnswer", answer);

        return "home";
    }*/
}
