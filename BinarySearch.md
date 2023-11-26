# 이진탐색 (Binary Search)
찾아야 하는 수의 범위 중 가운데의 값과 찾고자 하는 값을 비교하여 대소관계에 따라 특정 구간으로 이동하는 것을 반복하는 것


단, 정렬이 되어 있어야 순차탐색보다 유리하다.




#### >> 시간복잡도 : O(log n)


#### >> Pseudo code
```
function BinarySearch(arr, target)
  set left = 0
  set right = arr.size - 1
  while left <= right
    set mid = (left + right) / 2
    if arr[mid] == target
      return mid

    if arr[mid] > target
      right = mid - 1
    else
      left = mid + 1
      
  return -1
```


#### >> Java
```
public static int solution(int[] arr, int target) {

    Arrays.sort(arr);
	
    int start = 0;
    int end = arr.length - 1;
    int mid = 0;

    while (start <= end) {
        mid = (start + end) / 2;
        if (target == arr[mid]) {
            return mid;
        }else if (arr[mid] < target) {
            start = mid + 1;
        }else if (target < arr[mid]) {
            end = mid - 1;
        }
    }
   return -1;
}
```

---
