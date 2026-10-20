
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        int size = 1 << n;

        for (int i = 0; i < size; i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }
}
