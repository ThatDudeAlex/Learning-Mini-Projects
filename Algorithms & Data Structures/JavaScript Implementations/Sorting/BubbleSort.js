// ========= Imports =============
const {swap, isSorted, printHeaders, printList} = require("../Helper/ListUtils")
const {generateFixedSizeUnsortedList}           = require("../Helper/ListGenerator")

/* 
    Bubble Sort works by slowly moving bigger numbers down the list, eventually every number will  
    end in their correct spot. Not a very efficient sorting algorithm.

    Time Complexity
    ---------------------
    Worst   : O(n^2)

    Average : O(n^2)
    
    Best    : O(n)
*/
const performBubbleSort = (list) => {
    for (let i = 0; i < list.length; i++) 
        for (let j = 0; j < list.length; j++)
            if ((j + 1) < list.length && list[j] > list[j + 1])
                swap(list, j, j + 1)
                
    return list     
}


const main = () => {
    let list = generateFixedSizeUnsortedList()

    printHeaders("Before Bubble Sort")
    printList(list)
    
    printHeaders("After Bubble Sort")
    printList(performBubbleSort(list))
    
    if (isSorted(list))
        printHeaders("HOORAY!")
    else
        printHeaders("Fail :(")
}

// Starts the program
main()
