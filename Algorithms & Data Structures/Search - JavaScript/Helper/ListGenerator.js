const buildUnsortedList = (listSize, upperBoundForRandomNumber) => {
    let unsortedList = new Array(listSize)
    
    for (i = 0; i < listSize; i++)
        unsortedList[i] = Math.floor(Math.random() * upperBoundForRandomNumber + 1)

    return unsortedList
}

const generateFixedSizeUnsortedList = () => buildUnsortedList(20, 1000)

const generateUnsortedList = (listSize, upperBoundForRandomNumber) => buildUnsortedList(listSize, upperBoundForRandomNumber)

// ==============================================

const buildSortedList = (listSize) => {
    let sortedList = new Array(listSize)

    for (let i = 0, j = 1; i < sortedList.length; i++, j++) {
        if (i == 0)
            sortedList[i] = i
        else 
            sortedList[i] = sortedList[i - 1] + j

        if (j % 100 == 0)
            j = 1
    }
    return sortedList;
}

const generateFixedSizeSortedList = () => {
    return buildSortedList(30)
}

const generateSortedList = (listSize) => {
    return buildSortedList(listSize)
}

module.exports = {generateFixedSizeUnsortedList, generateUnsortedList, generateSortedList, generateFixedSizeSortedList};



