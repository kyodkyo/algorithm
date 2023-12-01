package org.example.BinarySearch;

/**
 * target  초과의 값이 처음으로 나오는 위치 찾기
 *
 * function upper_bound(arr, target)
 *   set left = 0
 *   set right = arr.size - 1
 *   set min_idx = arr.size
 *   while left <= right
 *     set mid = (left + right) / 2
 *     if arr[mid] > target
 *       right = mid - 1
 *       min_idx = min(min_idx, mid)
 *     else
 *       left = mid + 1
 *
 *   return min_idx
 */
public class UpperBound {
}
