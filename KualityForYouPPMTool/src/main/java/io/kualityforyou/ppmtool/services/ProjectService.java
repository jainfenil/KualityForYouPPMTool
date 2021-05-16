package io.kualityforyou.ppmtool.services;

import io.kualityforyou.ppmtool.domain.Project;
import io.kualityforyou.ppmtool.exceptions.ProjectIdException;
import io.kualityforyou.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e) {
            throw new ProjectIdException("Project Id '" +
                    project.getProjectIdentifier().toUpperCase() + "' already exits");
        }
    }

    public Project findByProjectIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Project Id '" +
                    projectIdentifier.toUpperCase() + "' does not exits");
        }
        return project;
    }

    public Iterable<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    public void deleteProjectByProjectIdentifier(String projectIdentifier) {
        Project project = projectRepository.findByProjectIdentifier(projectIdentifier.toUpperCase());
        if (project == null) {
            throw new ProjectIdException("Cannot delete Project with Id '" +
                    projectIdentifier.toUpperCase() + "', This Project does not exits");
        }
        projectRepository.delete(project);
    }
}
