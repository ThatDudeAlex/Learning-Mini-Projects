// ========= Imports =============
const swap          = require("./Helper/ListUtils").swap
const isSorted      = require("./Helper/ListUtils").isSorted
const printHeaders  = require("./Helper/ListUtils").printHeaders
const printList     = require("./Helper/ListUtils").printList

const generateFixedSizeUnsortedList = require("./Helper/UnsortedListGenerator").generateFixedSizeUnsortedList

/* 
Selection Sort

Time Complexity
---------------------
Worst   : O(n^2)

Average : O(n^2)

Best    : O(n^2)
*/
performSelectionSort = (list) => {
    let smallestNumberIndex;
    
    for (let i = 0; i < list.length; i++){
        smallestNumberIndex = i;
        
        for (let j = i + 1; j < list.length; j++) 
            if (list[j] < list[smallestNumberIndex]) 
                smallestNumberIndex = j;
        swap(list, i, smallestNumberIndex);
    } 
    
    return list;        
}


main = () => {
    let list = generateFixedSizeUnsortedList();

    printHeaders("Before Selection Sort");
    printList(list);

    printHeaders("After Selection Sort");
    printList(performSelectionSort(list));

    if (isSorted(list))
        printHeaders("HOORAY!");
    else
        printHeaders("Fail :(");
}

main()
