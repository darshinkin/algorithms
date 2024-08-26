package cracking.arrays;

public class CelebritySearch {

    public static void main(String[] args) {
        Person[] arr = new Person[] {new Person(), new Person()};
        Person celebrity = new CelebritySearch().search(arr);
        System.out.println(celebrity);
    }

    private Person search(Person[] arr) {
        int l = 0, r = arr.length - 1;
        while (l != r) {
            if (arr[l].knows(arr[r])) {
                ++l;
            }
            if (arr[r].knows(arr[l])) {
                --r;
            }
        }
        for (int i = 0; i < arr.length; ++i){
            if (l != i && (!arr[i].knows(arr[l]) || arr[l].knows(arr[i]))) {
                return null;
            }
        }
        return arr[l];
    }

    static class Person {

        private boolean knows(Person person) {
            return false;
        }
    }
}
