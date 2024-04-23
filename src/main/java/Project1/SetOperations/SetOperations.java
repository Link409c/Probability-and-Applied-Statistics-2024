package Project1.SetOperations;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A program which can perform simple operations on sets of elements.
 */
public class SetOperations<T> {

    /**
     * from two sets, creates a new set of elements consisting of the elements of both sets.
     * @param listA the first set
     * @param listB the second set
     * @return the elements of both sets
     */
    public ArrayList<T> findUnion(ArrayList<T> listA, ArrayList<T> listB){
        //create new list object to return
        ArrayList<T> union = new ArrayList<>();
        //add each element of A to union
        for(T first : listA){
            union.add(first);
        }
        boolean match;
        int index;
        //for each element in B,
        for(T second : listB){
            match = false;
            index = 0;
            //compare to each element in union
            while(index < union.size() && !match) {
                if(!second.equals(union.get(index))){
                    index++;
                    //if end of listB is reached,
                    if(index == union.size()){
                        //no match found
                        //add this unique element to union
                        union.add(second);
                    }
                }
                else{
                    match = true;
                }
            }
        }
        return union;
    }

    /**
     * from two sets, finds each element which exists in both sets and returns this sorted list of items.
     * @param listA the first list
     * @param listB the second list
     * @return a list of elements which occur in both sets.
     */
    public ArrayList<T> findIntersection(ArrayList<T> listA, ArrayList<T> listB){
        //create new list object to return
        ArrayList<T> intersection = new ArrayList<>();
        //find same elements and add to new list
        for(T first : listA){
            for(T second : listB){
                if(first.equals(second)){
                    intersection.add(first);
                }
            }
        }
        return intersection;
    }

    /**
     * calculates the compliment of a passed space of events in relation to the total space.
     * @param listA the total space of events to consider.
     * @param listB some subset of events or elements within the total space.
     * @return the events which are part of the total space but not part of the sample space.
     */
    public ArrayList<T> findCompliment(ArrayList<T> listA, ArrayList<T> listB){
        //for each element of listB,
        for(T t : listB) {
            listA.remove(t);
        }
        //once all elements of B have been removed, we have the compliment
        return listA;
    }

    /**
     * sorts the passed list and compares each pair of adjacent elements, removing any
     * repeated values.
     * @param anArrayList the list to sort and sift for unique values.
     * @return the list of unique values.
     */
    public ArrayList<T> sortAndKeepUniqueElements(ArrayList<T> anArrayList){
        int j;
        for(int i = 0; i < anArrayList.size() - 1; i++){
            j = i + 1;
            while(Objects.equals(anArrayList.get(i), anArrayList.get(j))) {
                anArrayList.remove(j);
                j++;
            }
        }
        return anArrayList;
    }
}
