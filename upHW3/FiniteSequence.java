public class FiniteSequence implements NumberSequence {
    long[] finiteSequence;
    int numPointer;

    public FiniteSequence() { finiteSequence = new long[]{}; numPointer = -1; }
    public FiniteSequence(long...args) {finiteSequence  = args; numPointer = -1; }

    /**
     * return the long in the sequence pointed by the numPointer
     * @return the next element in the sequence
     * @throws IndexOutOfBoundsException when calling next at the end of the sequence
     */
    public long next() throws IndexOutOfBoundsException {
       if(hasNext()) {
           numPointer++;
           return finiteSequence[numPointer];
       } else {
           throw new IndexOutOfBoundsException("" + numPointer + ", sequence length: " + finiteSequence.length);
       }
    }

    /**
     * if the sequence has next element
     * @return if the sequence has next element
     */
    public boolean hasNext() {
        return numPointer < finiteSequence.length;
    }

    /**
     * take vararg of type long to build a finite sequence
     * @param args the element in the new sequence
     * @return this finite sequence
     */
    public static FiniteSequence of(long...args) {
        FiniteSequence finit = new FiniteSequence(args);
        return finit;
    }

    /**
     * reset the square sequence.
     */
    public void reset() { this.finiteSequence = new long[]{}; numPointer = -1; }


    /**
     * return the average of this finite sequence
     * @return the average of this finite sequence
     */
    public double average() {
        // return 0 when the sequence is empty
        if(finiteSequence.length == 0) return 0;
        int sum = 0;
        for(long each : finiteSequence)
            sum += each;
        return (double)sum/(double)finiteSequence.length;
    }
}