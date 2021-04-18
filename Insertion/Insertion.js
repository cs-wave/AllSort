function insertionSort(arr, len) {
    for(let i = 0; i < len-1; i++) {
        for(let j = i+1; j > 0; j--) {
            if(arr[j-1] > arr[j]) {
                swap(arr, j-1, j);
            }
            else break;
        }
    }
}

function swap(arr, idx1, idx2) {
    let tmp = arr[idx2];
    arr[idx2] = arr[idx1];
    arr[idx1] = tmp;
}

let a = [1,5,9,3,2,4,7,8,6,0];
insertionSort(a, 10);

console.log(a);
