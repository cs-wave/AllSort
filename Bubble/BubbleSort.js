function bubbleSort(arr, len) {
    for(let i = 0; i < len-1; i++) {
        for(let j = 0; j < len-1; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }
    }
}

function swap(arr, idx1, idx2) {
    let tmp = arr[idx2];
    arr[idx2] = arr[idx1];
    arr[idx1] = tmp;
}

let a = [1,5,9,3,2,4,7,8,6,0];
bubbleSort(a, 10);

console.log(a);