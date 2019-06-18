import { Component, OnInit } from '@angular/core';

import { ProjectService } from '../../service/project.service';
import { Project } from '../../model/project.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {

  projects: Project[];

  constructor( private data: ProjectService, private router: Router) { }

  ngOnInit() {
    this.data.getAll()
      .subscribe( data => {
        this.projects = data;
        console.log(data);
      });
  }

  deleteProject(project: Project): void {
    this.data.delete(project.id_project)
      .subscribe( data => {
        this.projects = this.projects.filter(u => u !== project);
      });
  }

  addProject(): void {
    this.router.navigate(['project_add']);
  }

}
