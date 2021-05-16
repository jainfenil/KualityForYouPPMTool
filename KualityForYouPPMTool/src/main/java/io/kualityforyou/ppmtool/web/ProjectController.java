package io.kualityforyou.ppmtool.web;

import io.kualityforyou.ppmtool.domain.Project;
import io.kualityforyou.ppmtool.services.ProjectService;
import io.kualityforyou.ppmtool.services.ValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ValidationErrorService validationErrorService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,
                                                    BindingResult result) {

        //Validating inputs
        ResponseEntity<?> errorMap = validationErrorService.mapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }

        Project createdProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(createdProject, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectByProjectIdentifier(@PathVariable String projectId) {
        Project project = projectService.findByProjectIdentifier(projectId);

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }

    @GetMapping("/all")
    public Iterable<Project> getProjects() {
        return projectService.findAllProjects();
     }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProjectByProjectIdentifier(@PathVariable String projectId) {
        projectService.deleteProjectByProjectIdentifier(projectId);
        return new ResponseEntity<String>("Project with ID: '" + projectId + "' was deleted",
                HttpStatus.OK);
    }
}
