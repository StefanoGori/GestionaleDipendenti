import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteDipendenteComponent } from './delete-dipendente.component';

describe('DeleteDipendenteComponent', () => {
  let component: DeleteDipendenteComponent;
  let fixture: ComponentFixture<DeleteDipendenteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DeleteDipendenteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DeleteDipendenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
