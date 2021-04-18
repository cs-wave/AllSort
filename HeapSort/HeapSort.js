function heapSort(arr, len) {
    if(len < 1) return;

    let heap = new Array(len);
    for(let i = 0; i < len; i++) {
        push(heap, i, arr[i]);
    }
    for(let j = len-1; j > -1; j--) {
        pop(arr, heap, j);
    }
}

function swap(arr, idx1, idx2) {
    let tmp = arr[idx2];
    arr[idx2] = arr[idx1];
    arr[idx1] = tmp;
}

function push(heap, idx, value) {
    heap[idx] = value;
    high(heap, idx);
}

function pop(arr, heap, idx) {
    arr[idx] = heap[0];
    swap(heap, 0, idx);
    low(heap, 0, idx-1);
}

function high(heap, idx) {
    if(idx == 0) return;
    let idx2 = Math.floor((idx-1)/2);
    if(heap[idx] > heap[idx2]) {
        swap(heap, idx, idx2);
        high(heap, idx2);
    }
}

function low(heap, idx, max) {
    let left = idx*2+1;
    let right = idx*2+2;
    if(right > max) {
        if(left <= max && heap[left] > heap[idx]) {
            swap(heap, idx, left);
            low(heap, left, max);
        }
    } else {
        if(heap[left] > heap[right]) {
            if(heap[left] > heap[idx]) {
                swap(heap, idx, left);
                low(heap, left, max);
            }
        } else {
            if(heap[right] > heap[idx]) {
                swap(heap, idx, right);
                low(heap, right, max);
            }
        }
    }
}

let a = [1,5,9,3,2,4,7,8,6,0];
heapSort(a, 10);

console.log(a);