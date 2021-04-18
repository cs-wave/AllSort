function mergeSort(arr, start, end) {
    if(end-start > 0) {
        let mid = Math.floor((end+start)/2)+1;
        mergeSort(arr, start, mid-1);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);  
    }
}

function merge(arr, start, mid, end) {
    let map = [];
    let i, j, l;
    i = start, j = mid;
    l = end-start+1;
    while(i < mid && j < end+1) {
        if(arr[i] > arr[j]) {
            map.push(arr[j++]);
        } else {
            map.push(arr[i++]);
        }
    }
  
    while(i < mid) {
        map.push(arr[i++]);
    }
  
    while(j < end+1) {
        map.push(arr[j++]);
    }
  
    for(let k = 0; k < l; k++) {
        arr[k+start] = map[k];
    }
}

let arr= [];
for(let i = 100000; i > 0; i--){
    arr.push(i);
}
mergeSort(arr, 0, 99999);
console.log(arr);