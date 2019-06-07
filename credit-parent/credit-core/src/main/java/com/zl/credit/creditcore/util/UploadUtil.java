package com.zl.credit.creditcore.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;
public class UploadUtil {

	/**
	 * 处理文件上传
	 * 
	 * @param file
	 * @param basePath
	 *            存放文件的目录的绝对路径 servletContext.getRealPath("/upload")
	 * @return
	 */
	public static String upload(MultipartFile file) {
		String orgFileName = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString() + "."
				+ FilenameUtils.getExtension(orgFileName);// 不包括 .    xxx.jpg  --> jpg
		try {
			/*//上传到当前项目的update文件夹
			File targetFile = new File(basePath, fileName);
			FileUtils.writeByteArrayToFile(targetFile, file.getBytes());
			*/
			//获取公共文件夹地址
			File publicFile = new File("D:\\upload", fileName);
			FileUtils.writeByteArrayToFile(publicFile, file.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}