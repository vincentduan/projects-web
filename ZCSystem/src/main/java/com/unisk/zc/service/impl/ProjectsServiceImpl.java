package com.unisk.zc.service.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unisk.zc.core.support.MyBatisBaseDao;
import com.unisk.zc.core.support.Page;
import com.unisk.zc.core.utils.DictUtils;
import com.unisk.zc.core.utils.UserUtils;
import com.unisk.zc.entitys.Projects;
import com.unisk.zc.entitys.UniskUser;
import com.unisk.zc.exceptions.UniskException;
import com.unisk.zc.mapper.ProjectsMapper;
import com.unisk.zc.service.ProjectsService;
import com.unisk.zc.utils.CommonTool;
import com.unisk.zc.utils.springs.UniskPropertyPlaceHolder;

@Service
public class ProjectsServiceImpl extends BaseServiceImpl<Projects> implements ProjectsService {

	@Autowired
	MyBatisBaseDao baseDao;
	@Autowired
	ProjectsMapper projectsMapper;
	@Override
	public Projects findById(Integer id) throws UniskException {
		if( id == null ) return null;
		Projects project = null;
		try {
			project = baseDao.selectOne("com.unisk.zc.mapper.ProjectsMapper.selectByPrimaryKey", id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return project;
	}

	@Override
	public Page<Map<String, Object>> selectMapPage(Projects projects)
			throws UniskException {
		
		UniskUser users = UserUtils.getUser();
		if( users != null && users.getId() != null ) projects.setCreateuserid(users.getId());
		Page<Map<String, Object>> page = null;
		try {
			page = baseDao.selectListMapPage("com.unisk.zc.mapper.ProjectsMapper.selectListMapPage", projects);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return page;
	}

	@Override
	public int insert(Projects project) throws UniskException {
		int ret = 0;
		try {
			UniskUser users = UserUtils.getUser();
			if( users != null && users.getId() != null ) project.setCreateuserid(users.getId());
			project.setDelmark(0);
			project.setModifytime(new Date());
			ret = baseDao.insert("com.unisk.zc.mapper.ProjectsMapper.insert", project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public int update(Projects project) throws UniskException {
		int ret = 0;
		try {
			UniskUser users = UserUtils.getUser();
			if( users != null && users.getId() != null ) project.setModifyuserid(users.getId());
			
			Projects projectTemp = findById(project.getId());
			if(StringUtils.isNotEmpty(project.getProjectlogo())){
				if( !StringUtils.equalsIgnoreCase(projectTemp.getProjectlogo() , project.getProjectlogo()) ){
					if(StringUtils.isNotEmpty(projectTemp.getProjectlogo())){
						CommonTool.deletePicture(UniskPropertyPlaceHolder.getProperty("productFileSavePath", ""), 
								projectTemp.getProjectlogo());
					}
					CommonTool.fileMkdir(UniskPropertyPlaceHolder.getProperty("productFileSavePath", ""));
					project.setProjectlogo( CommonTool.createPicture(
								UniskPropertyPlaceHolder.getProperty("productFileSavePath", ""), 
								UniskPropertyPlaceHolder.getProperty("productFileVisitPath", ""),
								project.getProjectlogo()) );
				}
			}
			if(StringUtils.isNotEmpty(project.getCoverimage())){
				if( !StringUtils.equalsIgnoreCase(projectTemp.getCoverimage() , project.getCoverimage()) ){
					if(StringUtils.isNotEmpty(projectTemp.getCoverimage())){
						CommonTool.deletePicture(
								UniskPropertyPlaceHolder.getProperty("productFileSavePath", ""), 
								projectTemp.getCoverimage());
					}
					CommonTool.fileMkdir(UniskPropertyPlaceHolder.getProperty("productFileSavePath", ""));
					project.setCoverimage( CommonTool.createPicture(
							UniskPropertyPlaceHolder.getProperty("productFileSavePath", ""), 
							UniskPropertyPlaceHolder.getProperty("productFileVisitPath", ""),
							project.getCoverimage()) );
				}
			}
			//project.setDelmark(0);
			project.setModifytime(new Date());
			ret = baseDao.update("com.unisk.zc.mapper.ProjectsMapper.updateByPrimaryKeySelective", project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return ret;
	}

	@Override
	public List<Map<String, Object>> selectbyCondition(Projects project) throws UniskException {
		List<Map<String, Object>> projects=null;
		try {
			projects = baseDao.selectList("com.unisk.zc.mapper.ProjectsMapper.selectListMapPage", project);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UniskException(e);
		}
		return projects;
	}
	/*
	 * (non-Javadoc)上传子项目文件
	 * @see com.unisk.zc.service.ProjectsService#uploadfile(org.springframework.web.multipart.commons.CommonsMultipartFile, com.unisk.zc.entitys.Projects)
	 */
	@Override
	public Boolean uploadfile(CommonsMultipartFile file, Projects project)
			throws UniskException {
		if(!file.isEmpty()){
			try {
				FileInputStream in = (FileInputStream) file.getInputStream();
				XSSFWorkbook wb = new XSSFWorkbook(in);
				XSSFSheet sheet = wb.getSheetAt(0);
				for(int i = 1;i <=sheet.getLastRowNum();i++){
					XSSFRow	row = sheet.getRow(i);
					String provid=row.getCell(0).toString();
					project.setProjectname(row.getCell(1).toString());
					project.setProjectbrief(row.getCell(2).toString());
					if (StringUtils.isEmpty(provid)) {
						provid="0";
					}
					project.setProvid(DictUtils.getDictionaryByKindsAndUKey("COMMON-REGION", row.getCell(0).toString()).getUvalue());
					insert(project);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		return true;
	}

	@Override
	public Boolean downloadfile(HttpServletRequest request, HttpServletResponse response ,String path, String name) throws UniskException {
		//e.g:path:E:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp2\\wtpwebapps\\ZCSystem\\statics\\upload\\doc\\template.xlsx
		BufferedInputStream in = null;
        BufferedOutputStream out = null;
		String downLoadPath = path;
        String fileName=name;
		try {
        	File file = new File(downLoadPath);
        	response.setContentType("application/x-excel");  
            response.setCharacterEncoding("UTF-8");  
            response.setHeader("Content-Disposition", "attachment; filename="+fileName);  
            response.setHeader("Content-Length",String.valueOf(file.length()));  
            in = new BufferedInputStream(new FileInputStream(file));  
            out = new BufferedOutputStream(response.getOutputStream());
            byte[] data = new byte[1024];  
            int len = 0;  
            while (-1 != (len=in.read(data, 0, data.length))) {  
                out.write(data, 0, len);  
            }  
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (in != null) {  
                try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            }
            if (out != null) {  
                try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
            }  
		}
		return null;
	}

}
