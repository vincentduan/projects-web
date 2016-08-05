package com.unisk.zc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unisk.zc.entitys.Vote;
import com.unisk.zc.entitys.VoteTopic;

@Controller
@RequestMapping(value={"/votes/vote"})
public class VoteController {

	@RequestMapping(value={"/listView"})
	public String listView(@ModelAttribute("vote")Vote vote, HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return "sys/modules/vote/vote-list";
	}
	
	@RequestMapping(value={"formView"})
	public String formView(@ModelAttribute("vote")Vote vote, HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return "sys/modules/vote/vote-form";
	}
	
	@RequestMapping(value={"modifyVote"})
	public String modifyVote(@ModelAttribute("vote")Vote vote, HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return topicListView(new VoteTopic(),request,response,new ModelMap());
	}
	
	@RequestMapping(value={"topicListView"})
	public String topicListView(VoteTopic voteTopic, HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return "sys/modules/votetopic/votetopic-list";
	}
	
	@RequestMapping(value={"topicFormView"})
	public String topicFormView(@ModelAttribute("voteTopic")VoteTopic voteTopic, HttpServletRequest request, HttpServletResponse response, ModelMap map){
		return "sys/modules/votetopic/votetopic-form";
	}
	
}
