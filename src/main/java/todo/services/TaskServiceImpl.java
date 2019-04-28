package todo.services;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import todo.dto.TaskDto;
import todo.entities.Project;
import todo.entities.Task;
import todo.repositories.ProjectRepository;
import todo.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Resource
	private TaskHelper helper;
	
	@Resource
	private TaskRepository repository;
	
	@Resource
	private ProjectRepository projectRepository;
	
	@Override
	public TaskDto createTask(TaskDto dto) {
		Optional<Project> project = projectRepository.findById(Integer.valueOf(dto.getProjectId()));
		Task task = helper.toEntity(dto, project.get());
		Task createdTask = repository.save(task);
		return helper.toDto(createdTask);
	}

}
