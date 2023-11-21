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

## 퀵 정렬(Quick Sort)

## 힙 정렬(Heap Sort)



**시간복잡도**

|   평균   |   최선   |   최악   |
| :------: | :------: | :------: |
| Θ() | Ω() | O() |







