package com.projectassignment.lalita.services;

import com.projectassignment.lalita.exception.ProjectException;
import com.projectassignment.lalita.model.Project;
import com.projectassignment.lalita.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);

    }

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Project updateProject(Project project, Integer projectId) {

        //find the project with the id
        Optional<Project> existingProject = projectRepository.findById(projectId);
        if(existingProject.isEmpty()){
            throw new ProjectException("No project found with the Id : " + projectId);
        }

        existingProject.get().setName(project.getName());
        existingProject.get().setDescription(project.getDescription());
        existingProject.get().setLastDate(project.getLastDate());
        existingProject.get().setStartDate(project.getStartDate());



        return existingProject.get();
    }

    @Override
    public String deleteProject(Integer projectId) {

        //get the project with the provided id
        Optional<Project> existingProject =  projectRepository.findById(projectId);
        if(existingProject.isEmpty()){
            throw new ProjectException("No project found with the Id : " + projectId);
        }

        projectRepository.delete(existingProject.get());
        return "Project deleted successfully";




    }
}
