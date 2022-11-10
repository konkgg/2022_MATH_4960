import random

start = 2
end = 31
nums = list(range(start, end, 2))

for i in range(len(nums)-1, 1, -1):
    j = random.randint(0, i)
    temp = nums[i]
    nums[i] = nums[j]
    nums[j] = temp

print(nums)    