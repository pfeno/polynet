import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { StoriesService} from "../stories.service";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent implements OnInit {

  stories: any[];
  constructor(private storiesService:StoriesService) { }

  ngOnInit() {
    this.storiesService.fetch().then(()=>{
      this.stories=this.storiesService.getStories();
    });

  }

}
