import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  gipUrl = 'http://localhost:8080/gip';

  constructor(private http: HttpClient) { }

  getProjects() {
    return this.http.get('https://api.myjson.com/bins/rp95r');
    //http://jsonplaceholder.typicode.com/users
    //http://myjson.com/
  }

  getProject(projectId) {
    //return this.http.get('https://api.myjson.com/bins/rp95r/' + projectId);
    return this.http.get('https://api.myjson.com/bins/t71vz');
  }

  postProject(project: any) {
    return this.http.post(this.gipUrl, project);
  }
}
