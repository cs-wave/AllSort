/**
 * 버블정렬 수행
 * 
 * @param {Array<Number>} arr 정렬할 배열 
 */
function bubbleSort(arr) {
    for(let i = 0; i < arr.length-1; i++) {
        for(let j = 0; j < arr.length-i-1; j++) {
            if(arr[j] > arr[j+1]) {
                swap(arr, j, j+1);
            }
        }
    }
}

/**
 * arr의 idx1과 idx2의 인덱스에 해당하는 두 원소 서로 교체
 * 
 * @param {Array<Number>} arr 스왑할 배열
 * @param {Number} idx1 1번째 인덱스
 * @param {Number} idx2 2번째 인덱스
 */
function swap(arr, idx1, idx2) {
    let tmp = arr[idx2];
    arr[idx2] = arr[idx1];
    arr[idx1] = tmp;
}

let a = [1,5,9,3,2,4,7,8,6,0];
bubbleSort(a);

console.log(a);