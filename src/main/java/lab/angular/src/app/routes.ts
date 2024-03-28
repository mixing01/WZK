import { Routes } from '@angular/router';
import { ExcerciseListComponent } from './excercise-list/excercise-list.component';
import { Details1Component } from './details/details1.component';
import { Details2Component } from './details/details2.component';
import { Details3Component } from './details/details3.component';
import { Details4Component } from './details/details4.component';
import { Details5Component } from './details/details5.component';
import { Details6Component } from './details/details6.component';

const routeConfig: Routes = [
    {
      path: '',
      component: ExcerciseListComponent,
      title: 'Strona główna'
    },
    {
      path: 'details/1',
      component: Details1Component,
      title: 'Zadanie 1'
    },
    {
      path: 'details/2',
      component: Details2Component,
      title: 'Zadanie 2'
    },
    {
      path: 'details/3',
      component: Details3Component,
      title: 'Zadanie 3'
    },
    {
      path: 'details/4',
      component: Details4Component,
      title: 'Zadanie 4'
    },
    {
      path: 'details/5',
      component: Details5Component,
      title: 'Zadanie 5'
    },
    {
      path: 'details/6',
      component: Details6Component,
      title: 'Zadanie 6'
    },
  ];
  
  export default routeConfig;