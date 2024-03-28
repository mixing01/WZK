import { Component, Input } from '@angular/core';
import { Excercise } from '../excercise';
import { HttpService } from '../http.service';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-excercise',
  standalone: true,
  imports: [RouterModule],
  template: `
  <a [routerLink]="['/details',excercise.id]">
    <section class="excercise-details">
      <h1 id="excercise-title">
        {{excercise.name}}
    </h1>
    </section>
</a>
  `,
  styleUrl: './excercise.component.css'
})
export class ExcerciseComponent {
  @Input() excercise!: Excercise;
}
