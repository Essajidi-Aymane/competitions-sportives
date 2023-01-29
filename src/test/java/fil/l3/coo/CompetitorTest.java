package fil.l3.coo;

import fil.l3.coo.competitors.Competitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CompetitorTest {
    Competitor c1;
    Competitor c2;

    @BeforeEach
    public void init() {
        this.c1 = new Competitor("Tyson");
        this.c2 = new Competitor("Alex");
    }

    @Test
    public void getNameTest() {
        assertEquals("Tyson", c1.getName());
        assertNotEquals("Badr", c1.getName());
        assertEquals("Alex", c2.getName());
        assertNotEquals("Paul", c2.getName());
    }

    @Test
    public void getNbPointsTest() {
        assertEquals(0, c1.getNbPoints());
        assertEquals(0, c2.getNbPoints());
    }

    @Test
    public void addOnePointTest() {
        assertEquals(0, c1.getNbPoints());
        c1.addOnePoint();
        assertEquals(1, c1.getNbPoints());

        c1.addOnePoint();
        assertEquals(2, c1.getNbPoints());

        assertEquals(0, c2.getNbPoints());
        c2.addOnePoint();
        assertEquals(1, c2.getNbPoints());

        c2.addOnePoint();
        assertEquals(2, c2.getNbPoints());

    }

}
