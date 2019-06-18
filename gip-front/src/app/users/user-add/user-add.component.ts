import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

import { UserService } from '../../service/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-user-add',
  templateUrl: './user-add.component.html',
  styleUrls: ['./user-add.component.css']
})
export class UserAddComponent implements OnInit {

  userForm: FormGroup;

  constructor(private fb: FormBuilder, private data: UserService, private router: Router) {}

  ngOnInit() {
    this.userForm = this.fb.group({
      matriculation: '',
      fullname: '',
      username: '',
      password: '',
      perfil: '',
    });
  }

  onSubmit() {
    this.data.add(this.userForm.value).subscribe(
      data => {
        this.router.navigate(['user_list']);
      });
  }
}
