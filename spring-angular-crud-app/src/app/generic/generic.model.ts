import {
  Component,
  OnChanges,
  Input,
  ChangeDetectionStrategy,
  SimpleChanges,
} from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

export interface GenericFormValidators {
  min?: number;
  max?: number;
  required?: boolean;
  email?: boolean;
  minLength?: boolean;
  maxLength?: boolean;
  pattern?: string;
  nullValidator?: boolean;
}

export interface GenericFormControlOptions {
  min?: string;
  max?: string;
  step?: string;
  icon?: string;
}

export interface GenericFormControls {
  name: string;
  label: string;
  value: string;
  type: string;
  options?: GenericFormControlOptions;
  required: boolean;
  validators: GenericFormValidators;
}

export interface GenericFormData {
  controls: GenericFormControls[];
}
export interface GenericModelProperty{
  name: string;
  cls: string;
  bindingType: string;
}
export interface GenericModel{
  name: string;
  cls: string;
  propertyMap: Map<string,GenericModelProperty>
}
export type GenericRecord = Record<string, GenericModel>;

export interface GenericValidatorModel{
  name:string
  message: string
  validator: string
}
export interface FieldModel{
  validations: GenericValidatorModel[];
  type:string 
  value:string
  name:string
  cssClass: string
}
export class GenericLayoutModel{
  layoutType: string = ''
  title: string =  ''
  fields: FieldModel[] =[]
  cssClass:string = ''
}

export class GenericFormField {
  name: string='';
  type: string='';
  value: any=null;
  required: boolean = false;
  validator: string='';
}