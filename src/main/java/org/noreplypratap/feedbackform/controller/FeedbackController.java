package org.noreplypratap.feedbackform.controller;

import org.noreplypratap.feedbackform.model.ViewData;
import org.noreplypratap.feedbackform.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class FeedbackController {

    @Autowired
    FeedbackService service;

    @GetMapping("/home")
    public String home(Model model) {
        List<ViewData> list = service.readAllData();
        model.addAttribute("list",list);
        return "home";
    }

    @GetMapping("/form")
    public String getFeedbackForm(ModelMap model) {
        model.addAttribute("headingText","Feedback Form");
        return "form";
    }

    @GetMapping("/update/{id}")
    public String updateFeedbackForm(@PathVariable int id,Model model) {
        model.addAttribute("data",service.readDataById(id));
        model.addAttribute("headingText","Update Feedback Form");
        return "update";
    }

    @PostMapping("/addFeedback")
    public String addFeedback(@ModelAttribute ViewData viewData, RedirectAttributes attributes) {
        if (service.saveFeedbackData(viewData)){
            attributes.addFlashAttribute("dataStatus","Your data has been saved successfully.");
        } else {
            attributes.addFlashAttribute("dataStatus","Failed");
        }

        return "redirect:/home";
    }

    @PostMapping("/update")
    public String updateFeedback(@ModelAttribute ViewData viewData, RedirectAttributes attributes) {
        System.out.println(viewData);
        if (service.updateFeedbackData(viewData)){
            attributes.addFlashAttribute("dataStatus","Your data has been updated successfully.");
        } else {
            attributes.addFlashAttribute("dataStatus","Failed");
        }

        return "redirect:/home";
    }


    @GetMapping("/download/{fileName}")
    public ResponseEntity<InputStreamResource> downloadFile(@PathVariable String fileName) {
        return service.downloadFile(fileName);
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id,RedirectAttributes attributes) {
        if (service.deleteById(id))
            attributes.addFlashAttribute("dataStatus","Your data has been deleted successfully.");
        else
            attributes.addFlashAttribute("dataStatus","Failed");
        return "redirect:/home";
    }

}
