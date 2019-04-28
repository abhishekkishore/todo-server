package todo.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import todo.dto.TaskDto;
import todo.services.TaskService;

@Controller
@ResponseBody
@RequestMapping("/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {
	
	@Resource
	private TaskService service;
	
	@RequestMapping(method=RequestMethod.POST)
	public TaskDto createProject(@RequestBody TaskDto dto) {
		return service.createTask(dto);
	}
}
