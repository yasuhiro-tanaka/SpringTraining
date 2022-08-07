package com.example.demo.app.master;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.app.inquiry.InquiryForm;
import com.example.demo.entity.Fruit;
import com.example.demo.service.master.FruitService;

@Controller
@RequestMapping("/master/fruit")
public class FruitController {

	@Autowired
	private FruitService fruitService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("title", "Fruit Index");

		List<Fruit> fruitList = fruitService.getAll();
		model.addAttribute("fruitList", fruitList);

		return "master/fruit";
	}

	@PostMapping("/update")
	public String update(@Validated InquiryForm inquiryForm, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("title", "Fruit Form");
			return "fruit/index_boot";
		}
		// 演習1-2-4 titleに「更新フォーム」を設定する
		model.addAttribute("title", "更新フォーム");
		// 演習1-2-5 フォーム画面へ遷移させる
		return "inquiry/form_boot";
	}

}
