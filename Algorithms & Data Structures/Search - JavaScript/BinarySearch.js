// ========= Imports =============
const {printHeaders, printList} = require("./Helper/ListUtils")
const {generateSortedList}      = require("./Helper/ListGenerator")


//  return the index of the number found or -1
performBinarySearch = (sortedList, numberToFind) => {
    let lowestIndex     = 0
    let highestIndex    = sortedList.length - 1
    let middleIndex     = Math.floor((lowestIndex + highestIndex) / 2)

    while (lowestIndex <= highestIndex) {

        if (sortedList[middleIndex] > numberToFind)
            highestIndex = middleIndex - 1
        else if (sortedList[middleIndex] < numberToFind)
            lowestIndex = middleIndex + 1
        else if (sortedList[middleIndex] == numberToFind)
            return middleIndex

        middleIndex = Math.floor((lowestIndex + highestIndex) / 2)
    }
    return -1;
}

printNumberFoundHeader = (numberFoundAtIndex, numberToFind) => {
    const column       = Math.floor(numberFoundAtIndex % 10 + 1)
    const row          = Math.floor(numberFoundAtIndex / 10 + 1)
    printHeaders(`HOORAY! NUMBER ${numberToFind} WAS FOUND IN COL: ${column} ROW: ${row}`)
}

printNumberNotFoundHeader = (numberToFind) => {
    printHeaders(`LIST DOES NOT CONTAINER THE NUMEBER ${numberToFind}`)
}

main = () => {
    sortedList          = generateSortedList(100);
    numberToFind        = 44; // change this number to test if is in the list
    numberFoundAtIndex  = performBinarySearch(sortedList, numberToFind);
    
    printHeaders(`Sorted list of size: ${sortedList.length}`)
    printList(sortedList)

    if (numberFoundAtIndex >= 0) 
        printNumberFoundHeader(numberFoundAtIndex, numberToFind)
    else
        printNumberNotFoundHeader(numberToFind)
}

main()