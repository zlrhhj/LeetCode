public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int p = 0;
        int mid = (m + n) / 2;
        int p1 = 0;
        int p2 = 0;
        int pre = 0;
        int current = 0;
        while( p1 < m && p2 < n) {
            if(p == mid) {
                current = Math.min(nums1[p1], nums2[p2]);
                return (m + n) % 2 == 1 ? current :(double)(current + pre) / 2;
            }
            if(nums1[p1] < nums2[p2]) {
                pre = nums1[p1++];

            } else {
                pre = nums2[p2++];
            }
            p++;
        }
        while(p1 < m) {
            if(p == mid) {
                current = nums1[p1];
                return (m + n) % 2 == 1 ? current :(double)(current + pre) / 2;
            } else {
                p1++;
                p++;
            }
        }
        while(p2 < n) {
            if(p == mid) {
                current = nums2[p2];
                return (m + n) % 2 == 1 ? current :(double)(current + pre) / 2;
            } else {
                p2++;
                p++;
            }
        }
        return  (m + n) % 2 == 1 ? current :(double)(current + pre) / 2;
    }
}
