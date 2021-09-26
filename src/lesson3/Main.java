package lesson3;

public class Main {
    public static void main(String[] args) {
        String[] array = {"Съешь", "еще", "этих", "мягких", "французких", "булок"};
        revertArrayString(array);

    }

    private static void revertArrayString(String[] array){
        MyStack<String> stack = new MyStack<>();
        for (String item: array) {
            stack.push(item);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.println( stack.pop());
        }
    }
}
