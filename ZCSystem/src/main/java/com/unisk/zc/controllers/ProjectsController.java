package com.unisk.zc.controllers;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unisk.zc.core.support.Page;
import com.unisk.zc.entitys.Projects;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.service.ProjectsService;
import com.unisk.zc.service.UniskUserService;
import com.unisk.zc.service.UserAndUserGroupService;

/**
 * 
 * Title: <br>
 * Description: <br>
 * Date: 2016年1月14日 <br>
 * 
 * @author duandingyang
 */
@Controller
@RequestMapping(value = { "/projects/project" })
public class ProjectsController {

	@Autowired
	ProjectsService projectService;
	@Autowired
	UniskUserService userService;
	@Autowired(required = false)
	UserAndUserGroupService ugroupService;
	public static final String path = "sys/modules/project/";
	private static final Logger logger = LoggerFactory.getLogger(ProjectsController.class);

	/*
	 * 日期绑定转化
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
			@Override
			public void setAsText(String text) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					if (text != "")
						setValue(sdf.parse(text));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * 项目列表
	 */
	@RequestMapping(value = { "listView" })
	public String listView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") UniskUser user, @ModelAttribute("projects") Projects projects, ModelMap map)
			throws UniskException {
		projects.setParentid(null);
		Page<Map<String, Object>> page = projectService.selectMapPage(projects);
		map.put("page", page);
		return path + "projects-list";
	}

	/*
	 * 子项目列表
	 */
	@RequestMapping(value = { "subProlistView" })
	public String subProlistView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("project") Projects project,
			ModelMap map) throws UniskException {
		Page<Map<String, Object>> page = projectService.selectMapPage(project);
		map.put("page", page);
		map.put("parentid", project.getParentid());
		return path + "subprojects-list";
	}

	/*
	 * 修改父项目页面
	 */
	@RequestMapping(value = { "formView" })
	public String formView(@ModelAttribute("project") Projects project, HttpServletRequest request, HttpServletResponse response, ModelMap map) throws UniskException {
		if( project.getId() != null ){
			project = projectService.findById(project.getId());
		}
		map.put("project", project);
		return path + "projects-form";
	}

	/*
	 * 修改项目实现
	 */
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("project") Projects project, ModelMap map)
			throws UniskException {
		if (project.getId()==null) {
			projectService.insert(project);
		}else{
			projectService.update(project);
		}
		return "redirect:/projects/project/listView.do";
	}

	/*
	 * 子项目表单
	 */
	@RequestMapping(value = { "subformView" })
	public String formSubView(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("project") Projects project, ModelMap map) throws UniskException {
		// 获取要更新的project对象
		if( project.getId() != null ){
			project = projectService.findById(project.getId());
		}
		map.put("project", project);
		return path + "subprojects-form";
	}

	/*
	 * 修改子项目实现
	 */
	@RequestMapping(value = "modifySub", method = RequestMethod.POST)
	public Object editSub(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("project") Projects project, ModelMap map)
			throws UniskException {
		if (project.getId()==null) {
			projectService.insert(project);
		}else{
			projectService.update(project);
		}
		return "redirect:/projects/project/subProlistView.do?parentid="+project.getParentid();
	}

	/*
	 * 项目查询，子项目查询子项目，父项目查询父项目
	 */
	@RequestMapping(value = { "view" })
	public String view(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("projects") Projects projects, ModelMap map) throws UniskException {
		Page<Map<String, Object>> page = projectService.selectMapPage(projects);
		map.put("page", page);
		// 当前是子项目页面内还是父项目页面
		String uri = request.getParameter("viewpath");
		uri = (uri == null) ? "projects-list" : uri;
		return path + uri;
	}

	/**
	 * 删除项目
	 */
	@ResponseBody
	@RequestMapping(value = { "delete" })
	public String delete(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("projects") Projects projects, int id, ModelMap map) throws UniskException {
		projects.setId(id);
		projects.setDelmark(1);
		int result = projectService.update(projects);
		return result + "";
	}
	/*
	 * 上传子项目文件
	 */
	@RequestMapping(value = { "uploadSubfile" })
	public String uploadSubfile(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response,ModelMap map) throws UniskException {
		String parentid = request.getParameter("upload_parentid");
		Projects project = new Projects();
		project.setParentid(parentid);
		projectService.uploadfile(file, project);
		return "redirect:/projects/project/listView.do";
	}
	/*
	 * 下载模板
	 */
	@RequestMapping(value = { "downloadfile" })  
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {  
        String rootpath = request.getSession().getServletContext().getRealPath(  
                "/"); 
        String downLoadPath = rootpath + "statics\\upload\\doc\\template.xlsx";
        String fileName="template.xlsx";
        projectService.downloadfile(request, response, downLoadPath, fileName);
    }  
}
