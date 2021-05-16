const generateList = (listSize, upperBoundForRandomNumber) => {
    let unsortedList = new Array(listSize)
    
    for (i = 0; i < listSize; i++)
        unsortedList[i] = Math.floor(Math.random() * upperBoundForRandomNumber + 1)

    return unsortedList
}

const generateFixedSizeUnsortedList = () => generateList(20, 1000)

const generateUnsortedList = (listSize, upperBoundForRandomNumber) => generateList(listSize, upperBoundForRandomNumber)

module.exports = {generateFixedSizeUnsortedList, generateUnsortedList};



