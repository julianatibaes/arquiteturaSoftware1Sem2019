import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  url = 'http://localhost:8080/login';

  getAll() {
    return this.http.get<User[]>(this.url);
  }

  getById(id: number) {
    return this.http.get<User>(this.url + '/' + id);
  }

  add(user: User) {
    return this.http.post(this.url, user);
  }

  delete(id: number) {
    return this.http.delete(this.url + '/' + id);
  }
}
