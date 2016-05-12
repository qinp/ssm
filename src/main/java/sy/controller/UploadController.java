package sy.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/file")
	public String uploadFile(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException{
		System.out.println("--------"+file.getOriginalFilename());
		if(!file.isEmpty()){
			FileOutputStream fos = new FileOutputStream("d:/" + new Date().getTime() + file.getOriginalFilename());
			InputStream fis = file.getInputStream();
			int b = 0;
			while((b=fis.read())!=-1){
				fos.write(b);
			}
			fos.flush();
			fos.close();
			fis.close();
		}
		return "/success";
	}
	
	@RequestMapping("/file2")
	public String uploadFile2(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException{
		CommonsMultipartResolver commonsResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if(commonsResolver.isMultipart(request)){
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iterator = multiRequest.getFileNames();
			while(iterator.hasNext()){
				MultipartFile file = multiRequest.getFile(iterator.next());
				if(file!=null){
					String fileName = file.getOriginalFilename();
					String path = "d:/"+fileName;
					File filepath = new File(path);
					file.transferTo(filepath);
				}
			}
		}
		return "/success";
	}
	
	@RequestMapping("/toLoad")
	public String toLoad(){
		return "/loadFile";
	}
}
