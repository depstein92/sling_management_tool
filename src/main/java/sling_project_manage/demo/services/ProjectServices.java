package sling_project_manage.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sling_project_manage.demo.domain.Project;
import sling_project_manage.demo.repositories.ProjectRepository;

@Service
public class ProjectServices {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project){

        //Logic

        return projectRepository.save(project);
    }
}
