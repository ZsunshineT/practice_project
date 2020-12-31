package questions;

/**
 * Description:
 * Created by zhangteng on 2020/12/30.
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int [] a = {2,7,4,1,8,1};
        LastStoneWeight(a);
    }

    public static int LastStoneWeight(int[] stones){
        stones = sortDesc(stones);
        int[] result = stones;
        while(result.length > 1){
            int[] temp;
            if(result.length>2){
                if(result[0] == result[1]){
                    temp = new int[result.length-2];
                    System.arraycopy(result,2,temp,0,result.length-2);
                }else{
                    temp = new int[result.length-1];
                    System.arraycopy(result,2,temp,1,result.length-2);
                    temp[0] = result[0]-result[1];
                    temp = sortDesc(temp);
                }
            }else {
                if(result[0] == result[1]){
                    temp = new int[result.length-2];
                }else{
                    temp = new int[result.length-1];
                    temp[0] = result[0]-result[1];
                }
            }
            result = temp;
            printArray(result);
        }
        return result.length == 1?result[0]:0;
    }

    public static int[] sortDesc(int[] array){
        //排序
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                int temp = 0;
                if(array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print("-"+array[i]);
        }
        System.out.println();
    }
}
