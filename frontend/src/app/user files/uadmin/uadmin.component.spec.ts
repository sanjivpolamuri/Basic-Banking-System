import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UadminComponent } from './uadmin.component';

describe('UadminComponent', () => {
  let component: UadminComponent;
  let fixture: ComponentFixture<UadminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UadminComponent]
    });
    fixture = TestBed.createComponent(UadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
