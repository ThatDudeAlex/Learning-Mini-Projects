// ========= Imports =============
const {isSorted, printHeaders, printList} = require("../Helper/ListUtils")
const {generateFixedSizeUnsortedList}     = require("../Helper/ListGenerator")

/* 
    Radix Sort

    Note: The runtime of radix sort is O(n∙k), where n is the number of elements to be sorted, and k is the
    number of digits in the maximum of all those element. If we call that max element m, then k ≈ log<sub10>m.
    Thus, we can write radix sort's runtime more precisely as O(n log m).

    Time Complexity
    ---------------------
    Worst   : O(nk) = O(n log m)

    Average : O(nk) = O(n log m)
    
    Best    : O(nk) = O(n log m)
*/
performRadixSort = (list) => {
    const radixBuckets      = createRadixBuckets()
    let largestNumberInList = getLargestNumberInList(list)

    for (let power = 1; (largestNumberInList / power) > 0; power *= 10) {
        let listIndex = 0

        for (let i = 0; i < list.length; i++) {
            let leastSignificantDigit = Math.floor((list[i] / power) % 10)
            radixBuckets[leastSignificantDigit].push(list[i])
        }

        for (let i = 0; i < radixBuckets.length; i++) {
            while (radixBuckets[i].length > 0) {
                list[listIndex++] = radixBuckets[i].shift()
            }
        }
    }

    return list
}

createRadixBuckets = () => {
    const radixBuckets = new Array(10)

    for(let i = 0; i < radixBuckets.length; i++)
        radixBuckets[i] = new Array()
    return radixBuckets
}

getLargestNumberInList = (list) => {
    let largestNumber = list[0]

    for (let i = 1; i < list.length; i++)
        if (list[i] > largestNumber)
            largestNumber = list[i]
    return largestNumber
}

main = () => {
    list = generateFixedSizeUnsortedList()

    printHeaders("Before Radix Sort")
    printList(list)

    printHeaders("After Radix Sort")
    printList(performRadixSort(list))

    
    if (isSorted(list))
        printHeaders("HOORAY!")
    else
        printHeaders("Fail :(")
}

main()