import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import {GenericService} from "../generic.service";
import {GenericModel, GenericRecord} from "../generic.model";
import { MatTableDataSource } from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-generic-list',
  templateUrl: './generic-list.component.html',
  styleUrls: ['./generic-list.component.css']
})
export class GenericListComponent implements OnInit,AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator|undefined;
  @ViewChild(MatSort)
  sort: MatSort = new MatSort;

  public actionColumns = ['actions'];
  public displayedColumns:any[] = [];
  public columns:any[] = []
  public entityMap: GenericRecord | undefined;
  public dataSource: any;
  public entity: any;
  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private genericService: GenericService) {
  }

  ngOnInit(): void {
    this.entity = this.activatedRoute.snapshot.paramMap.get('entity')
    if (this.entity){
            this.genericService.list(this.entity).subscribe({
              next: (result)=>{
                this.dataSource = new MatTableDataSource(result)
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
                if(result.length>0){
                  this.columns = Object.getOwnPropertyNames(result[0])
                }
                this.displayedColumns = this.columns.slice();
                this.displayedColumns.push(...this.actionColumns);
                console.log(this.dataSource.paginator)
                console.log("data list success for entity",this.entity)
              },
              error:(err)=>{
                console.log("Error loading list for entity",this.entity,err)
                }
              }
            );
          }else{
           this.genericService.findAllEntity().subscribe({
              next: (result)=>{
                this.entityMap=result;
                let arr: any[] = [];
                let data=this.entityMap;
                Object.keys(data).map(function(key){
                    arr.push(data[key])
                });
                this.dataSource = new MatTableDataSource(arr)
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
                if(arr.length>0){
                  this.columns = Object.getOwnPropertyNames(arr[0])
                }
                this.displayedColumns = this.columns.slice();
                this.displayedColumns.push(...this.actionColumns);
                console.log(this.dataSource.paginator)
                console.log("data fetch success")
              },
              error:(err)=>{
                console.log("Error loading entity Map",err)
                }
              }
            );
          }
  }
  ngAfterViewInit() {
    console.log(this.dataSource);
    if(this.dataSource){
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    }
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
  delete(entity:string,id:string):void{
    this.genericService.delete(entity,id).subscribe({
        next: (result)=>{
          console.log("deleted item",result);
        },
        error:(err)=>{
          console.log("Error deleting entity with id",entity,id)
        }
      }
    );
  }
  isObject(data:any){
    return typeof data === 'object';
  }

}
