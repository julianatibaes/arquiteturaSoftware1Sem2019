import { Component, OnInit } from '@angular/core';

import { UserService } from '../../service/user.service';
import { User } from '../../model/user.model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor( private data: UserService, private router: Router) { }

  ngOnInit() {
    this.data.getAll()
      .subscribe( data => {
        this.users = data;
        console.log(data);
      });
  }

  deleteUser(user: User): void {
    this.data.delete(user.matriculation)
      .subscribe( data => {
        this.users = this.users.filter(u => u !== user);
      });
  }

  addUser() {
    this.router.navigate(['user_add']);
  }

}
