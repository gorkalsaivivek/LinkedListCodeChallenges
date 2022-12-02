package src;

import java.util.*;

public class Coding {




    public static int findMaxSquareWitAllZeros(int[][] k){

        int arr[][]=new int [k.length][k[0].length];


        for(int i=0;i<arr[0].length;i++){
            if(k[0][i] == 0){
                arr[0][i] = 1;
            }else{
                arr[0][i] = 0;
            }
        }

        for(int i=0;i<arr.length;i++){
            if(k[i][0] == 0){
                arr[i][0] = 1;
            }else{
                arr[i][0] = 0;
            }
        }


        for(int i=1;i<arr.length;i++){
            for(int j=1;j<arr[0].length;j++){
                if(k[i][j] != 0){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1 + Math.min(arr[i-1][j-1] ,Math.min(arr[i][j-1],arr[i-1][j]));
                }

            }
        }

        int maximum = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j] > maximum){
                    maximum = arr[i][j];
                }
            }
        }

        return maximum;
    }

    public void booStore() {
        int price = 0;
        Scanner s =new Scanner(System.in);
        int books=s.nextInt();
        int[] bookPrices=new int[books];
        for(int i=0;i<bookPrices.length;i++){
            bookPrices[i]=s.nextInt();
        }
        if(books==1){
            System.out.println(bookPrices[0]);
            return;
        }
        if(books==2){
            System.out.println(bookPrices[0]+ bookPrices[1]);
            return ;
        }

        for (int i=0; i < (books/3)*3; i+=3) {
            price+=bookPrices[i]+bookPrices[i+1];
        }
        for (int i=(books/3)*3; i < books; ++i) {
            price+=bookPrices[i];
        }
        System.out.println(price);

    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
            for(int i=0;i< queries.length;i++){

            }
            return null;
    }
    public static int[] secondGreaterElement(int[] nums) {
        ArrayList<HashMap<String, Integer>> s = new  ArrayList<HashMap<String, Integer> >();
int count=0;
        // iterating over the array
        for (int i = 0; i < nums.length; i++) {
            int trackI=i;
            while (s.size() > 0
                    && s.get(s.size() - 1).get("value") < nums[i]) {
                // updating the array as per the stack top
                count++;
                if(count==2){
                    HashMap<String, Integer> d = s.get(s.size() - 1);
                    s.remove(s.size() - 1);
                    nums[d.get("ind")] = nums[i];
                    count=0;
                    i=trackI;
                    break;
                }
                i++;

            }
           if(s.isEmpty()){
               HashMap<String, Integer> e = new HashMap<String, Integer>();

               e.put("value", nums[i]);
               e.put("ind", i);
               s.add(e);
           }

        }

        // updating the array as per the stack top
        while (s.size() > 0) {
            HashMap<String, Integer> d = s.get(s.size() - 1);
            s.remove(s.size() - 1);
            nums[d.get("ind")] = -1;
        }
        return nums;
    }

    public int averageValue(int[] nums) {
        int sum=0,count=0;
        for(int i=0;i< nums.length;i++){
            if(nums[i]%2==0 && nums[i]/3==0){
                count++;
                sum+=nums[i];
            }
        }

        return sum/count;

    }
    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<List<String>> results= new ArrayList<>();
        List<String> result;

        HashMap<String,String> creatorIds=new HashMap<>();
        HashMap<String,Integer> creatorsViews=new HashMap<>();
        for(int i=0;i< creators.length;i++){

            if(creatorIds.containsKey(creators[i]) && creatorsViews.get(creators[i])>=views[i]){
               if( creatorIds.get(creators[i]).compareTo(ids[i])<0){
                   creatorIds.put(creators[i],creatorIds.get(creators[i]));
                }
               else {
                   creatorIds.put(creators[i],ids[i]);
               }

            }
            else {
                creatorIds.put(creators[i],ids[i]);
            }

            if(creatorsViews.containsKey(creators[i])){
                creatorsViews.put(creators[i],creatorsViews.get(creators[i])+views[i] );

            }
            else {
                creatorsViews.put(creators[i],views[i]);
            }


        }
        int maxView=Collections.max(creatorsViews.values());
        for (Map.Entry<String,Integer> mapElement : creatorsViews.entrySet()) {
            result=new ArrayList<>();
            String key = mapElement.getKey();
            int value = (mapElement.getValue());
            if(value==maxView){
                result.add(key);
                result.add(creatorIds.get(key));
                results.add(result);
            }



        }


