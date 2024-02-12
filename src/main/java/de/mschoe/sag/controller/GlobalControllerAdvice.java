package de.mschoe.sag.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Year;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute("currentYear")
    public Integer currentYear() {
        return Year.now().getValue();
    }
}
