package Project1.InterfacesAbstracts;

/**
 * An interface designed to count some number of an object that may exist in a data structure.
 */
public interface Countable<S, O> {

    /**
     * Counts the number of instances of O in S.
     * @param aStruct the data structure to search
     * @param anObject the object to search for
     * @return the number of objects O in S.
     */
    int count(S aStruct, O anObject);
}
