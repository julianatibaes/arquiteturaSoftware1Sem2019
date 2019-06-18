import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user.model';
import { Project } from '../../model/project.model';
import { UserService } from '../../service/user.service';
import { ProjectService } from '../../service/project.service';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-project-add',
  templateUrl: './project-add.component.html',
  styleUrls: ['./project-add.component.css']
})
export class ProjectAddComponent implements OnInit {

  projectForm: FormGroup;
  users: User[] = [];

  constructor(private fb: FormBuilder, private data: UserService, private dataProject: ProjectService, private router: Router) {
  }

  ngOnInit() {
    this.data.getAll()
    .subscribe( data => {
      this.users = data;
    });

    this.projectForm = this.fb.group({
      owner: [this.users[0]],
      title: '',
      startProject: ''
    });
  }

  onSubmit() {
    console.log(this.projectForm.value);

    this.dataProject.add(this.projectForm.value).subscribe(
      data => {
        alert('Tudo certo');
        this.router.navigate(['project_list']);
      });
  }

}
