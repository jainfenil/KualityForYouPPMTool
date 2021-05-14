package io.kualityforyou.ppmtool.services;

import io.kualityforyou.ppmtool.domain.Project;
import io.kualityforyou.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project saveOrUpdateProject(Project project) {
        // Logic to update the Project
        return projectRepository.save(project);
    }
}
