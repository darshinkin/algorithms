package walmart;

public class ArrayFindSecondHighestElement {

    public static void main(String[] args) {
//        int [] arr = {1,56,3,98,23};
        int [] arr = {3, 53, 23, 45};
        int res = new ArrayFindSecondHighestElement().find(arr);
        System.out.println(res);
    }

    private int find(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        int max = arr[0];
        int previous = arr[1];
        for(int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                previous = max;
                max = arr[i];
                continue;
            }
            if (arr[i] > previous) {
                previous = arr[i];
            }
        }
        return previous;
    }
}
