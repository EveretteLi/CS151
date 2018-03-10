public class SquareSequence implements NumberSequence {
    long[] squareSequence;

    public SquareSequence(){ squareSequence = new long[]{}; }

    /**
     * get the next number in the square sequence
     * @return the next number in the square sequence
     */
    public long next() {
        long[] temp = new long[squareSequence.length +1];
        for(int i = 0; i < squareSequence.length; i++)
            temp[i] = squareSequence[i];
        long toSquare = squareSequence.length;
        toSquare *= toSquare;
        temp[temp.length-1] = toSquare;
        squareSequence = temp;
        return toSquare;
    }

    /**
     * Since square sequence has to maintain it's feature, this function will not be supported.
     * @param args the element in the new sequence
     * @return a sequence made of new elements
     * @throws UnsupportedOperationException
     */
    public SquareSequence of(long...args) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("of(long...args) is not supported by square sequence.");
    }

    /**
     * square sequence doesn't support this function
     * @return the average of all elements
     * @throws UnsupportedOperationException
     */
    public double average() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This operation has not been supported.");
    }

    /**
     * reset the square sequence.
     */
    public void reset() { squareSequence = new long[]{}; }

}









