class Solution {

    class Pair {
        int val;
        int idx;

        Pair(int v, int i) {
            val = v;
            idx = i;
        }
    }

    int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];

        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> ans = new ArrayList<>();
        for (int x : count)
            ans.add(x);

        return ans;
    }

    private void mergeSort(Pair[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private void merge(Pair[] arr, int l, int mid, int r) {

        Pair[] temp = new Pair[r - l + 1];

        int i = l;
        int j = mid + 1;
        int k = 0;

        int rightCount = 0;

        while (i <= mid && j <= r) {

            if (arr[j].val < arr[i].val) {
                temp[k++] = arr[j++];
                rightCount++;
            } else {
                count[arr[i].idx] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            count[arr[i].idx] += rightCount;
            temp[k++] = arr[i++];
        }

        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            arr[l + p] = temp[p];
        }
    }
}