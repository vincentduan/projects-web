package com.unisk.zc.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.Department;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.DepartmentService;

@Controller
@RequestMapping(value={"/ucenter/dept"})
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value={"listView"})
	public String listView(@ModelAttribute("dept") Department dept,HttpServletRequest request, HttpServletResponse response, ModelMap map) 
			throws UniskException{
		
		Page<Map<String, Object>> page = departmentService.selectMapPage(dept);
		map.put("page", page);
		
		return "sys/modules/department/department-list";
	}
	
	@RequestMapping(value={"formView"})
	public String formView(@ModelAttribute("dept") Department dept,HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException{
		if( dept != null && dept.getId() != null  ){
			dept = departmentService.findById(dept.getId());
			map.put("dept", dept);
		}
		return "sys/modules/department/department-form";
	}
	
	@RequestMapping(value={"editView"})
	public String editView(Department dept,HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException{
		dept = departmentService.findById(dept.getId());
		map.put("dept", dept);
		return "sys/modules/department/department-form";
	}
	
	@RequestMapping(value={"modify"})
	public String modify(@ModelAttribute("dept")Department dept,HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException{
		if(dept.getId() != null ){
			departmentService.update(dept);
		}else{
			departmentService.insert(dept);
		}
		return listView(new Department(),request,response,new ModelMap());
	}
}
