import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaorariComponent } from './tabellaorari.component';

describe('TabellaorariComponent', () => {
  let component: TabellaorariComponent;
  let fixture: ComponentFixture<TabellaorariComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [TabellaorariComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TabellaorariComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
