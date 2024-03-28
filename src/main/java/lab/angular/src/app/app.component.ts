import { Component } from '@angular/core';
import { ExcerciseListComponent } from './excercise-list/excercise-list.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ExcerciseListComponent, RouterModule, HttpClientModule],
  template: `
    <header class="list-header">
      <a [routerLink]="['/']" class="list-header-logo"><img class="list-header-logo" src="assets/logo.png"></a>
      <h1 id="list-header-text">
        Lista zadań na przedmiot "Wybrane Zagadnienia Kryptograficzne"
      </h1>
    </header>
    <div class="header-div">
</div>
    <router-outlet>
    </router-outlet>
`,
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'default';
}
