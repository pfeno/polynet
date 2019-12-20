import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import * as moment from 'moment';
import {now} from "moment";

@Injectable({
  providedIn: 'root'
})
export class StoriesService {

  stories : any = [];

  constructor(private httpClient:HttpClient) { }

  getStories() {
    this.stories.forEach(story => {
      story.horodate = moment(story.horodate).fromNow()
    });
    return this.stories;
  }

  share(content:string) {
    return this.httpClient.post("http://localhost:8080/stories?content=" + content, null,{withCredentials:true}).toPromise().then(()=>{
      this.stories.unshift({
        horodate:moment(moment()).fromNow(),
        content:content
      })
    });
  }

  fetch(){
    return   this.httpClient.get("http://localhost:8080/stories?skip=0&limit=0").toPromise()
      .then((res) => this.stories = res);
  }
}
