import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GenericEditComponent } from './generic-edit/generic-edit.component';
import { GenericListComponent } from './generic-list/generic-list.component';
import {GenericService} from "./generic.service";
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatDividerModule } from '@angular/material/divider';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatNativeDateModule } from '@angular/material/core';
import { GENERIC_ROUTES } from './generic.routes';
import { RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { GenericEntityComponent } from './generic-entity/generic-entity.component';
@NgModule({
  declarations: [
    GenericEditComponent,
    GenericListComponent,
    GenericEntityComponent,
  ],
  providers: [GenericService],
  exports: [
    GenericEditComponent,
    GenericListComponent
  ],
  imports: [
    RouterModule.forRoot(GENERIC_ROUTES),
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatSnackBarModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatDividerModule,
    MatToolbarModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
  ]
})
export class GenericModule { }
