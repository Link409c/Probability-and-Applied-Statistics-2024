package SetOperations;
import java.util.ArrayList;

/**
 * test class for set operations.
 */
public class SetOpsTester {
    public static void main(String[] args){
        SetOperations<String> setOperations = new SetOperations<String>();
        ArrayList<String> setOne = new ArrayList<>();
        ArrayList<String> setTwo = new ArrayList<>();
        setOne.add("A");
        setOne.add("B");
        setOne.add("C");
        setOne.add("D");
        setTwo.add("E");
        setTwo.add("F");
        setTwo.add("G");
        System.out.println("Set A: " + setOne);
        System.out.println("Set B: " + setTwo);
        //test union
        System.out.println("Union: " + setOperations.findUnion(setOne, setTwo));
        //test intersection
        System.out.println("Intersection: " + setOperations.findIntersection(setOne, setTwo));
        //test compliment
        ArrayList<String> population = setOperations.findUnion(setOne, setTwo);
        System.out.println("Compliment of A: " + setOperations.findCompliment(population, setOne));
        population = setOperations.findUnion(setOne, setTwo);
        System.out.println("Compliment of B: " + setOperations.findCompliment(population, setTwo));
    }
}
