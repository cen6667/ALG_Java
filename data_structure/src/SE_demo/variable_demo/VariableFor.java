package SE_demo.variable_demo;

public class VariableFor {
//    static int a = 3;
    int a = 4;

    public VariableFor(){}

    public void show(){
        System.out.println(a);
    }

    public static void main(String[] args) {
//        int a = 1;
        for(;;){
            int a = 2;
            // for循环体中的a 的作用域在*大括号*中，而此时程序中并没有定义过实例变量a的存在，
            System.out.println(a);
            break;
        }
        int a = 1;
        System.out.println(a);

//        System.out.println(variable_for_if.a);

        VariableFor vfi = new VariableFor();
        System.out.println(vfi.a);

        String[] array = {"123","333","adas"};
        for (final String variable : array) {
            System.out.println(variable);
            String[] array2 = array;
        }
//        variable 访问不到
//        array2 也访问不到
        vfi.show();
    }
}
