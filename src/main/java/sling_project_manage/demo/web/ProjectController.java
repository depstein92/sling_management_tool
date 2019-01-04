package sling_project_manage.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult; //determines whether or not there are errors
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sling_project_manage.demo.domain.Project;
import sling_project_manage.demo.services.ProjectServices;

import javax.validation.Valid; //better error messaging

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectServices projectService;

    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){

        if(result.hasErrors()){ //Giving appropriate response entity
            return new ResponseEntity<String>("Invalid project object", HttpStatus.BAD_REQUEST);
        }

        Project project1 = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }


}
