import { Routes } from '@angular/router';
import { AppComponent } from '../app.component';
import { GenericEditComponent } from './generic-edit/generic-edit.component';
import { GenericListComponent } from './generic-list/generic-list.component';

export const GENERIC_ROUTES: Routes = [
  {
    path: '',
    component: GenericListComponent
  }, {
    path: 'list/:entity',
    component: GenericListComponent
  },
  {
    path: 'edit/:entity/:id',
    component: GenericEditComponent
  }
];
