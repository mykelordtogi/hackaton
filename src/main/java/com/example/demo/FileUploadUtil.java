package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	
	public static void saveFile(String uploadDir, String fileName,MultipartFile multipartFile,String cvName, MultipartFile fileCV)
	throws IOException{
		Path uploadPath = Paths.get(uploadDir);
		
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		
		try(InputStream inputStream = multipartFile.getInputStream())
		{
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
		}
		
		try(InputStream inputStreamCV = fileCV.getInputStream())
		{
			Path filePath = uploadPath.resolve(cvName);
			Files.copy(inputStreamCV,filePath,StandardCopyOption.REPLACE_EXISTING);
		}
		
		catch(IOException ioe)
		{
			throw new IOException("Could not save image file"+fileName,ioe);
		}
	}
	
	
}