return results;
    }

    public static int secondLargest(int[] nums){

        int value=0;
        int second=-1;
        for(int i=1;i< nums.length;i++){
            if(nums[i]>=nums[value]){
                second=i-1;
                value=i;
            }
            else {
                if(second!=-1 && nums[second]<nums[i]){
                    second=i;
                }
                else if(second==-1){
                    second=i;
                }

            }

        }
        return nums[second];
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median1,median2;
                if(nums1.length>1){
                    int mid1=nums1.length/2;
                    if(mid1%2!=0){
                        median1=(double)(nums1[mid1-1]+nums1[mid1])/2;
                    }
                    else {
                        median1=(double)nums1[mid1]/2;
                    }


                }

                else {
                    if(nums1.length==0){
                        median1=(double)0;
                    }
                    else {
                        median1=(double)nums1[0];
                    }

                }

        if(nums2.length>1){
            int mid2=nums2.length/2;
            if(mid2%2!=0){
                median2=(double)(nums2[mid2-1]+nums2[mid2])/2;
            }
            else {
                median2=(double)nums2[mid2]/2;
            }


        }

        else {
            if(nums2.length==0){
                median2=(double)0;
            }
            else {
                median2=(double)nums2[0];
            }

        }
        if(median1==0){
            return median2;
        }
        else if (median2==0){
            return median1;
        }
        return (median1+median2)/2;


    }

    public int maxProfit(int[] prices) {
            int leastNum=Integer.MAX_VALUE;
            int result=0;
            for(int i=0;i<prices.length;i++){
                if(prices[i]<leastNum){
                    leastNum=prices[i];
                }

                if(result<prices[i]-leastNum){
                    result=prices[i]-leastNum;
                }
            }
            return result;
    }

    public static boolean isPalindrome(String s) {

        String result=s.replaceAll(
                "[^a-zA-Z0-9]", "").toLowerCase();

        if(result.isEmpty()) {
            return true;
        }

        int startIndex=0,endIndex=result.length()-1;
            while(startIndex<endIndex){
                if(result.charAt(startIndex)!=result.charAt(endIndex)){
                    return false;
                }
                startIndex++;
                endIndex--;
            }
            if(result.charAt(startIndex)!=result.charAt(endIndex)){
                return false;
            }
        return true;
    }

    public static int singleNumber(int[] nums) {
        int[] result=new int[nums.length];

            for(int i=1;i<nums.length;i++){
                result[nums[i]]=nums[i]+1;
            }

            for(int i=0;i<nums.length;i++){
                if(result[nums[i]]==1){
                    return nums[i];
                }
            }
            return 1;
    }



    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null){
            return false;
        }
        ListNode temp=head;
        Set<ListNode> result=new HashSet<>();

        while(temp!=null){
            if(result.contains(temp)){
                return false;
            }
            else {
                result.add(temp);
            }

            temp=temp.next;
        }
return true;

    }

    public static int majorityElement(int[] nums) {
    Arrays.sort(nums);
    if(nums.length==1){
        return nums[0];
    }
    int freq=1,result = 0, num=0;
    for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1]){
            freq++;
            num=nums[i-1];
        }
        else {
            if(result<freq){
               result=freq;
                num = nums[i - 1];
            }

           freq=1;
        }
    }
    if(freq>nums.length/2 || result>nums.length/2){
        return num;
    }

