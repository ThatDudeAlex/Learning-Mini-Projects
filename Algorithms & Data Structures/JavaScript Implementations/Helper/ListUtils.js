
const swap = (list, index1, index2) => {
    let placeHolder = list[index2]
    list[index2]    = list[index1]
    list[index1]    = placeHolder
}

const isSorted = (list) => {
    for (let i = 1; i < list.length; i++)
        if (list[i - 1] > list[i])
            return false
    return true
}

/* 
    -------------------------------------------------------------------------------------------------------------------------
                                    Print List Methods
    -------------------------------------------------------------------------------------------------------------------------
*/

const printList = (list) => displayList(list)

const displayList = (list) => {
    const width      = 10
    let   listOutput = ""

    for (let i = 0, j = 0; i < list.length; i++, j++)
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

module.exports = {printList, printHeaders, isSorted, swap};
