package src;

import java.util.ArrayList;
import java.util.List;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carryOver = 0;
            int data = 0;
            boolean l1LeftOver = false, l2RightOver = false;
            ListNode temp, head = null, result = null;
            while (l1 != null && l2 != null) {
                if (carryOver + l1.val + l2.val >= 10) {
                    data = carryOver + l1.val + l2.val - 10;
                    temp = new ListNode(data);
                    carryOver = 1;
                } else {
                    temp = new ListNode(carryOver + l1.val + l2.val);
                }
                if (head == null) {
                    head = temp;
                    result = temp;
                } else {
                    result.next = temp;
                    result = result.next;
                }

                l1 = l1.next;
                l2 = l2.next;
            }
            while (l1 != null) {
                l1LeftOver = true;
                int data1 = 0;
                if (carryOver + l1.val >= 10) {
                    data1 = carryOver + l1.val - 10;
                    temp = new ListNode(data1);
                    carryOver = 1;
                } else {
                    temp = new ListNode(carryOver + l1.val);
                }
                result.next = temp;
                result = result.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                l2RightOver = true;
                int data2 = 0;
                if (carryOver + l2.val >= 10) {
                    data2 = carryOver + l2.val - 10;
                    temp = new ListNode(data2);
                    carryOver = 1;
                } else {
                    temp = new ListNode(carryOver + l2.val);
                }
                result.next = temp;
                result = result.next;
                l2 = l2.next;
            }
            if ((l1LeftOver || l2RightOver) && carryOver == 1) {
                result.next = temp = new ListNode(carryOver);
            }


            return head;
        }

        public static ListNode deleteMiddle(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            if (head != null && head.next != null && head.next.next == null) {
                return head;
            }
            int count = 0;
            int match = 0;
            ListNode temp = head;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            count = count / 2;
            ListNode curr = head, prev = null;
            while (curr != null) {
                if (match == count) {
                    prev.next = curr.next;
                    return head;
                }
                prev = curr;
                curr = curr.next;
                match++;

            }
            return head;

        }

        public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode temp1 = list1, temp2 = list2, result = null, tempResult = null;
            while (temp1 != null && temp2 != null) {
                if (temp1.val >= temp2.val) {
                    if (result == null) {
                        result = new ListNode(temp2.val);
                        tempResult = result;

                        temp2 = temp2.next;
                    } else {
                        tempResult.next = new ListNode(temp2.val);
                        tempResult = tempResult.next;
                        temp2 = temp2.next;
                    }

                } else {

                    if (result == null) {
                        result = new ListNode(temp1.val);
                        tempResult = result;

                        temp1 = temp1.next;
                    } else {
                        tempResult.next = new ListNode(temp1.val);
                        tempResult = tempResult.next;
                        temp1 = temp1.next;
                    }

                }

            }

            if (temp1 != null && tempResult != null) {
                if (tempResult == null) {
                    result = temp1;
                    return result;
                } else {
                    tempResult.next = temp1;
                }

            }

            if (temp2 != null && tempResult != null) {
                if (tempResult == null) {
                    result = temp2;
                    return result;
                } else {
                    tempResult.next = temp2;
                }
            }
            return result;
        }

        public static ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode temp = head;
            ListNode nextTemp = temp.next;

            while (temp != null && nextTemp != null) {

                if (temp.val == nextTemp.val) {
                    nextTemp = nextTemp.next;
                } else {
                    temp.next = nextTemp;
                    temp = temp.next;
                }


            }
            if (temp.next != null && temp.val == temp.next.val) {
                temp.next = null;
            }
            return head;
        }

        public static void merge(int[] nums1, int m, int[] nums2, int n) {

            if (m == 0) {
                n = n - 1;
                while (n >= 0) {
                    nums1[n] = nums2[n--];
                }
            }

            m = m - 1;
            n = n - 1;
            int startIndexNums1 = nums1.length - 1;
            while (m >= 0 && n >= 0) {
                if (nums1[m] <= nums2[n]) {
                    nums1[startIndexNums1--] = nums2[n--];
                } else {
                    nums1[startIndexNums1--] = nums1[m--];
                }
            }

            if (n == 0) {
                nums1[0] = nums2[0];
            }

        }

        public static int countMinStepsToOne(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = -1;
            }
            return countMinStepsToOneIterative(n, dp);
        }

        public static int countMinStepsToOneIterative(int n, int[] dp) {
            if (n <= 1) {
                return 0;
            }
            int ans1 = 0;
            if (dp[n] == -1) {
                ans1 = countMinStepsToOne(n - 1);
                dp[n] = ans1;
            }

            int ans2 = Integer.MAX_VALUE;
            int ans3 = Integer.MAX_VALUE;


            if (n % 2 == 0) {
                if (dp[n / 2] == -1) {
                    ans3 = countMinStepsToOne(n / 2);
                    dp[n / 2] = ans3;
                }

            }

            if (n % 3 == 0) {
                if (dp[n / 3] == -1) {
                    ans2 = countMinStepsToOne(n / 3);
                    dp[n / 3] = ans2;
                }

            }


            return Math.min(ans1, Math.min(ans2, ans3)) + 1;
        }

        public static List<List<Integer>> generate(int numRows) {
            List<Integer> result, old = null;
            List<List<Integer>> results = new ArrayList<>();

            for (int i = 0; i < numRows; i++) {
                result = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || i == j) {
                        result.add(1);
                    } else {
                        result.add(old.get(j - 1) + old.get(j));
                    }

                }
                old = result;
                results.add(result);

            }
            return results;
        }

        public List<Integer> getRow(int rowIndex) {
            List<Integer> result = null, old = null;
            for (int i = 0; i < rowIndex; i++) {
                result = new ArrayList<>();

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        result.add(1);
                    } else {
                        result.add(old.get(j - 1) + old.get(j));
                    }
                }
                old = result;
            }
            return result;
        }

        public static void printEachRow(int num) {

            int[][] result = new int[num][num];
            for (int i = 0; i < num; i++) {

                for (int j = 0; j <= i; j++) {
                    if (j == 0 || i == j) {
                        result[i][j] = 1;
                        System.out.print(result[i][j]);
                    } else {
                        result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                    }

                }
                System.out.println();

            }
        }






            public static void main(String[] args){

                countMinStepsToOne(5);
                merge(new int[]{2, 0}, 1, new int[]{1}, 1);

                ListNode node1 = new ListNode(1);
                ListNode node2 = new ListNode(1);
                ListNode node3 = new ListNode(2);
                node1.next = node2;
                node2.next = node3;
                node3.next = null;
                //  deleteDuplicates(node1);
//[1,1,2,3,3]


                ListNode node10 = new ListNode(1);
                ListNode node20 = new ListNode(1);
                ListNode node30 = new ListNode(2);
                ListNode node40 = new ListNode(3);
                ListNode node50 = new ListNode(3);
                node10.next = node20;
                node20.next = node30;
                node30.next = node40;
                node40.next = node50;
                node50.next = null;

                // deleteDuplicates(node10);
                //  mergeTwoLists(null,node10);
                //  deleteMiddle(node1,node10);
//[9,9,9,9,9,9,9], l2 = [9,9,9,9]
                ListNode node11 = new ListNode(9);
                ListNode node22 = new ListNode(9);
                ListNode node33 = new ListNode(9);
                ListNode node44 = new ListNode(9);
                ListNode node55 = new ListNode(9);
                ListNode node66 = new ListNode(9);
                node11.next = node22;
                node22.next = node33;
                node33.next = node44;
                node44.next = node55;
                node55.next = node66;
                node66.next = null;

                ListNode n10 = new ListNode(9);
                ListNode n20 = new ListNode(9);
                ListNode n30 = new ListNode(9);
                ListNode n40 = new ListNode(9);
                n10.next = n20;
                n20.next = n30;
                n30.next = n40;
                n40.next = null;

                int[][] input = {
                        {1, 1, 1},
                        {1, 1, 0},
                        {0, 1, 1}
                };


                // addTwoNumbers(node11,n10);
            }
        }

