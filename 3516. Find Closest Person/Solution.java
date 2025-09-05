class Solution {
    public int findClosest(int x, int y, int z) {
        return Math.abs(z-x)<=Math.abs(z-y)?(Math.abs(z-x)==Math.abs(z-y)?0:1):2;
    }
}
