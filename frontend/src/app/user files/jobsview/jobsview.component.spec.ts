import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JobsviewComponent } from './jobsview.component';

describe('JobsviewComponent', () => {
  let component: JobsviewComponent;
  let fixture: ComponentFixture<JobsviewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JobsviewComponent]
    });
    fixture = TestBed.createComponent(JobsviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
