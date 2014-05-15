package playground;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: Ananth
 * Date: 30/03/14
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
public class WebDriverExamples {

    public int subtract(int a, int b){
        int s = a-b;
        return s;
    }

    @Test
    public void subtractTest(){
        assertEquals(5,subtract(10,5));
    }

    @Test


}
