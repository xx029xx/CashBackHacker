package ru.netology;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class CashbackHackServiceTest {
    CashbackHackService service = new CashbackHackService();

    @org.testng.annotations.Test
    public void testBoundaryValues() {
        org.testng.Assert.assertThrows(RuntimeException.class, () -> {
            service.remain(-1);
        });
    }

    @org.testng.annotations.Test
    public void testBoundaryValuesAmountMin() {
        org.testng.Assert.assertEquals(service.remain(0), 1000);
    }

    @org.testng.annotations.Test
    public void testBoundaryValuesAmount() {
        org.testng.Assert.assertEquals(service.remain(1), 999);
    }

    @org.testng.annotations.Test
    public void testBoundaryValuesAmountMax() {
        org.testng.Assert.assertEquals(service.remain(999), 1);
    }

    @org.testng.annotations.Test
    public void testBoundaryValuesMax2() {
        org.testng.Assert.assertEquals(service.remain(1000), 0);
    }

    @org.testng.annotations.Test
    public void testBoundaryValues2() {
        org.testng.Assert.assertEquals(service.remain(1001), 999);
    }

    @org.testng.annotations.Test
    public void testRemainCriticalPath() {
        org.testng.Assert.assertEquals(service.remain(400), 600);
    }
}