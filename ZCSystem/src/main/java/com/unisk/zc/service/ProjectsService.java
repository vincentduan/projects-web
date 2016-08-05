package com.unisk.zc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unisk.zc.entitys.Projects;
import com.unisk.zc.exceptions.UniskException;

public interface ProjectsService extends BaseService<Projects> {

	public List<Map<String, Object>> selectbyCondition(Projects project) throws UniskException; 
	
	public Boolean uploadfile(CommonsMultipartFile file,Projects project) throws UniskException;
	
	public Boolean downloadfile(HttpServletRequest request, HttpServletResponse response, String path,String name) throws UniskException;
	
}
