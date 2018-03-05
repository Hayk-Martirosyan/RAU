package day4;


/**
 * @author hayk.martirosyan
 * @version 1.0
 *
 * Sample class for javadoc presentation
 *
 */
public class JavadocSample {

    /**
     * holds value of g
     * @see <a href="https://en.wikipedia.org/wiki/Gravity_of_Earth">Gravitational acceleration</a>
     */
    private static final double G = 9.8;


    /**
     *  Calculates {@code  <a   + b>}
     * @param a <strong>description</strong> of a
     * @param b description of b
     * @return sum of a+b
     */
    public int sum(int a, int b){

        /*
            regular comment

         */
        //another comment
        return a+b;

    }
}
