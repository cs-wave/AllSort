//Unofficial algorithm

function mergeSort(arr) {
    arr = divide(arr);
    return conquer(arr);
}

function divide(arr) {
    if(arr.length < 2) return arr;
    else {
        return [
            divide(arr.splice(0, arr.length/2)),
            divide(arr)
        ];
    }
}

function conquer(arr) {
    if(!(arr[0][0] instanceof Number && arr[1][0] instanceof Number)) {
        if(arr[0][0] instanceof Array) arr[0] = conquer(arr[0]);
        if(arr[1][0] instanceof Array) arr[1] = conquer(arr[1]);
    }
    return combine(arr[0], arr[1]);
}

function combine(arr1, arr2) {
    let tmp = [];
    while(arr1.length!=0||arr2.length!=0) {
        if(arr1.length==0) tmp.push(arr2.shift());
        else if(arr2.length==0) tmp.push(arr1.shift());
        else {
            if(arr1[0] > arr2[0]) {
                tmp.push(arr2.shift());
            } else {
                tmp.push(arr1.shift());
            }
        }
    }
    return tmp;
}

let a = [1,5,9,3,2,4,7,8,6,0];
mergeSort(a);

console.log(a);