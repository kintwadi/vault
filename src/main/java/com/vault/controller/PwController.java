package com.vault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.vault.model.Record;
import com.vault.service.PwService;

@Controller
public class PwController {

	@Autowired
	PwService service;

	@GetMapping("/")
	public String home(@ModelAttribute Record record, Model model)
	{
		List<Record> records = service.retrieveAll();
		model.addAttribute("records", records);
		return "home";

	}
	@GetMapping("/add")
	public String add(@ModelAttribute Record record,Model model)
	{
		List<Record> records = service.retrieveAll();
		model.addAttribute("records", records);

		return "home";

	}
	@PostMapping("/add")
	public String save(@ModelAttribute Record record, 
			Model model)
	{
		if(record != null && 
				!record.getTitle().isBlank() && 
				!record.getPassword().isBlank()) 
		{
			service.store(record);
		}
		List<Record> records = service.retrieveAll();
		model.addAttribute("records", records);
		return "home";
	}
	
	
	@GetMapping("/add_csv")
	public String saveCSV(@ModelAttribute Record record, Model model)
	{
		List<Record> records = service.retrieveAll();
		model.addAttribute("records", records);
		return "home";
	}

	@PostMapping("/add_csv")
	public String saveCSV(@ModelAttribute Record record, 
										  Model model,
										  @RequestParam(value = "csv_file") MultipartFile file)
	{
		
		service.fromCSV(file);
		List<Record> records = service.retrieveAll();
		model.addAttribute("records", records);
		return "home";
	}
	
}
