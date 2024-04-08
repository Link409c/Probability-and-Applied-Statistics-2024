package Project1.InterfacesAbstracts;

/**
 * Gives some object the ability to attack another object. Attack methods contain
 * integers as damage values, designed to be subtracted from the passed target's health
 * value. This interface should be used by objects that only have simple attacks.
 * @param <P> the target of the attack
 */
public interface Attackable<P> {

    P attackOne(P theTarget);

    P attackTwo(P theTarget);
}
