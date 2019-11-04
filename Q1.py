class Solution: #Two sum
    def twoSum(self, nums, target):
        hash_map={}
        for index,num in enumerate(nums):
            hash_map[index] = target-num
#O(n^2)
class Solution2:
    def twoSum(self, nums, target): #return -- index
        hash_map={}
        for index,num in enumerate(nums):
            if (target - num) in hash_map:
                return [hash_map[target - num],index]
            hash_map[num] = index
#O(n)

abc = Solution2()
print (abc.twoSum([1,2,3],4))