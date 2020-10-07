import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CriarTarefasComponent } from './criar-tarefas.component';

describe('CriarTarefasComponent', () => {
  let component: CriarTarefasComponent;
  let fixture: ComponentFixture<CriarTarefasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CriarTarefasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CriarTarefasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
