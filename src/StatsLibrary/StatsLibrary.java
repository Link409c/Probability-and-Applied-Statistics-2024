package StatsLibrary;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * A Program designed to calculate several different probabilities of sets of elements.
 **/
public class StatsLibrary{

    /**
     * a helper method for summation of list elements.
     * @param anArrayList the list to sum values
     * @return the sum of list values.
     */
    public double findListSum(ArrayList<Double> anArrayList){
        double sum = 0;
        if(!anArrayList.isEmpty()) {
            for (Double d : anArrayList) {
                sum += d;
            }
        }
        return sum;
    }

    /**
     * subtracts the mean of values in a list from each of those values.
     * Used in calculating standard deviation of a set of values
     * @param anArrayList the list of values
     * @param mean mean of the passed list
     * @return the new list
     */
    public ArrayList<Double> findDifferenceOfValuesAndMean(ArrayList<Double> anArrayList, double mean){
        //create a list of equal size to hold new values
        ArrayList<Double> differenceList = new ArrayList<>(anArrayList.size());
        //for each value of the passed list,
        for (Double d : anArrayList){
            //set the elements of the new list as difference of passed list value and mean
            double difference = d - mean;
            differenceList.add(difference);
        }
        //return the new list
        return differenceList;
    }

    /**
     * squares each value in a list.
     * @param anArrayList a list of values
     * @return a list of squared values
     */
    public ArrayList<Double> squareList(ArrayList<Double> anArrayList){
        ArrayList<Double> squaredList = new ArrayList<>(anArrayList.size());
        for(Double d : anArrayList){
            d *= d;
            squaredList.add(d);
        }
        return squaredList;
    }
    /**
     * findMean computes the average of values in a list.
     * @param anArrayList the list to iterate
     * @return the average
     */
    public double findMean(ArrayList<Double> anArrayList){
        return findListSum(anArrayList) / anArrayList.size();
    }

    /**
     * sorts the passed list, and compares adjacent values to find the most
     * represented value in the list.
     * @param anArrayList a list of values
     * @return the most represented value in the list
     */
    public double findMode(ArrayList<Double> anArrayList){
        //sort the list
        Collections.sort(anArrayList);
        //loop list and compare pairs of values
        int count = 0, maxCount = 0;
        double mode = anArrayList.get(0);
        int i = 0, j = 1;
        do{
            //if equal increment count
            if(Objects.equals(anArrayList.get(i), anArrayList.get(j))){
                count++;
            }
            //else non equal is found
            //check if count is greater than current highest
            if(count > maxCount){
                //set mode value to this index element
                mode = anArrayList.get(i);
                //set current max count to count
                maxCount = count;
                //reset count
                count = 0;
            }
            i++;
            j++;
        }while(j < anArrayList.size());
        return mode;
    }

    /**
     * sorts the passed array, and finds the median by calculating the middle index.
     * if the list size is even, the median is taken as the average of the two middle
     * values.
     * @param anArrayList a list of values
     * @return the median of the values in the list
     */
    public double findMedian(ArrayList<Double> anArrayList){
        Collections.sort(anArrayList);
        double median;
        //if size is odd,
        if(anArrayList.size() % 2 != 0){
            //median is middle element
            median = anArrayList.get(anArrayList.size() / 2);
        }
        //else if size is even,
        else{
            int middle = (anArrayList.size() / 2);
            //median is average of adjacent middle elements
            median = ((anArrayList.get(middle) + anArrayList.get(middle - 1)) / 2.0);
        }
        return median;
    }

    /**
     * calculates the standard deviation of a set of values. uses several helper
     * methods for each step.
     * @param anArrayList a list of values
     * @return the standard deviation of the values.
     */
    public double calcStandardDeviation(ArrayList<Double> anArrayList) {
        //calculate variance
        double mean = calculateVariance(anArrayList);
        //take the square root of the variance
        //return the result
        return Math.sqrt(mean);
    }

    /**
     * calculates the variance of a population.
     * @param anArrayList the list of elements passed to the method is considered the population.
     * @return the variance of the population
     */
    public double calculateVariance(ArrayList<Double> anArrayList){
        //get sum of the list elements
        //divide to find mean
        double mean = findMean(anArrayList);
        //for each element, subtract the mean from it to get a new list of values
        anArrayList = findDifferenceOfValuesAndMean(anArrayList, mean);
        //square each value
        anArrayList = squareList(anArrayList);
        //get sum of the list elements
        //find the new mean
        return findMean(anArrayList);
    }

