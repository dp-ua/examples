package com.examples.sweater.controller;

import com.examples.sweater.model.Message;
import com.examples.sweater.model.User;
import com.examples.sweater.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/")
    public String greeting(
            Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
            Model model) {
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty())
            messages = messageRepo.findByTag(filter);
        else {
            messages = messageRepo.findAll();
            model.addAttribute("error", "Указан пустой тег. Отображаю все сообщения ");
        }

        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Model model) {
        String addText = text.trim();
        if (addText.length() > 0) {
            Message message = new Message(addText, tag.trim(), user);
            messageRepo.save(message);
        } else {
            model.addAttribute("error", "Ошибка добавления, пустое сообщение");
        }
        Iterable<Message> messages = messageRepo.findAll();
        model.addAttribute("messages", messages);
        return "main";
    }

}

