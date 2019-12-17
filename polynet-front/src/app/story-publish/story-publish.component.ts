import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import { StoriesService} from "../stories.service";

@Component({
  selector: 'app-story-publish',
  templateUrl: './story-publish.component.html',
  styleUrls: ['./story-publish.component.css']
})
export class StoryPublishComponent implements OnInit {
  content: string;

  constructor(private storiesService: StoriesService) { }

    ngOnInit() {}

  shareStory() {
    this.storiesService.share(this.content);
    };
}
