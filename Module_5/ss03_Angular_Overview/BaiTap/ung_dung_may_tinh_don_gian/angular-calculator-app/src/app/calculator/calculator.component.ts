import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  number1: number = 0;
  number2: number = 0;
  result: number = 0;

  constructor() {
  }

  ngOnInit(): void {
  }

  calculate(number1: string, number2: string, cal: string) {
    this.result = 0;
    this.number1 = parseInt(number1);
    this.number2 = parseInt(number2);

    if (number1 == "" || number2 == "") {
      this.result = 0;
    } else {
      switch (cal) {
        case "+":
          this.result = this.number1 + this.number2;
          break;
        case "-":
          this.result = this.number1 - this.number2;
          break;
        case "*":
          this.result = this.number1 * this.number2;
          break;
        case "/":
          this.result = this.number1 / this.number2;
          break;
      }
    }
  }
}
