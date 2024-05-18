package com.projectassignment.lalita.repository;

import com.projectassignment.lalita.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