    /**
     * calculates the three central tendency values of a space and provides a
     * String representation of the output.
     * @param anArrayList the values of our space in a list
     * @return the mean, median, and mode of the space.
     */
    public String centralTendency(ArrayList<Double> anArrayList){
        String result = "";
        result = result.concat("Mean: " + findMean(anArrayList));
        result = result.concat("\nMedian: " + findMedian(anArrayList));
        result = result.concat("\nMode: " + findMode(anArrayList));
        return result;
    }

    /**
     * calculates the factorial representation of a number returning a BigInteger object.
     * This allows the method to avoid any overflow that would occur if using primitive
     * datatypes.
     * @param l the number to calculate
     * @return the factorial of the input
     */
    public BigInteger calculateFactorial(int l){
        //case for zero factorial
        if(l == 0){
            return BigInteger.ONE;
        }
        else {
            BigInteger result = BigInteger.valueOf(l);
            while (l > 1) {
                l--;
                result = result.multiply(BigInteger.valueOf(l));
            }
            return result;
        }
    }

    /**
     * sorts the passed list and compares each pair of adjacent elements, removing any
     * repeated values.
     * @param anArrayList the list to sort and sift for unique values.
     * @return the list of unique values.
     */
    public ArrayList<Double> sortAndKeepUniqueElements(ArrayList<Double> anArrayList){
        Collections.sort(anArrayList);
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

    /**
     * returns the independent representation of an AND of two probabilities.
     * @param probA probability of some event A
     * @param probB probability of some event B
     * @return the product of the probabilities
     */
    public double probIntersection(double probA, double probB){
        return probA * probB;
    }

    /**
     * returns the independent representation of an OR of two probabilities.
     * @param probA probability of some event A
     * @param probB probability of some event B
     * @return the sum of the probabilities
     */
    public double probUnion(double probA, double probB){
        return probA + probB;
    }

    /**
     * The additive law of probability calculates the probability of several
     * OR events, while eliminating the probability of those events intersecting
     * with the sum of probabilities.
     * @param probA the first probability to add
     * @param probB the second probability to add
     * @return the sum of A and B minus their product
     */
    public double unionAdditionRule(double probA, double probB){
        return probUnion(probA, probB) - probIntersection(probA, probB);
    }

    /**
     * The multiplicative law states that the product of two probabilities is
     * equal to the probability of their conditional occurrence multiplied by
     * the probability of the dependent event.
     * @param probA the probability of event A
     * @param probB tne probability of event B
     * @return the product of event A and B given A.
     */
    public double intscMultRule(double probA, double probB){
        return probA * conditionalProb(probIntersection(probA, probB), probA);
    }

    /**
     * the compliment of the probability of an event is the total probability of the
     * sample space minus that event's probability within the same space.
     * @param probEvent the probability of the event occurring.
     * @return the total probability of the space minus the probability of an event.
     */
    public double complimentOfEvent(double probEvent){
        return 1 - probEvent;
    }

    /**
     * calculates the ways a sample space can be split into different groupings of elements
     * as divided by the user.
     * @param space the total number of elements in the sample space.
     * @param coefficients the groups of those elements to consider which equal the total.
     * @return the amount of unique groupings that can be created.
     */
    public BigInteger calcMultinomialCoefficients(int space, int[] coefficients){
        //calculate numerator
        BigInteger total = calculateFactorial(space);
        BigInteger denominator = BigInteger.ONE;
        //calculate denominator
        for (int coefficient : coefficients) {
            denominator = denominator.multiply(calculateFactorial(coefficient));
        }
        //return the division
        return total.divide(denominator);
    }

    /**
     * calculates the number of permutations of an amount of elements resulting
     * from a set of elements. Note that the order of elements matters, and
     * duplicates are not allowed. uses the calculateFactorial helper method to calculate
     * each section of the formula before returning the full formula with those values
     * plugged in.
     * @param setElements the number of elements in the set
     * @param choices the number of elements in each permutation
     * @return the total possible permutations in the set
     */
    public BigInteger findPermutations(int setElements, int choices){
        //calc factorial of set elements
        BigInteger elementsFactorial = calculateFactorial(setElements);
        //subtract number of choices from number of elements
        int difference = setElements - choices;
        //calc factorial of difference
        BigInteger elementsMinusChoices = calculateFactorial(difference);
        //plug all values into permutations formula n! / (n-r)!
        return elementsFactorial.divide(elementsMinusChoices);
    }

    /**
     * calculates the number of combinations resulting from a set of elements
     * and how many elements to include in each resulting combination. Note that
     * order of the elements does not matter and duplicates are allowed. Uses the
     * calculateFactorial helper method to calculate each section of the formula
     * before returning the full formula with those values plugged in.
     * @param setElements the number of elements in the set
     * @param choices the number of elements in each combination
     * @return the total possible combinations in the set
     */
    public BigInteger findCombinations(int setElements, int choices){
        //check n >= r >= 0
        //calc factorial of set elements
        BigInteger elementsFactorial = calculateFactorial(setElements);
        //calc factorial of choices in the combination
        BigInteger choicesFactorial = calculateFactorial(choices);
        //subtract number of choices from number of elements
        int difference = setElements - choices;
        //calc factorial of difference
        BigInteger elementsMinusChoices = calculateFactorial(difference);
        //plug all values into combinations formula n! / r!(n-r)!
        return elementsFactorial.divide(elementsMinusChoices.multiply(choicesFactorial));
    }

    /**
     * represents the probability axiom:
     * "The probability of an event occurring cannot be less than zero".
     * @return true if the probability is negative, false otherwise.
     */
    public boolean negativeAxiom(double probability){
        return probability < 0;
    }

    /**
     * represents the probability axiom:
     * "The total probability of events occurring in a set must equal exactly 100%".
     * @param probabilities the list of probabilities to consider.
     * @return true if the total equals 100%, false otherwise.
     */
    public boolean totalAxiom(ArrayList<Double> probabilities){
        return findListSum(probabilities) == 1.0;
    }

    /**
     * with the probabilities of two events, A and B, in a sample space, determines wether or not those
     * events are independent (do not influence each other), or dependent (influence each other). Three
     * conditions of independence can occur: P(A|B) = P(A); P(B|A) = P(B); P(AnB) = P(A)P(B).
     * @param probA the probability of some event "A"
     * @param probB the probability of some event "B"
     * @return true if the events are independent, false otherwise.
     */
    public boolean isIndependent(double probA, double probB){
        double aGivenB = conditionalProb(probA, probB);
        double bGivenA = conditionalProb(probB, probA);
        double aNB = probIntersection(probA, probB);
        return aGivenB == probA || bGivenA == probB || aNB == probA * probB;
    }


    /**
     * calculates the probability of an event A in a space, or P(A), by using the Theorem of Total Probability.
     * The Theorem states: "The Probability of all occurrences of an event A within a sample space is
     * equal to the sum from i to n of each occurrence of A given Bi occurred, times the probability
     * of Bi". These sample space probabilities are subject to all the axioms of probability. --
     * The passed lists should be formatted so the first contains the probability of the desired event
     * within the respective sample space should that same index element be chosen from the second.
     * ex. eventA.get(i) is P(A|Bi).
     * @param eventA the list of events A, which have unique probabilities of occurring in their
     *               respective sample spaces.
     * @param eventB the list of events B, which have unique probabilities of occurring in their
     *               respective sample space and determine the probability of the respective event A.
     * @return the total probability of an event A in a sample space.
     */
    public double thmTotalProb(ArrayList<Double> eventA, ArrayList<Double> eventB){
        //amount of steps in the addition loop
        int bSize = eventB.size();
        //check that total prob of A = 1 and B = 1
        //if either total != 1,
        if(!totalAxiom(eventA) || !totalAxiom(eventB)){
            return 0;
        }
        else {
            double result = 0;
            //for each event B,
            for(int i = 0; i < bSize; i++) {
                //multiply P(A|Bi) by P(Bi)
                result += eventA.get(i)*eventB.get(i);
            }
            return result;
        }
    }

    /**
     * calculates the probability of an event occurring, given another event has
     * already occurred. represented by the formula P(A|B) = P(AnB) / P(B) .
     * @param probAnB the intersection of the events A and B.
     * @param probB the total probability that an event B will occur in some sample space.
     * @return the conditional probability of A given B, or P(A|B).
     */
    public double conditionalProb(double probAnB, double probB){
        return probAnB / probB;
    }

    //bayes notes
    /*
    bayesTheorem method
    P(B|A) = P(A|B)P(B) / P(A) or...
    P(A|B) = P(B|A)P(A) / P(B)
    the probability of an event B, given an event A has occurred is...
    the probability of an event A, given an event B has occurred times the probability of an event B
    all over the probability of an event A
    multiply P(AnB) x P(B)
    divide by P(A)
    */

    /**
     * Bayes' Theorem calculates conditional probability of an event using information known
     * about other probabilities concerning that event, most notably the converse of the
     * conditional probability to be calculated.
     * @param probA the probability of some event "A"
     * @param probB the probability of some event "B"
     * @return the conditional probability of B given A occurred.
     */
    public double bayesTheorem(double probA, double probB){
        //get intersection of A and B
        double aAndB = probIntersection(probA, probB);
        //multiply the intersection by the probability of B
        double aUBTimesB = aAndB * probB;
        //divide by the probability of A
        return aUBTimesB / probA;
    }

    /**
     * calculates the binomial distribution for a set of values. Useful when data deals
     * with individual, independent trials resulting in either success or failure only.
     * @param n the number of trials conducted
     * @param y the intended number of successes
     * @param p the probability of success occurring in one trial
     * @return the probability of Y successes in N trials.
     */
    public double binomialDistribution(int n, int y, double p){
        //calculate combinations for N choose Y
        BigInteger combinations = findCombinations(n, y);
        //calculate q
        double q = 1 - p;
        //raise p to y
        double pRaisedY = Math.pow(p, y);
        //raise q to y - 1
        double qRaised = Math.pow(q, (n-y));
        //return combinations * p^y * q^y-1
        return combinations.longValue() * pRaisedY * qRaised;
    }

    /**
     * calculates the mean of the data using values provided in a problem
     * applying binomial distribution.
     * @param p the probability of success
     * @return the average value of the data.
     */
    public double binomialMean(double p){
        return 1 / p;
    }

    /**
     * calculates the variance of the data using values provided in a problem
     * applying binomial distribution.
     * @param p the probability of success.
     * @return the variance of the data.
     */
    public double binomialVariance(double p){
        double numerator = 1 - p;
        double denominator = Math.pow(p, 2);
        return numerator / denominator;
    }

    /**
     * calculates the geometric distribution for a set of values. Geometric Distribution
     * is applied when finding the first success at the yth trial. Useful when data deals
     * with individual, independent trials resulting in either success or failure only.
     * @param y the number of trials
     * @param p the probability of success
     * @return the chance of finding the first success at the yth trial.
     */
    public double geometricDistribution(int y, double p){
        int trialsFailed = y - 1;
        double q = 1 - p;
        double qRaised = Math.pow(q, trialsFailed);
        return qRaised * p;
    }

    /**
     * calculates the probability of selecting a number of elements from the sample where
     * selecting an element would change the probability of subsequent selections. Useful for
     * problems involving a random variable with dependent events.
     * @param totalElements the total number of elements in the space.
     * @param totalChoices the total number of choices in the space.
     * @param y the number of elements we want to choose from the sample.
     * @param r the number of elements in the sample.
     * @return the probability of choosing y elements from n specific elements.
     */

    public double hyperGeometricDistribution(int totalElements, int totalChoices, int y, int r){
        //combinations of choices from the sample
        BigInteger nChooseY = findCombinations(r, y);
        //combinations of the remaining choices from the remaining set elements
        BigInteger remainingChooseRemaining = findCombinations(totalElements - r, totalChoices - y);
        //combinations of the total set choosing the total number of choices
        BigInteger totalCombinations = findCombinations(totalElements, totalChoices);
        //numerator = rCy * N-n C r-y
        BigInteger numerator = nChooseY.multiply(remainingChooseRemaining);
        return numerator.divide(totalCombinations).doubleValue();
    }

    /**
     * the expected value of a probability calculated using hypergeometric distribution.
     * @param n the total choices from the set
     * @param r the total elements in the subset
     * @param N the total elements in the set
     * @return the expected value.
     */
    public double hyperGeoMean(int n, int r, int N){
        return (double) (n * r) / N;
    }

    /**
     * the variance of the expected value calculated using hypergeometric distribution.
     * @param n the total choices from the set
     * @param r the total elements in the subset
     * @param N the total elements in the set
     * @return how far the expected can vary.
     */
    public double hyperGeoVariance(int n, int r, int N){
        return n * (r / n) * (N - r / n) * ((N - n) / N - 1);
    }

    /**
     * calculates the probability of finding a certain number of successes within
     * a number of trials where each trial is an independent event and the probability
     * of success remains the same from trial to trial.
     * @param y the amount of successes to find.
     * @param p the probability of success.
     * @param r the number of trials to conduct.
     * @return the probability of finding Y successes in R trials.
     */
    public double negativeBinomialDistribution(int y, double p, int r){
        //calculate combinations of successes - 1 choosing trials - 1
        BigInteger combinations = findCombinations(y - 1, r - 1);
        //chance to fail
        double q = 1 - p;
        //calculate pieces of equation
        double pRaisedR = Math.pow(p, r);
        double qRaised = Math.pow(q, y-r);
        //multiply each value and return
        return combinations.doubleValue() * pRaisedR * qRaised;
    }

    /**
     * calculates the mean of the sample space for a problem utilizing
     * negative binomial distribution.
     * @param p the probability of success
     * @param r the number of trials conducted
     * @return the average rate of success.
     */
    public double negativeBinomialMean(double p, int r){
        return r / p;
    }

    /**
     * calculates the variance of the sample space for a problem utilizing
     * negative binomial distribution.
     * @param p the probability of success.
     * @param r the number of trials conducted.
     * @return the variance of success over the trials.
     */
    public double negativeBinomialVariance(double p, int r){
        double numerator = r * (1-p);
        double denominator = Math.pow(p, 2);
        return numerator / denominator;
    }

    /**
     * the lambda, used in Poisson Distribution calculations, is a representation
     * of not only the mean of the data, but also the variance. It is calculated by
     * dividing the total number of events by the number of units measured, such as
     * hours, miles, etc.
     * @param k the number of events occurring.
     * @param n the units of measurement, per unit.
     * @return the average number of events per unit of measurement.
     */
    public double poissonLambda(double k, double n){
        //events per unit
        //k's per n
        return k / n;
    }

    /**
     * calculates the Poisson Distribution of a desired event in a sample space. Useful when
     * calculating the number of occurrences on a per-unit basis, such as units of time, speed,
     * area, volume, etc. It should be noted that the larger the number of trials become, the
     * smaller the chance of success of the event becomes - or, the success rate is
     * directly dependent on the region size.
     * @param lambda the mean; also the variance.
     * @param trials the number of trials to conduct
     * @return the chance of success within the performed trials space.
     */
    public double poissonDistribution(double lambda, int trials){
        //lambda raised to trials times...
        double lambdaRaisedTrials = Math.pow(lambda, trials);
        //euler's number raised to the negative lambda...
        double eulerRaisedNegLambda = Math.pow(EULERS_NUMBER, Math.negateExact((long) lambda));
        //all over the number of trials factorial
        BigInteger bigTrials = calculateFactorial(trials);
        return (lambdaRaisedTrials * eulerRaisedNegLambda) / bigTrials.longValue();
    }

    /**
     * the "within number" is associated with Tchebysheff's Theorem. It represents, when divided
     * by the standard deviation, the number of standard deviations about the mean in which the
     * random variable has a probability of existing.
     * @param lowBound the lower bound of the interval
     * @param highBound the higher bound of the interval
     * @param mean the average of the data
     * @return the "within number".
     */
    public double calcWithinNumber(double lowBound, double highBound, double mean){
        double withinNumberLower = mean - lowBound;
        double withinNumberUpper = highBound - mean;
        if(withinNumberLower == withinNumberUpper){
            return withinNumberLower;
        }
        return 0;
    }

    /**
     * calculates the probability that a number of observations lie in the given interval about
     * the mean, or "K" standard deviations about the mean.
     * @param lowBound the lower bound of the interval
     * @param highBound the upper bound of the interval
     * @param mean the mean of the data
     * @param stdDev the standard deviation of the data
     * @return the probability our random variable lies within the interval.
     */
    public double tchebysheffsTheorem(double lowBound, double highBound, double mean, double stdDev) {
        //subtract lower bound from mean and mean from upper bound
        //these should be equal and are the "within number"
        double withinNumber = calcWithinNumber(lowBound, highBound, mean);
        //divide within number by standard deviation to get k
        double k = withinNumber / stdDev;
        double denominator = 1 - Math.pow(k, 2);
        //subtract 1/1-k^2 from 1 to get result
        return 1 - (1 / denominator);
    }
    private static final double EULERS_NUMBER = 2.7182818;

}
