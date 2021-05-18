
# Helper File to quickly generate randomize sorted & unsorted lists of integers

import random

#  =================== Unsorted List Functions ===================

# Handles the creation of the unsorted list 
def build_unsorted_list(list_size, upper_bound_for_random_number):
    unsorted_list = [None] * list_size

    for idx, val in enumerate(unsorted_list):
        unsorted_list[idx] = random.randint(0, upper_bound_for_random_number)
    return unsorted_list

    
#  Returns a fixed-size unsortted list of random numbers, between the range of [0 <= 1000]
#  The length of the list will be of size: 20
def generate_fixed_size_unsorted_list():
    return build_unsorted_list(20, 1000)

    
# Returns an unsortted list of random numbers, between the range of [0 <= upperBoundForRandomNumber]
# The length of the list will be of size: <listSize> 
def generate_unsorted_list(list_size, upper_bound_for_random_number):
    return build_unsorted_list(list_size, upper_bound_for_random_number)


#  =================== Sorted List Functions ===================

#  Handles the creation of the sorted list
#  Note: so far the list is static, and will always have the same values depending on its size,
#        need to add some randomness into the list
def build_sorted_list(list_size):
    sorted_list = [None] * list_size
    adder       = 1

    for idx, val in enumerate(sorted_list):
        if (idx == 0) :
            sorted_list[idx] = idx
        else :
            sorted_list[idx] = sorted_list[idx - 1] + adder

        if (adder % 100 == 0) :
            adder = 1
            
        adder += 1
        #  Note: Uses later when I have a driver to help run the searches of randomize sorted list and take user input,
        #        this would make it easier to dynamically create a list & have the users perform binary search on the list
        #        so they can see first hand if it works, instead of having a hard-coded value
        #  if (i == 0) :
        #      sorted_list[i] = i + random.randint(upper_bound_for_random_number)
        #  else :
        #      sorted_list[i] = sorted_list[i - 1] + random.randint(upper_bound_for_random_number)
    return sorted_list


#  Returns a fixed-size sorted list of pseudo random numbers
#  The length of the list will be of size: 20
def generate_fixed_size_sorted_list():
    return build_sorted_list(20)


#  Returns a sortted list of pseudo random numbers
#  The length of the list will be of size: <listSize> 
def generate_sorted_list(list_size):
    return build_sorted_list(list_size)
