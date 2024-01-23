class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> subsets = new ArrayList<>();
        generatedSubsets(0, candidates, new ArrayList<>(), subsets, target);
        return subsets;
    }

    void generatedSubsets(int start, int[] nums, List<Integer> current, List<List<Integer>> subsets, int target) {
        if (target == 0) {
            subsets.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target - nums[i] < 0) {
                break;
            }

            current.add(nums[i]);
            generatedSubsets(i + 1, nums, current, subsets, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }
}