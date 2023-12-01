package org.example.BinarySearch;

/**
 * target 이하의 값이 마지막으로 나오는 위치 찾기
 *
 * function custom_bound(arr, target)
 *   set left = 0
 *   set right = arr.size - 1
 *   set max_idx = -1
 *   while left <= right
 *     set mid = (left + right) / 2
 *     if arr[mid] <= target
 *       left = mid + 1
 *       max_idx = max(max_idx, mid)
 *     else
 *       right = mid - 1
 *
 *   return max_idx
 */
public class CustomBound {
}
