import {AbstractControl, ValidationErrors} from "@angular/forms";
import {formatDate} from "@angular/common";

export function identityRevealedValidator(control: AbstractControl): ValidationErrors | null {
  const startDate = control.value.startDate;
  const endDate = control.value.endDate;

  const date1 = formatDate(startDate, 'yyyy-MM-dd', 'en_US');
  const date2 = formatDate(endDate, 'yyyy-MM-dd', 'en_US');

  return date1 <= date2 ? null : {dateError: true};
}
