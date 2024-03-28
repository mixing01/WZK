import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Excercise } from '../excercise';
import { ExcerciseComponent } from '../excercise/excercise.component';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-excercise-list',
  standalone: true,
  imports: [ExcerciseComponent, CommonModule, RouterModule],
  template: `
    <section class="content">
      <app-excercise
      *ngFor="let excercise of excerciseList"
      [excercise]="excercise">
      </app-excercise>
    </section>
  `,
  styleUrl: './excercise-list.component.css'
})
export class ExcerciseListComponent {
  excerciseList: Excercise[] = [
    {
      id: 1,
      name: "Lab 1: Generator ciągów pseudolosowych",
      values: []
    },
    {
      id: 2,
      name: "Lab 2: Algorytmy RSA oraz DH",
      values: []
    },
    {
      id: 3,
      name: "Lab 3: Funkcje skrótu",
      values: []
    },
    {
      id: 4,
      name: "Lab 4: TODO",
      values: []
    },
    {
      id: 5,
      name: "Lab 5: TODO",
      values: []
    },
    {
      id: 6,
      name: "Lab 6: TODO",
      values: []
    }]
}
