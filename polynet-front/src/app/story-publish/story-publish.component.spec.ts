import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoryPublishComponent } from './story-publish.component';

describe('StoryPublishComponent', () => {
  let component: StoryPublishComponent;
  let fixture: ComponentFixture<StoryPublishComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoryPublishComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoryPublishComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
