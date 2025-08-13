from collections import Counter
from typing import List

class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        # Create a Counter (hash map) for the first array
        counts = Counter(nums1)
        intersection = []
        
        # Iterate through the second array
        for num in nums2:
            # If the number is in the counter and the count is greater than 0
            if counts[num] > 0:
                intersection.append(num)
                # Decrement the count in the counter
                counts[num] -= 1
        
        return intersection

# Example usage
if __name__ == "__main__":
    nums1 = [1, 2, 2, 1]
    nums2 = [2, 2]
    sol = Solution()
    result = sol.intersect(nums1, nums2)
    print(result)  # Output: [2, 2]
