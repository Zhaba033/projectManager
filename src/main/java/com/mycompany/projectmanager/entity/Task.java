package com.mycompany.projectmanager.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tasks")

@Getter
@Setter
@NoArgsConstructor
public class Task {
    
    @Id
    @SequenceGenerator(
            name = "task_seq",
            sequenceName = "task_seq",
            allocationSize = 1
    )
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="task_seq")
    Long id;
    
    @Column(nullable=false)
    String name;
    @Column(nullable=false)
    String description;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "Tasks_accounts",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    List<Account> taken_by = new ArrayList();
    
    @JoinColumn(name="project_id")
    @ManyToOne(fetch = FetchType.LAZY)
    Project project;
    
}
