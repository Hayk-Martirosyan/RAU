
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Opposite Word
 * @author rharutyunyan
 */

public class OppositeWord {
    private ArrayList<String> words = new ArrayList<String>();
    private int countOfOpposite = 0;
    private int size = 0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int size;

        System.out.println("How many words will you enter? : ");
        size = input.nextInt();
        System.out.println("Enter " + size + " words , please : ");
        OppositeWord opword = new OppositeWord(size);
        opword.fillArray();

        opword.findMatchingOpposites();
        System.out.println();
        System.out.println("Count of matching opposites - " + opword.getCountOfOpposite());

    }

    OppositeWord(int _size){
        words.ensureCapacity(_size);
        size = _size;
    }

    public void fillArray(){
        Scanner arrayinput = new Scanner(System.in);
        for(int i=0 ; i < size ; i++){
            words.add(arrayinput.nextLine());
            if(oppositeMatches(words.get(i))){
                countOfOpposite++;
            }
        }
    }

    public static boolean oppositeMatches(String source) {
        int i, len = source.length();
        StringBuilder dest = new StringBuilder(len);

        for (i = (len - 1); i >= 0; i--){
            dest.append(source.charAt(i));
        }

        if(source.equals(dest.toString())){
            return true;
        }else return false;
    }

    public void findMatchingOpposites(){
        for(int i=0; i<size; i++) {
            if (oppositeMatches(words.get(i))) {
                System.out.println(words.get(i) + " has matching opposite");
            } else {
                System.out.println(words.get(i) + " doesn't have matching opposite");
            }
        }
    }

    int getCountOfOpposite(){
        return countOfOpposite;
    }
}
