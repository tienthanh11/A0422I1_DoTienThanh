// happy coding 👻
function fibonacci(num) {
    if (num == 1 || num == 2) {
        return 1;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}
var num = 10;
var sum = 0;
console.log("Dãy " + num + " số fibonacci đầu tiên là: ");
for (var i = 1; i <= num; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}
console.log("Tổng dãy " + num + " số fibonacci đầu tiên là: " + sum);
