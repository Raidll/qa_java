package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline = new Feline();


    @Test
    public void getFamilyTest(){
        Assert.assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getKittensWithoutArgumentsTest() {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void getKittensWithArgumentsTest() {
        Assert.assertEquals(5,feline.getKittens(5));
    }

    @Test
    public void eatMeatTest() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }
}