return num;
    }

    public static boolean isHappy(int n) {

        HashSet<Integer> result=new HashSet<>();


        while(!result.contains(n)){
            result.add(n);
            int powValue=0;
            while(n!=0){
                int newNum=n%10;
                powValue+=newNum * newNum;
                n=n/10;
            }
            n=powValue;


        }
        if(n==1){
            return true;
        }
    return false;

    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode temp=head, prev=head;

        while(temp.val==val){

            head=temp.next;
            temp=temp.next;
        }
        while(temp!=null){
            if(temp.val==val){
                prev.next=temp.next;
            }
            prev=temp;
            temp=temp.next;

        }
        return head;
    }
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }

        ListNode temp=head;
        Stack<ListNode> stack=new Stack<>();
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        ListNode newHead=null,tempHead=null;
        while(!stack.isEmpty()){
            if(newHead==null){
                newHead=stack.pop();
                tempHead=newHead;
            }
            else {
                tempHead.next=stack.pop();
                tempHead=tempHead.next;
            }
        }
        tempHead.next=null;
        return newHead;
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(!set.contains(num)){
                set.add(num);
            }
            else {
                return true;
            }
        }
        return false;

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();


        for(int j=0;j<nums.length;j++){
            if(hashMap.containsKey(nums[j])){
                int startIndex=hashMap.get(nums[j]);
                if(Math.abs(startIndex - j) <= k){
                    return true;
                }

            }
            hashMap.put(nums[j],j);

        }

    return false;
    }

    public static List<String> summaryRanges(int[] nums) {
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1 ){
            count++;
            }
            else {
                if(count>0){
                    System.out.println("Range is"+ nums[i-1-count] + "->" + nums[i-1]);
                    count=0;
                }
                else {
                    System.out.println("Single Number " + nums[i-1]);
                    count=0;
                }

            }

        }

        return null;
    }

    public static boolean isPowerOfTwo(int n) {

        if(n==1){
            return true;
        }

        while(n>1){
            if(n%2==0){
                n=n/2;
            }
            else {
                return false;
            }
        }
        return true;

    }

    public static int maxSum(int[] nums, int k){
        int mainSum=0;

        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < k; i++)
        {
            int sum=0;
            int j=i;
            while (j < k+i && !s.contains(nums[j]))
            {
                sum+=nums[j];
                s.add(nums[j]);
                j++;
            }
            s.clear();
            mainSum=Math.max(mainSum,sum);

            // Remove arr[i] as we pick new starting point
            // from next
        }
        return mainSum;
    }

    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int[] result=new int[nums.length];
        Arrays.fill(result,0);
        int startIndex=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result[startIndex]=nums[i];
                startIndex++;
            }
        }
        return result;
    }
    //[1,1,1,7,8,9]
    //3

    public static long maximumSubarraySum(int[] nums, int k) {
        int ctg = 0;
        long ans = 0;
        int n = nums.length;
        long[] sums = new long[n+1];
        for (int i = 1; i <= n; ++i) {
            sums[i] = sums[i-1]+nums[i-1];
        }
        int[] cts = new int[100001];
        for (int i = 0; i < k; ++i) {
            cts[nums[i]]++;
            if (cts[nums[i]]==2)
                ++ctg;
        }
        if (ctg==0) {
            ans = sums[k];
        }
        for (int i = k; i < n; ++i) {
            cts[nums[i-k]]--;
            if (cts[nums[i-k]]==1)
                --ctg;
            cts[nums[i]]++;
            if (cts[nums[i]]==2)
                ++ctg;
            if (ctg==0) {
                ans = Math.max(ans,sums[i+1]-sums[i-k+1]);
            }
        }
        return ans;
    }
