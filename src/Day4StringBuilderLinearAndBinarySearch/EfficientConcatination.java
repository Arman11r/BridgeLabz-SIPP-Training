package Day4StringBuilderLinearAndBinarySearch;

public class EfficientConcatination {
    public static void main(String[] args) {
        String[] words = {"Java", "is", "fun"};
        StringBuffer sb = new StringBuffer();
        for (String word : words) {
            sb.append(word).append(" ");
        }
        System.out.println("Concatenated: " + sb.toString().trim());
    }
}