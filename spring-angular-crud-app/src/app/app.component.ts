import { FlatTreeControl } from '@angular/cdk/tree';
import { Component, OnInit } from '@angular/core';
import { MatTreeFlatDataSource } from '@angular/material/tree';
import { GenericModel } from './generic/generic.model';
import { GenericService } from './generic/generic.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'spring-angular-crud-app';
  showFiller = false;
  entityList: any
  dataSource: any
  constructor(private genericService: GenericService) {
  }
    ngOnInit(): void {
    this.genericService.findAllEntity().subscribe({
      next: (result)=>{
        let arr: any[] = [];
        Object.keys(result).map(function(key){  
            arr.push(result[key])
        });
        this.entityList = arr;
        console.log("data fetch success")
      },
      error:(err)=>{
        console.log("Error loading entity Map",err)
        }
      }
    );
  }
}

