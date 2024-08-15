package com.ezen.springdata.profile.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.springdata.profile.dto.ProfileImageDTO;
import com.ezen.springdata.profile.repository.ProfileRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProfileImageService {

	private final ProfileRepository profileRepository;

	private String rootPath = "C:/spring_upload_files/";

	public void save(ProfileImageDTO profileImageDTO) throws IllegalStateException, IOException {
		MultipartFile profileImageFile = profileImageDTO.getProfileImageFile();
		saveFile(profileImageFile);

	}

	public void multiSave(ProfileImageDTO profileImageDTO) throws IllegalStateException, IOException {
		List<MultipartFile> profileImageFiles = profileImageDTO.getProfileImageFiles();

		for (MultipartFile profileImageFile : profileImageFiles) {
			saveFile(profileImageFile);
		}
	}

	private void saveFile(MultipartFile profileImageFile) throws IllegalStateException, IOException {
		String originalFilename = profileImageFile.getOriginalFilename();
		String storedFilename = String.format("%s-%s", System.currentTimeMillis(), originalFilename);
		String savePath = rootPath + storedFilename;

		profileImageFile.transferTo(new File(savePath));

		ProfileImageDTO profileImageDTO = new ProfileImageDTO();

		// 2. 서버 컴퓨터에 파일 쓰기를 성공했다면 DB에 경로들을 보관
		profileImageDTO.setOriginalFilename(originalFilename);
		profileImageDTO.setStoredFilename(storedFilename);

		profileRepository.saveProfileImage(profileImageDTO);
	}

}
