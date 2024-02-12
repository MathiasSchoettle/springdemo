package de.mschoe.sag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Controller
public class OtherController {

    @GetMapping("other")
    public String other() {
        return "other";
    }

    @GetMapping("other/content")
    public String content(Model model) {
        String time = LocalTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        model.addAttribute("message", "Updated at " + time);
        return "content";
    }
}
