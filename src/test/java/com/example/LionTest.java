package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertThrows;


@RunWith(MockitoJUnitRunner.class)
public class LionTest {


    Lion lion;


    @Before
    public void createLionObject() throws Exception {
        this.lion = new Lion("Самец", feline);
    }
    @Mock
    Feline feline = new Feline();

    @Test
    public void getKittensTest() {
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void getFoodTest() throws Exception {
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void createLionObjectWithInvalidSex() throws Exception {
        assertThrows(Exception.class, () -> new Lion("wrong", feline));
    }


}