//
    public static long totalCost(int[] costs, int k, int candidates) {
        long result=0;
        Arrays.sort(costs);
        for(int i=0;i<k;i++){
           result+=costs[i];
        }


        return result;
    }
    List<String> result=new ArrayList<>();
    public static String longestPalindrome(String s) {
    if(s.length()==0|| s.length()==1){
        return s;
    }


       int resultLength=0;
       String result="";
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();

        for(int i=0;i<sb.length();i++){
            int nextIndex=s.indexOf(s.charAt(i),i);
            int lastIndex=s.lastIndexOf(s.charAt(i));

            while(nextIndex<lastIndex){
                if(lastIndex+1<=s.length()){
                    if(s.substring(nextIndex,lastIndex+1).equalsIgnoreCase(new StringBuilder(s.substring(nextIndex,lastIndex+1)).reverse().toString())) {

                        if(resultLength<lastIndex-nextIndex){
                            result=s.substring(nextIndex,lastIndex+1);
                            resultLength=lastIndex-nextIndex;
                        }

                    }
                }

                nextIndex=s.indexOf(s.charAt(i),nextIndex+1);
            }

        }
if(result==null){
    return String.valueOf(s.charAt(0));
}
return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        int startIndex=0,middleIndex=0,lastIndex=0;
        List<Integer> result;
        List<List<Integer>> results=new ArrayList<>();

      while(startIndex<nums.length-2){
          middleIndex=startIndex+1;
          lastIndex=middleIndex+1;
          while(middleIndex<lastIndex && middleIndex<=nums.length-2){
             if(nums[middleIndex]+nums[lastIndex]==0-nums[startIndex]){
                 result=new ArrayList<>();
                 result.add(nums[startIndex]);
                 result.add(nums[middleIndex]);
                 result.add(nums[lastIndex]);
                 Collections.sort(result);
                 results.add(result);
             }
              lastIndex++;
             if(lastIndex>nums.length-1){
                 middleIndex++;
                 lastIndex=middleIndex+1;
             }


          }
          startIndex++;
      }
        List<List<Integer>> newResults=new ArrayList<>();

        // Traverse through the first list
        for (List<Integer> element : results) {

            // If this element is not present in newList
            // then add it
            if (!newResults.contains(element)) {

                newResults.add(element);
            }
        }
return newResults;

    }

    public static int minDifference(int arr[], int n)
    {

        Arrays.sort(arr);
        int initialSum=arr[0], bigSum=0;
        for(int i=1;i<n;i++){
            bigSum+=arr[i];
        }
        int startIndex=0, diff=Integer.MAX_VALUE;

        while(startIndex<n-1 ){
            int currDiff=Math.abs(bigSum-initialSum);
            diff=Math.min(diff,currDiff);
            initialSum+=arr[++startIndex];
            bigSum-=arr[startIndex];

        }

        return diff;
    }
    public static String removeDuplicates(String s) {
        if(s.length()==0 || s.length()==1){
            return s;
        }

        Stack<Character> stack=new Stack<>();
        for(Character c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()== c){
                stack.pop();
            }
            else {
                stack.push(c);
            }

        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
           sb.append(stack.pop());
        }
        return sb.reverse().toString();

    }

    public static int removeDuplicates(int[] nums) {


        int left=0,right=1;

        while(right<=nums.length-1){
            if(nums[left]==nums[right]){
                right++;
            }
            else{
                nums[left+1]=nums[right];
                left++;
                right++;
            }

        }
        return left+1;
    }



    public static void main(String[] args) {

        ListNode node10 = new ListNode(1);
        ListNode node20 = new ListNode(2);
        ListNode node30 = new ListNode(3);
        ListNode node40 = new ListNode(4);
        ListNode node50 = new ListNode(5);
        node10.next = node20;
        node20.next = node30;
        node30.next = node40;
        node40.next = node50;
        node50.next = null;
       // maximumSubarraySum(new int[] {1,5,4,2,9,9,9},3);
       // longestPalindrome("aacabdkacaa");
      //  threeSum(new int[]{-1,0,1,2,-1,-4});
      //  minDifference(new int[]{20 ,19, 18, 20, 16} ,5);
        removeDuplicates(new int[] {1,1,2});
        removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4});
       // isPowerOfTwo(16);
      //  summaryRanges(new int[] {0,1,2,4,5,7});
       // summaryRanges(new int[] {0,2,3,4,6,8,9});
        //reverseList(node10);
       // int[][] result=new int[][]{{1,1,0},{1,1,1},{1,1,1}};
       // mostPopularCreator(new String[]{"alice","alice","alice"},new String[]{"a","b","c"},new int[] {1,2,2});

    }
    }
