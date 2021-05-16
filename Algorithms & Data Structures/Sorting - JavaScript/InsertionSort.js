// ========= Imports =============
const {swap, isSorted, printHeaders, printList} = require("./Helper/ListUtils")
const {generateFixedSizeUnsortedList}           = require("./Helper/UnsortedListGenerator")

/* 
    Insertion Sort

    Time Complexity
    ---------------------
    Worst   : O(n^2)

    Average : O(n^2)

    Best    : O(n)
*/
performInsertionSort = (unsortedList) => {
    for (let i = 1; i < unsortedList.length; i++) 
        for (let j = i; j >= 1; j--) 
            if (unsortedList[j - 1] > unsortedList[j]) 
                swap(unsortedList, j, j - 1)
    return unsortedList
}

main = () => {
    let list = generateFixedSizeUnsortedList()

    printHeaders("Before Insertion Sort")
    printList(list)

    printHeaders("After Insertion Sort")
    printList(performInsertionSort(list))

    
    if (isSorted(list))
        printHeaders("HOORAY!")
    else
        printHeaders("Fail :(")
}

main()