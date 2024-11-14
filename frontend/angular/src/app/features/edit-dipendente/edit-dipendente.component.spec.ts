import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDipendenteComponent } from './edit-dipendente.component';

describe('EditDipendenteComponent', () => {
  let component: EditDipendenteComponent;
  let fixture: ComponentFixture<EditDipendenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EditDipendenteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditDipendenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
