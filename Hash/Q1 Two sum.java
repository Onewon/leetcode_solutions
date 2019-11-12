//javac -encoding UTF-8 *.java
//java *
public class Main{
	public static void main(String[] args) {
	    Solution abc = new Solution();
	    int[] result = abc.twoSum(new int[]{1,2,3,4,5,6},5);
		for(int i=0;i<result.length;++i){
		System.out.println(result[i]);
		}
    }
}
class Solution{
    public int[] twoSum(int[]nums,int target){
	    if(nums.length<2){return new int[0];} //严谨，判断是否能有结果.第一步初始判断，与空返回结果一致。

	    for(int j=0;j<nums.length-1;j++){
	        for(int k=j+1;k<nums.length;k++){
	            if(nums[j]+nums[k]==target){
	                return new int[]{j,k};
	            }
	        }
	    }
         return new int[0];
	}
}