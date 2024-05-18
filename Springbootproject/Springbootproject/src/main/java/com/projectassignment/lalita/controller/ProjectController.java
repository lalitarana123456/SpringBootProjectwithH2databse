package com.projectassignment.lalita.controller;


import com.projectassignment.lalita.model.Project;
import com.projectassignment.lalita.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {


    @Autowired
    private ProjectService projectService;

    //TESTING PURPOSE
    @GetMapping("/welcome")
    public String welcomeTest(){
        return "Welcome to spring project";
    }

    @PostMapping("/projects")
    public ResponseEntity<Project> saveProjectHandler(@RequestBody Project project){
        return new ResponseEntity<>(projectService.saveProject(project), HttpStatus.CREATED);
    }


    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getAllProjectsHandler(){

        return new ResponseEntity<>(projectService.getAllProject(), HttpStatus.OK);

    }

    @PutMapping("/projects/{id}")
    public ResponseEntity<Project> updateProjectHandler(@RequestBody Project project, @PathVariable("id") Integer projectId){
        return new ResponseEntity<>(projectService.updateProject(project, projectId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> deleteProjectHandler(@PathVariable("id") Integer projectId){
        return new ResponseEntity<>(projectService.deleteProject(projectId), HttpStatus.OK);

    }

}
