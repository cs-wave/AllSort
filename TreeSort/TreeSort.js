function BinaryTree(value) {
    this.value = value;
    this.left = null;
    this.right = null;
}

let index = 0;

function treeSort(arr, len) {
    if(len < 1) return;

    let root = null;
    for(let i = 0; i < len; i++) {
        root = insert(root, arr[i]);
    }
    inOrder(root, arr);
    index = 0;
}

function insert(t, value) {
    if(t == null) {
        return new BinaryTree(value);
    } else {
        if(value > t.value) {
            t.right = insert(t.right, value);
        } else {
            t.left = insert(t.left, value);
        }
        return t;
    }
}

function inOrder(t, arr) {
    if(t != null) {
        inOrder(t.left, arr);
        arr[index++] = t.value;
        inOrder(t.right, arr);
    }
}

let a = [1,5,9,3,2,4,7,8,6,0];
treeSort(a, 10);

console.log(a);