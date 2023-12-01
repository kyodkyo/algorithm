package org.example.BinarySearch;

/**
 * target 이상의 값이 처음으로 나오는 위치 찾기
 * => 같은 target값이 여러 개인 경우, 가장 마지막 값을 찾는것
 *
 *
 * function lower_bound(arr, target)
 *   set left = 0
 *   set right = arr.size - 1
 *   set min_idx = arr.size
 *   while left <= right
 *     set mid = (left + right) / 2
 *     if arr[mid] >= target
 *       right = mid - 1
 *       min_idx = min(min_idx, mid)
 *     else
 *       left = mid + 1
 *
 *   return min_idx
 *
 *값
 */
public class LowerBound {
}
