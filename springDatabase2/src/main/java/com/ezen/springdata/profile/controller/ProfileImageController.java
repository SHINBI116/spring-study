package com.ezen.springdata.profile.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.springdata.profile.dto.ProfileImageDTO;
import com.ezen.springdata.profile.service.ProfileImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Controller
public class ProfileImageController {
	
	private final ProfileImageService profileImageService;
	
	@GetMapping("/profile/upload")
	public String upload() {
		return "/profile/upload_image";
	}
	
	@PostMapping("/profile/save")
	public String saveFile(ProfileImageDTO profileImageDTO) {
		try {
			profileImageService.save(profileImageDTO);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return "redirect:/profile/upload";
	}
	
	@PostMapping("/profile/savemulti")
	public String saveMulti(ProfileImageDTO profileImageDTO) {
		try {
			profileImageService.multiSave(profileImageDTO);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/profile/upload";
	}
}
