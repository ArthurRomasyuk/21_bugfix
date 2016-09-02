package bugs;

public class StackOverflowError1 {

    public static void recursivePrint(int num) {
        System.out.println("Number: " + num);

        if (num == 1000)
            return;
        else
            recursivePrint(++num);
    }

    public static void main(String[] args) {
        StackOverflowError1.recursivePrint(1);
    }
}
