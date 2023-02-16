// happy coding 👻
function fibonacci(num: number): number {
    if (num == 1 || num == 2) {
        return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}

let num: number = 5;
let sum = 0;

console.log("Dãy " + num + " số fibonacci đầu tiên là: ");

for (let i = 1; i <= num; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}
console.log("Tổng dãy " + num + " số fibonacci đầu tiên là: " + sum);