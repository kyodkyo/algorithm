# 정렬(Sorting)

---




## 거품 정렬(Bubble Sort)
서로 인접한 두 원소의 대소를 비교하고, 조건에 맞지 않다면 자리를 교환하며 정렬




##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(n²) | Ω(n²) | O(n²) |




##### #Pseudo code
```
function bubble_sort(arr[])
    set len = arr.size
    
    for i = 0 ... i < len - 1
        for j = 0 ... j < len - 1 - i
            if arr[j] > arr[j + 1]
                set tmp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = tmp
      
    return arr
```






## 선택 정렬(Selection Sort)
해당 순서에 원소를 넣을 위치는 이미 정해져 있고, 어떤 원소를 넣을지 선택하는 정렬


1. 전체 값 중 가장 작은 값을 찾는다.
2. 그 값을 맨 앞의 값과 교체한다.
3. 첫번째 값을 제외한 나머지 배열을 같은 방법으로 바꿔준다.




##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(n²) | Ω(n²) | O(n²) |




##### #Pseudo code
```
function selectionSotr(arr)
    set size = arr.size
  
    for i = 0 ... i < size - 1
        set minumum = i
        for k = i + 1 ... k < size
            if arr[k] < arr[minimum]
                minimum = k
        set temp = arr[i]
        arr[i] = arr[minimum]
        arr[minimum] = temp
  
    return arr
```






## 삽입 정렬(Insertion Sort)
앞에 있는 모든 원소가 정렬이 되어 있다는 가정 하에서 현재 원소의 위치를 적절하게 집어넣는 정렬




##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(n²) | Ω(n) | O(n²) |




##### #Pseudo code
```
function insertionSort(arr[])
    set size = arr.size
  
    for i = 1 ... i < size
        set j = i - 1
        set key = arr[i]
        while j >= 0 && arr[j] > key
            arr[j + 1] = arr[j]
            j--
        arr[j + 1] = key
    return arr
```






## 기수 정렬(Radix Sort)
맨 뒤에 있는 자릿수 부터 해당 자리수를 기준으로 정렬한 뒤, 점점 앞으로 이동하며 각 자리수를 기준으로 정렬하다가 최종적으로 가장 높은 자리수를 기준으로 정렬
(다른 정렬들과 달리 값을 비교하지 않고 정렬하는 알고리즘이다.)




##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(n) | Ω(n) | O(n) |




##### #Pseudo code
```
function radixSort(arr, k)
    for current = k - 1 ... current >= 0:
        set radix_arr = [10][]
        for i = 0 ... i < arr.size
            set digit = (current)th digit of arr[i]
            radix_arr[digit].append(arr[i])
    
        set temp = []
        for i = 0 ... i < 10
            for j = 0 ... j < radix_arr[i].size
                temp.append(radix_arr[i][j])
      
        arr = temp
  
    return arr
```






## 병합 정렬(Merge Sort)
분할 정복(divide and conquer) 방법 을 통해 주어진 배열을 정렬

1. 중간값을 기준으로 두개의 배열로 나눈다.
2. 나뉜 배열을 각각 정렬하되, 1을 반복하여 배열의 원소개수가 1이 될때까지 계속한다.
3. 정렬된 두 배열을 다시 병합한다.


##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(nlogn) | Ω(nlogn) | O(nlogn) |




##### #Pseudo code
```
function mergeSort(arr[], left, right)
  if left < right
    set mid = (low + high) / 2
    mergeSort(arr, left, mid) // 왼쪽 병합정렬
    mergeSort(arr, mid+1, right) // 오른쪽 병합정렬
    merge(arr, left, mid, right) // 병합

set result = []

function merge(arr[], left, mid, right)
      set i = left, j = mid + 1
    
      set k = left
      while i <= mid && j <= right
        if arr[i] <= arr[j]
          result[k] = arr[i]
          k += 1; i += 1
        else
          result[k] = arr[j]
          k += 1; j += 1
  
      while i <= mid
        result[k] = arr[i]
        k += 1; i += 1
    
      while j <= right
        result[k] = arr[j]
        k += 1; j += 1
  
      for k = left ... k <= right
        arr[k] = result[k]
      
      return arr
```






 

## 퀵 정렬(Quick Sort)
분할 정복(divide and conquer) 방법 을 통해 주어진 배열을 정렬

1. 배열 가운데서 하나의 원소(pivot)를 선택한다.
2. 피벗 앞에는 피벗보다 값이 작은 모든 원소들이 오고, 피벗 뒤에는 피벗보다 값이 큰 모든 원소들이 오도록 배열을 둘로 나눈다.
3. 분할된 두 개의 작은 배열에 대해 재귀(Recursion)적으로 이 과정을 반복한다.

##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(nlogn) | Ω(nlogn) | O(n²) |




##### #Pseudo code
```
function quickSort(arr[], left, right)
  if left < right
    pos = partition(arr, left, right)
    
    quickSort(arr, left, pos - 1)
    quickSort(arr, pos + 1, right)

function partition(arr[], left, right)
  set pivot = selectPivot(arr, left, right)
  set i = left - 1
  
  for j = left ... j <= right - 1
    if arr[j] < pivot
      i += 1
      swap (arr[i], arr[j])
      
  swap (arr[i + 1], arr[right])
  return i + 1  
```





 


## 힙 정렬(Heap Sort)
완전 이진 트리를 기본으로 하는 힙(Heap) 자료구조를 기반으로한 정렬 방식




##### #시간복잡도

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ(nlogn) | Ω(nlogn) | O(nlogn) |




##### #Pseudo code
```
function heapSort(arr[], n)
  for i = n / 2 ... i >= 1
    heapify(arr, n, i)

  for i = n ... i > 1
    swap(arr[1], arr[i])
    heap(arr, i, 1)

function heap(arr[], n, i)
  set largest = i
  set l = i * 2
  set r = i * 2 + 1

  if l <= n && arr[l] > arr[largest]
    largest = l

  if r <= n && arr[r] > arr[largest]
    largest = r

  if largest != i
    swap(arr[i], arr[largest])
    heap(arr, n, largest)
```


