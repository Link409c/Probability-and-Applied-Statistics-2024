package Project2.PlotSaltSmooth.Structures;

/**
 * a data container for related pairs of values.
 * @param <E> some generic value that can relate to
 *           an output when input to a function.
 */
public class Tuple<E> {

    public Tuple(E input, E output){
        setInput(input);
        setOutput(output);
    }

    public E getInput() {
        return input;
    }

    public void setInput(E input) {
        this.input = input;
    }

    public E getOutput() {
        return output;
    }

    public void setOutput(E output) {
        this.output = output;
    }

    /**
     * some input value to a function.
     */
    private E input;
    /**
     * the output value of a function using the associated input.
     */
    private E output;

}
