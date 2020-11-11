package com.sripiranavan.springboot.test.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sripiranavan.springboot.test.dao.DetailsRepository;
import com.sripiranavan.springboot.test.dto.UserDetailWithFile;
import com.sripiranavan.springboot.test.entity.Details;
import com.sripiranavan.springboot.test.service.StorageService;

@Controller
public class UserDetailController {

	private final StorageService storageService;
	private final DetailsRepository detailsRepository;

	@Autowired
	public UserDetailController(StorageService storageService, DetailsRepository detailsRepository) {
		this.storageService = storageService;
		this.detailsRepository = detailsRepository;
	}

	@GetMapping("/register")
	public ModelAndView registerPage() {
		UserDetailWithFile details = new UserDetailWithFile();
		return new ModelAndView("register").addObject("detail", details);
	}

	@PostMapping("/register")
	public ModelAndView saveDetail(@ModelAttribute("detail") UserDetailWithFile details) throws Exception {
		try {
			Long time = new Date().getTime();
			String fileName = details.getImage().getOriginalFilename();
			String newFileName = time + fileName.substring(fileName.lastIndexOf("."));
			storageService.store(details.getImage(), newFileName);
			Details saveDetails = new Details();
			saveDetails.setImage(newFileName);
			saveDetails.setName(details.getName());
			detailsRepository.save(saveDetails);
			ModelAndView homeModel = new ModelAndView("redirect:/home");
			List<?> userDetail = detailsRepository.findAll();
			homeModel.addObject("details", userDetail);
			return homeModel;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@GetMapping("/home")
	public ModelAndView showHomePage() {
		ModelAndView homeModel = new ModelAndView("home");
		List<Details> userDetails = detailsRepository.findAll();
		homeModel.addObject("details", userDetails);
		return homeModel;
	}

}
