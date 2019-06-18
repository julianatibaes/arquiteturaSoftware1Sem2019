import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ProjectService } from '../../service/project.service';
import { Project } from '../../model/project.model';
import { User } from '../../model/user.model';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-project-detail',
  templateUrl: './project-detail.component.html',
  styleUrls: ['./project-detail.component.css']
})
export class ProjectDetailComponent implements OnInit {

  // variável
  project: Project;
  projectForm: FormGroup;

  submitted =  false;
  success = false;

  constructor(private data: ProjectService, private route: ActivatedRoute, private formBuilder: FormBuilder) {  }
  // controle de formulário
  ngOnInit() {
    try {
      this.data.getProjectById(this.project.id_project).subscribe(
        data => this.project = data
      );
      console.log(this.project);
    } catch (e) {
      console.log(e);
    }


    this.projectForm = this.formBuilder.group({
      id_project: [],
      title: ['', Validators.required]
    } );
  }

  onSubmit() {
    this.submitted = true;

    if (this.projectForm.invalid) {
      return;
    }
    this.success = true;

    this.data.updateProject(this.projectForm.value)
    .pipe(first())
    .subscribe(
      data => {
      },
      error => {
        alert(error);
      });
}


  firstClick() {
    return console.log('foi');
  }
}
