
const swap = (list, index1, index2) => {
    let placeHolder = list[index2]
    list[index2]    = list[index1]
    list[index1]    = placeHolder
}

const isSorted = (list) => {
    for (let i = 1; i < list.length; i++)
        if (list[i - 1] > list[i])
            return false;
    return true;
}

/* 
    -------------------------------------------------------------------------------------------------------------------------
                                    Print List Methods
    -------------------------------------------------------------------------------------------------------------------------
*/

const printList = (list) => displayList(list, 0, list.length)

const printListBetweenBounds = (list, lowerBound, upperBound) => displayList(list, lowerBound, upperBound)

const displayList = (list, lowerBound, upperBound) => {
    const width      = 10
    let   listOutput = ""

    for (let i = lowerBound, j = 0; i < upperBound; i++, j++)
        if ((i !== 0) && (j % 10 === 0))
            listOutput += "\n".concat(`${list[i]}${addWidthPadding(width)}`.slice(0,width))
        else 
            listOutput += `${list[i]}${addWidthPadding(width)}`.slice(0,width)
    
    console.log(`${listOutput}\n`)
}

const addWidthPadding = (width) => {
    let padding = ""

    for (let i = 0; i < width; i++)
        padding += " "
    return padding
}

/* 
    -------------------------------------------------------------------------------------------------------------------------
                                    Header Methods
    -------------------------------------------------------------------------------------------------------------------------
*/

const printHeaders = (headerMsg) => {
    console.log("%s\n|  %s  |\n%s\n", printHeaderBorders(headerMsg), headerMsg, printHeaderBorders(headerMsg))
}

const printHeaderBorders = (headerMsg) => {
    let borders = ""

    for (let i = 0; i < headerMsg.length + 6; i++)
        borders += "="
    return borders.toString()
}

module.exports = {swap, isSorted, printList, printListBetweenBounds, printHeaders};
