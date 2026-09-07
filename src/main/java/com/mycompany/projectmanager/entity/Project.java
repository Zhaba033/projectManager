package com.mycompany.projectmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="projects")

@Getter
@Setter
@NoArgsConstructor
public class Project {
    
    @Id
    @SequenceGenerator(
            name = "project_seq",
            sequenceName = "project_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="project_seq")
    Long id;
    
    @Column(nullable=false)
    String name;
    @Column(nullable=false)
    String description;
    
}
