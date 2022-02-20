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
