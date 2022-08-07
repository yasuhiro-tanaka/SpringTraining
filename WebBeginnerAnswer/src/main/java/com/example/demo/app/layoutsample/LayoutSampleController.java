package com.example.demo.app.layoutsample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layoutsample")
public class LayoutSampleController {

	@GetMapping("/fixedfooter")
	public String fixedfooter(@ModelAttribute SimpleForm simpleForm, Model model) {
		model.addAttribute("title", "Fixed Footer");
		return "layoutsample/fixedfooter";
	}
	
	@GetMapping("/accordion")
	public String accordion(@ModelAttribute SimpleForm simpleForm, Model model) {
		model.addAttribute("title", "Accordion");
		return "layoutsample/accordion";
	}
	
	@GetMapping("/gridsystem")
	public String gridsystem(@ModelAttribute SimpleForm simpleForm, Model model) {
		model.addAttribute("title", "GridSystem");
		return "layoutsample/gridsystem";
	}
	
	@GetMapping("/sidebars")
	public String sidebars(@ModelAttribute SimpleForm simpleForm, Model model) {
		model.addAttribute("title", "SideBars");
		return "layoutsample/sidebars";
	}

}
