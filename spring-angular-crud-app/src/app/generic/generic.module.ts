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
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MatNativeDateModule } from '@angular/material/core';
import { GENERIC_ROUTES } from './generic.routes';
import { RouterModule } from '@angular/router';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
@NgModule({
  declarations: [
    GenericEditComponent,
    GenericListComponent,

  ],
  providers: [GenericService],
  exports: [
    GenericEditComponent,
    GenericListComponent
  ],
  imports: [
    RouterModule.forRoot(GENERIC_ROUTES),
    CommonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    MatDividerModule,
    BrowserAnimationsModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
    MatNativeDateModule,
  ]
})
export class GenericModule { }
