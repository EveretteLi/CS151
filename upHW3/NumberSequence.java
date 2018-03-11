
public interface NumberSequence {

    long next();

    default boolean hasNext(){ return true; }

    static NumberSequence of(long...args) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This operation has not been supported.");
    }

    default double average(int n) throws IndexOutOfBoundsException {
        // return 0 when the sequence is empty
        if(!hasNext()) return 0;

        long sum = 0;
        int counter = n;
        while(hasNext() && counter > 0) {
            sum += next(); counter--;
        }

        return (double)sum/(double)n;
    }

    default double average() {
        long sum = 0;
        int counter = 0;
        while(hasNext()) {
            sum += next(); counter++;
        }
        return (double)sum/(double)counter;
    }

    default long[] toArray(int n) {
        long[] toArray = new long[]{};
        int counter = 0;
        while(hasNext() && counter < n) {
            long next = next();
            long[] temp = new long[toArray.length+1];
            if(toArray.length != 0) {
                for(int i = 0; i < toArray.length; i++) temp[i] = toArray[i];
            }
            temp[counter] = next;
            toArray = temp;
            counter++;
        }
        return toArray;
    }

    void reset();
}