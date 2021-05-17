// ========= Imports =============
const {isSorted, printHeaders, printList} = require("./Helper/ListUtils")
const {generateFixedSizeUnsortedList}     = require("./Helper/UnsortedListGenerator")


/* 
    Merge Sort

    Time Complexity
    ---------------------
    Worst   : O(n log n)

    Average : O(n log n)
    
    Best    : O(n log n)
*/
performMergeSort = (list, low, high) => {
    // Using Math.floor() because JavaScript Doesn't automatically do interger division
    let mid = Math.floor((low + high) / 2) 

    if (low >= high)
        return
    
    performMergeSort(list, low, mid)
    performMergeSort(list, mid + 1, high)

    merge(list, low, high, mid)
}

merge = (list, low, high, mid) => {
    let currentIdxOfArray1 = low
    let currentIdxOfArray2 = mid + 1
    let currentIdxOfAux    = 0
    let auxiliaryArray     = new Array((high - low) + 1).fill(0)

    // Uses the auxiliaryArray to sort & merge both arrays leto it
    while (numbersRemainInArray1(currentIdxOfArray1, mid) || numbersRemainInArray2(currentIdxOfArray2, high)) {
        if (!numbersRemainInArray1(currentIdxOfArray1, mid))
            auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray2++]

        else if (!numbersRemainInArray2(currentIdxOfArray2, high))
            auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray1++]

        else if (list[currentIdxOfArray1] < list[currentIdxOfArray2])
            auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray1++]

        else 
            auxiliaryArray[currentIdxOfAux++] = list[currentIdxOfArray2++]
    }

    // copies the sorted content of the auxiliaryArray leto the original list 
    for (let i = low, j = 0; i <= high; i++)
        list[i] = auxiliaryArray[j++]
}

numbersRemainInArray1 = (indexOfArray1, mid)  => indexOfArray1 <= mid

numbersRemainInArray2 = (indexOfArray2, high) => indexOfArray2 <= high

main = () => {
    list = generateFixedSizeUnsortedList()

    printHeaders("Before Merge Sort")
    printList(list)

    printHeaders("After Merge Sort")
    performMergeSort(list, 0, list.length - 1)
    printList(list)

    if (isSorted(list))
        printHeaders("HOORAY!")
    else
        printHeaders("Fail :(")
}

main()
