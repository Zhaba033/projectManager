package com.mycompany.projectmanager.controller;

import com.mycompany.projectmanager.entity.Project;
import com.mycompany.projectmanager.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ProjectController {
    
    final ProjectRepository projectRepository; 
    
    @GetMapping("/project/{p}")
    public String projectPage(
            @PathVariable long p,
            Model model) {
        Project proj = projectRepository.findById(p).orElseThrow();
        model.addAttribute("project", proj);
        
        return "project-page";
    }
    
    @GetMapping("/project-list")
    public String projectList(Model model) {
        
        model.addAttribute("projects", projectRepository.findAll());
        
        return "project-list";
    }
    
    @GetMapping("/create-project")
    public String createProject() {
        return "create-project";
    }
    
    @PostMapping("/create-project/submit")
    public String sumbitCreating(Project proj) {
        projectRepository.save(proj);
        
        return "redirect:/project/" + proj.getId();
    }
    
}
