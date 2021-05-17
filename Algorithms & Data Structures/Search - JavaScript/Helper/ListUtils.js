

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

module.exports = {printList, printHeaders};
