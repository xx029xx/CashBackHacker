package ru.netology;

//import org.testng.annotations.Test;
import static org.junit.Assert.*;
//import static org.testng.Assert.*;
public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @org.junit.Test
    public void testBoundaryValues() {
        org.junit.Assert.assertThrows(RuntimeException.class, () -> {
            service.remain(-1);
        });
    }

    @org.junit.Test
    public void testBoundaryValuesAmountMin() {
        org.junit.Assert.assertEquals(1000, service.remain(0));
    }

    @org.junit.Test
    public void testBoundaryValuesAmount() {
        org.junit.Assert.assertEquals(999, service.remain(1));
    }

    @org.junit.Test
    public void testBoundaryValuesAmountMax() {
        org.junit.Assert.assertEquals(1, service.remain(999));
    }

    @org.junit.Test
    public void testBoundaryValuesMax2() {
        org.junit.Assert.assertEquals(0, service.remain(1000));
    }

    @org.junit.Test
    public void testBoundaryValues2() {
        org.junit.Assert.assertEquals(999, service.remain(1001));
    }

    @org.junit.Test
    public void testRemainCriticalPath() {
        org.junit.Assert.assertEquals(600, service.remain(400));
    }
}