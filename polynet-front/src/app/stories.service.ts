import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class StoriesService {

  stories : any = [];

  constructor(private httpClient:HttpClient) { }

  getStories() {
    return this.stories;
  }

  share(content:string) {
    return this.httpClient.post("http://localhost:8080/stories?content=" + content, "").toPromise().then(()=>{
      this.stories.unshift({
        content:content
      })
    });
  }

  fetch(){
    return   this.httpClient.get("http://localhost:8080/stories?skip=0&limit=5").toPromise()
      .then((res) => this.stories = res);
  }
}
