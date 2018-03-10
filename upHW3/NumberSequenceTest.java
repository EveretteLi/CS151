import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class NumberSequenceTest {

    @Test
    public void squareSequenceTest() {
        SquareSequence s = new SquareSequence();
        for(int i = 0; i < 5; i++)
            s.next();
        long[] expected = new long[]{0,1,4,9,16};
       Assertions.assertArrayEquals(s.squareSequence, expected, "square sequence unexpected.");
    }

    @Test public void ofTestFinite()
    {
        FiniteSequence temp = new FiniteSequence().of(1,2,3,4,5,6);
        long[] assertTemp = new long[]{1,2,3,4,5,6};
        Assertions.assertArrayEquals(assertTemp, temp.finiteSequence,"return array unequals");
    }

    @Test public void ofTestInfinite()
    {
        try{
            NumberSequence s = new SquareSequence().of(1,2,3,4,5);
            Assert.fail("Exception triggering fail");
        } catch (UnsupportedOperationException e){}
    }

    @Test public void averageTestFinite() {
        NumberSequence finite = new FiniteSequence().of(1,3,5,7,11,13,17,19);
        long[] assertFinite = new long[]{1,3,5,7,11,13,17,19};
        int sum = 0;
        for(long each : assertFinite)
            sum += each;
        double avg = (double)sum/(double)assertFinite.length;
        Assertions.assertEquals(avg, finite.average());
    }

    @Test public void averageTestInfinite() {
        // with n
        SquareSequence infinite = new SquareSequence();
        long[] assertInfinite = new long[]{0,1,4,9,16,25,36,49,64,81};
        int sum = 0;
        for(long each : assertInfinite)
            sum += each;
        double avg = (double)sum / (double)assertInfinite.length;
        int n = 10;
        Assertions.assertEquals(avg, infinite.average(n));

        // without n
        try{
            infinite.average();
            Assert.fail("Exception triggering fail");
        } catch(UnsupportedOperationException e) {}
    }

    @Test public void toArrayTest() {
        long[] assertFinite = new long[]{1,2,3,4};
        // finite sequence
        FiniteSequence finite = new FiniteSequence().of(1,2,3,4);
        Assertions.assertArrayEquals(assertFinite, finite.toArray(4),"Fail to array finite sequence. ");
        // infinite sequence
        SquareSequence infinite = new SquareSequence();
        long[] assertInfinite = new long[]{0,1,4,9};
        Assertions.assertArrayEquals(assertInfinite, infinite.toArray(4), "Fail to array finite sequence. ");
    }

    @Test public void resetTest() {
        FiniteSequence finite = new FiniteSequence().of(1,2,3,4);
        SquareSequence infinite = new SquareSequence();
        for(int i = 0; i < 4; i++)
            infinite.next();
        long[] assertBoth = new long[]{};
        finite.reset();
        // finite
        Assertions.assertArrayEquals(assertBoth, finite.finiteSequence);
        infinite.reset();
        // infinite
        Assertions.assertArrayEquals(assertBoth, infinite.squareSequence);
    }

}
