import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

import { UserService } from '../../service/user.service';
import { User } from '../../model/user.model';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  userForm: FormGroup;
  user: User;

  constructor(private fb: FormBuilder, private data: UserService, private router: Router, private route: ActivatedRoute ) {
  }

  perfils = [
    {name: 'COMMON', label: 'usuário'},
    {name: 'ADMIN', label: 'administrador'},
    {name: 'MASTER', label: 'gerente'}
  ];

  ngOnInit() {
    this.getUser(this.route.snapshot.params['id']);
    this.userForm = this.fb.group({
      matriculation: '',
      fullname: '',
      username: '',
      password: '',
      perfil: '',
    });
  }

  getUser(id) {
    this.data.getById(id).subscribe(
      data => {
        this.user = data;
        this.userForm.setValue({
          matriculation: this.user.matriculation,
          fullname: this.user.fullname,
          username: this.user.username,
          password: this.user.password,
          perfil: this.user.perfil
        });

      }//
    );
  }

  onSubmit() {
    this.data.add(this.userForm.value).subscribe(
      data => {
        this.router.navigate(['user_list']);
      });
  }
}
