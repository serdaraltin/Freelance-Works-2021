public class Main {
    public static void main(String[] args) {
        String[] decimals_ = GeneralOperations.readFile(args[0]);
        int[] decimals = strToInt(decimals_);
        makeProcess(decimals);
    }

    public static int[] strToInt(String[] s) {
        int[] arr = new int[s.length] ;
            for (int i = 0 ; i < s.length ; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            return  arr;
    }

    public static void makeProcess(int[] d){
        for (int x : d){
            int temp = x;
            MyStack stack = new MyStack();
            while (temp > 0){
                int mod = temp % 8;
                stack.push((int)mod);
                int div = (int) temp / 8;
                temp = div;
            }
            GeneralOperations.Write(stack.toString());
        }
    }








}
