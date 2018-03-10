import java.util.Comparator;

/**
 * this class compare two number sequences
 */
public class SequenceComparator implements Comparator<NumberSequence>{

    @Override public int compare(NumberSequence sqA, NumberSequence sqB){
        // first 5 elements
        double avgA = sqA.average(5);
        double avgB = sqB.average(5);
        if(avgA != avgB)
            return Double.compare(avgA, avgB);

        // compare first 5 elements
        long[] arrayA = sqA.toArray(5);
        long[] arrayB = sqB.toArray(5);
        int iteration = arrayA.length - arrayB.length;
        String longer = "";
        //iteration depends on the shorter one
        if(iteration != 0) {
            if(iteration < 0) { iteration = arrayA.length; longer = "b";}
            else { iteration = arrayB.length; longer = "a"; }
        }
        for(int i = 0; i < iteration; i++) {
            long a = arrayA[i]; long b = arrayB[i];
            if(a - b != 0) return Long.compare(a, b);
        }
        switch (longer) {
                case "a": return 1;
                case "b": return -1;
                default: return 0;
        }
    }
}
