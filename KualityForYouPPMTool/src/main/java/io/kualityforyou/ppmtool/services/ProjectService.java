package io.kualityforyou.ppmtool.services;

import io.kualityforyou.ppmtool.domain.Project;
import io.kualityforyou.ppmtool.exceptions.ProjectIdException;
import io.kualityforyou.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
