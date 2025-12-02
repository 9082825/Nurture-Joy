package com.nurturejoy.NurtureJoy.chat;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private OpenAIChatService openAI;

    @PostMapping("/chat")
    public String chat(String question, HttpSession session, Model model) {

        if (session.getAttribute("chatHistory") == null) {
            session.setAttribute("chatHistory", new ArrayList<ChatMessage>());
        }

        List<ChatMessage> history = (List<ChatMessage>) session.getAttribute("chatHistory");

        // user message
        history.add(new ChatMessage("user", question));

        // ask OpenAI
        String answer = openAI.askOpenAI(question);

        // ai message
        history.add(new ChatMessage("assistant", answer));

        model.addAttribute("chatHistory", history);
        return "home";   // Your dashboard file name
    }
}