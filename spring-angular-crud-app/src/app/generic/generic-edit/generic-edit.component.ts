import { HttpClient } from '@angular/common/http';
import { AfterViewInit, Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { GenericFormField, GenericLayoutModel, GenericValidatorModel } from '../generic.model';
import { GenericService } from '../generic.service';
import {
  FormControl,
  FormGroup,
  NgForm,
  ValidatorFn,
  Validators
} from '@angular/forms';
@Component({
  selector: 'app-generic-edit',
  templateUrl: './generic-edit.component.html',
  styleUrls: ['./generic-edit.component.css']
})
export class GenericEditComponent implements OnInit {

  loadCompleted: boolean=false;
  formFields: GenericFormField[] = [];
  form: FormGroup=new FormGroup({});
  entity: string |null = ''
  id: any = ''
  dataSource: any;
  entityData:any;
  formResponseData:GenericFormField[]=[];

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private genericService: GenericService,
    private snackBar: MatSnackBar,
    private httpClient: HttpClient,
    private _snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.entity = this.activatedRoute.snapshot.paramMap.get('entity')
    this.id = this.activatedRoute.snapshot.paramMap.get('id')
    if (this.entity) {
      this.genericService.findById(this.entity, this.id).subscribe({
        next: (result) => {
          this.dataSource = result;
          this.entityData = result[0];
          console.log("data list success for entity", this.entity)
          this.genericService.getFormControlByEntity(this.entity).subscribe({
            next: (result) => {
              this.formResponseData = result;
              for (const formField of this.formResponseData) {
                this.form.addControl(formField.name, new FormControl(this.getFormData(formField.name),this.getValidator(formField)));
              }
              this.formFields=result;
              console.log("form data success for entity", this.entity)
              this.loadCompleted=true;
              console.log("load completed", this.entity) 
            },
            error: (err) => {
              console.log("Error loading list for entity", this.entity, err)
            }
          });
        },
        error: (err) => {
          console.log("Error loading list for entity", this.entity, err)
        }
      });
    }
  }

  getFormData(name:string){
    if(this.entityData && this.entityData.hasOwnProperty(name)){
      return this.entityData[name];
    }else{
      return null
    }
  }

  
  onFormSubmit(formGroup: NgForm): void {
    console.log(formGroup);
    console.log(this.form.value);
    this.openSnackBar("Saving... ","close");
    this.save(formGroup.value);
  }
  onSubmit(): void {
    console.log(this.form.value);
    this.openSnackBar("Saving... ","close");
    this.save(this.form.value);
  }
  save(data:Object){
    this.genericService.save(this.entity,this.id,data)
    .subscribe({
      next: (result) => {
        this.dataSource = result;
        this.entityData = result;
        this.openSnackBar("Data saved: "+JSON.stringify(this.entityData),"close");
      },
      error: (err) => {
        this.openSnackBar("Error Saving data: "+JSON.stringify(err),"close");
      }
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action);
  }
  private getValidator(formField: GenericFormField): ValidatorFn {
    switch (formField.validator) {
      case "email":
        return Validators.email;
      case "required":
        return Validators.required;
      default:
        return Validators.nullValidator;
    }
  }
}
