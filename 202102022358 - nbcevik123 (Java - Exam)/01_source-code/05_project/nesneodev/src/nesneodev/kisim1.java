package nesneodev;

public class kisim1 {

    public static class ClassA {

        int n;

        public ClassA() {
            System.out.println("ClassA is created");
        }

        public ClassA(int n) {
            this.n = n;
            System.out.println("ClassA is created with n: " + this.n);
        }

        public void method1() {
            System.out.println("Method1 is called with ClassA");
        }
    }

    public static class ClassB extends ClassA {

        int m;

        public ClassB() {
            System.out.println("ClassB is created");
        }

        public ClassB(int n, int m) {
            super(n);
            this.m = m;
            System.out.println("ClassB is created with m:" + m);
        }
        
        public void method1(){
            super.method1();
            System.out.println("Method1 is called with ClassB");
        }
        
        public void method2(){
            System.out.println("Method2 is called with ClassB");
        }

    }
    
    public static class ClassC extends ClassA{

        public ClassC() {
            super();
            System.out.println("ClassC is created");
        }
        
        public void method1(){
            System.out.println("Method1 is called with ClassC");
        }
        
        public void method3(){
            method1();
            super.method1();
        }
        
    }

   /* public static void main(String[] args) {
       
    }*/

}
