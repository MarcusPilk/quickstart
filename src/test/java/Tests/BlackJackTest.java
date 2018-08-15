package Tests;

import Pages.BlackJack;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class BlackJackTest {
    BlackJack bjck;

    @BeforeClass
    public void setUp(){
        bjck = new BlackJack();
    }

    @Test
    public void TestPlay1(){
        assertEquals(21,bjck.play(12,21));
    }

    @Test
    public void TestPlay2(){
        assertEquals(21,bjck.play(22,21));
    }

    @Test
    public void TestPlay3(){
        assertEquals(21,bjck.play(21,21));
    }

    @Test
    public void TestPlay4(){
        assertEquals(21,bjck.play(21,12));
    }

    @Test
    public void TestPlay5(){
        assertEquals(21,bjck.play(21,22));
    }

    @Test
    public void TestPlayFail(){
        fail("Not yet implemented");
    }

    @Test
    public void TestPlayTrue(){
        assertTrue(bjck.play(12,11) == 12);
    }

    @Test
    public void TestBothFail(){
        assertEquals(0,bjck.play(22,22));
    }
}
