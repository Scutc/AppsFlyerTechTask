public class Solution {
    public static void main(String[] args) {
        IBuffer buffer = new BufferImpl(3);
        buffer.addElement(1, "ABC");
        buffer.printBuffer();
        System.out.println();

        buffer.addElement(2, "CDE");
        buffer.printBuffer();
        System.out.println();

        buffer.addElement(1, "XXX");
        buffer.printBuffer();
        System.out.println();

        buffer.addElement(3, "BBB");
        buffer.printBuffer();
        System.out.println();

        buffer.getElement(1);
        buffer.printBuffer();
        System.out.println();

        buffer.getElement(2);
        buffer.printBuffer();
        System.out.println();


        buffer.addElement(4, "NNN");
        buffer.printBuffer();
        System.out.println();

        buffer.getElement(2);
        buffer.printBuffer();
        System.out.println();

        buffer.getElement(1);
        buffer.printBuffer();
        System.out.println();
    }
}
