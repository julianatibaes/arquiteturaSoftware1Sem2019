import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from '../model/project.model';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  constructor(private http: HttpClient) { }

  gipUrl = 'http://localhost:8080/project';

  getAll() {
    return this.http.get<Project[]>(this.gipUrl);
  }

  getById(id: number) {
    return this.http.get<Project>(this.gipUrl + '/' + id);
  }

  add(project: Project) {
    console.log(JSON.stringify(project));
    return this.http.post(this.gipUrl, JSON.stringify(project));
  }

  delete(id: number) {
    return this.http.delete(this.gipUrl + '/' + id);
  }
}
