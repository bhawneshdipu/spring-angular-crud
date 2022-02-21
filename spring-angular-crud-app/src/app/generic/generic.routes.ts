import { Routes } from '@angular/router';
import { AppComponent } from '../app.component';
import { GenericCreateComponent } from './generic-create/generic-create.component';
import { GenericEditComponent } from './generic-edit/generic-edit.component';
import { GenericEntityComponent } from './generic-entity/generic-entity.component';
import { GenericListComponent } from './generic-list/generic-list.component';

export const GENERIC_ROUTES: Routes = [
  {
    path: '',
    component: GenericEntityComponent
  }, {
    path: 'list/:entity',
    component: GenericListComponent
  },
  {
    path: 'edit/:entity/:id',
    component: GenericEditComponent
  },
  {
    path: 'create/:entity',
    component: GenericCreateComponent
  }
];
