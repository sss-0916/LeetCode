class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] temp = new int[len];
        
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        
        while (i < len1) {
            temp[k++] = nums1[i++];
        }
        while (j < len2) {
            temp[k++] = nums2[j++];
        }
        
        if (len == 1) {
            return temp[0];
        } 
        if (len == 2) {
            return (temp[0] + temp[1]) / 2.0;
        }
        
        if (len % 2 == 0) {
            return ((temp[len / 2 - 1] + temp[len / 2]) / 2.0);
        }
        return temp[len / 2];
    }
}