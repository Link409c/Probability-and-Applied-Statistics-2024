package Project1.InterfacesAbstracts;

/**
 * The ProbabilityOperations interface is a generics interface that should be used
 * when constructing classes that use or model some probability calculations. This
 * could be the end goal of the class (calculating probability using a specific
 * formula or theorem) or serve the operations of a class or program.
 */
public interface ProbabilityOperations<E> {

    //a method to count the number of unique objects in a list.
    E countUniqueObjects(E aList);

    //a method to assign simple probabilities to the unique objects in a list.
    E assignObjectProbabilities(E aList);

    //methods to create unions and intersections of objects based on their supertypes.

    //unite is useful if an object has multiple data structures or lists of objects.
    E unite(E theLists);
    //intersect is useful when considering comparable objects.
    E intersect(E theLists);

    //methods to check lists of objects against the axioms of probability.
    boolean checkAxioms(E aList);

    //methods to return strings informing the user of the probabilities of objects in a list.
    String listProbabilities(E aList);

    //method to calculate specific probabilities for the objects within a data structure.
    double calculateProbability(E aList);

    //methods to calculate central tendency for a list of objects
    E calcMean(E aList);
    E calcMode(E aList);
    E calcMedian(E aList);
    E calcStandardDev(E aList);

    //method to calculate compliment of a list of objects
    E compliment(E universalSet, E aList);
}
