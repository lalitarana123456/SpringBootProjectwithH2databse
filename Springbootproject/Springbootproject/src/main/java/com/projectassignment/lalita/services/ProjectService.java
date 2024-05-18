package com.projectassignment.lalita.services;

import com.projectassignment.lalita.model.Project;

import java.util.List;

public interface ProjectService {

    //Save data
    Project saveProject(Project project);

    //Read data
    List<Project> getAllProject();

    //Update data
    Project updateProject(Project project, Integer projectId);

    //Delete data
    String deleteProject(Integer projectId);

}
