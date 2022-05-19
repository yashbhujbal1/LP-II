def selection_sort(arr):
 for i in range(0, len(arr) - 1):                  # Traverse through all array elements
    smallest = i                                   # Find the minimum element in remaining unsorted array
    for j in range(i + 1, len(arr)):
        if arr[j] < arr[smallest]:                 # select the smallest element in each loop
            smallest = j
    arr[i], arr[smallest] = arr[smallest], arr[i];      # put smallest at the correct position  #Swap the found minimum element with the first element
arr = input('Enter the Elements of Array : ').split()          #split() - Return a list of the words in the string, using sep as the delimiter string.
arr = [int(x) for x in arr]
selection_sort(arr)
print('Sorted Array : ', end='')
print(arr)

# Time Complexity - O(n^2)