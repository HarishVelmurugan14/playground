package OnlinePlatforms.Scaler.DSA;

import Resources.Utilities.PrintHelper;

import java.util.ArrayList;


public class TryOutClass {
    PrintHelper printHelper = new PrintHelper();

    public static void main(String[] args) {
        TryOutClass tryOutClass = new TryOutClass();
        System.out.println(tryOutClass.generateSubSequenceAscii("", "abc"));
//        System.out.println(s);


    }

    public ArrayList<String> generateSubSequenceAscii(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = generateSubSequenceAscii(p+ch, up.substring(1));
        ArrayList<String> middle = generateSubSequenceAscii(p, up.substring(1));
        ArrayList<String> right = generateSubSequenceAscii(p + (ch + 0), up.substring(1));
        left.addAll(right);
        left.addAll(middle);
        return left;
    }




}

