package InterfacesAbstracts;

/**
 * An interface designed to model an object which has methods that modify
 * the global variables of another object. The Modifier object has one
 * method which will return another object P, after changing or updating its parameters.
 * @param <P> the object whose parameters this object modifies
 */
public interface Modifier<P> {

    /**
     * change the values of the object P's parameters.
     * @param objectToModify the object to affect
     * @return the updated object P
     */
    P modify(P objectToModify);
}
