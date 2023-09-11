package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class CreateLionObjectTest {

    private final String lionSex;
    private final boolean lionHasMane ;

    private Lion lion;

    public CreateLionObjectTest(String lionSex, boolean lionHasMane) {
        this.lionSex = lionSex;
        this.lionHasMane = lionHasMane;
    }



    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]  {
                {"Самец", true},
                {"Самка", false},
                // передаю true во втором пареметре, чтобы компилятор не выдал ошибку. Заведомо известно, что значение у lionHasMane не будет задано, так как объект Lion не будет создан
                {"Пол не опознан", true},
        };
    }

    @Mock
    Feline feline = new Feline();



    @Test
    public void createLionObjectWhithoutSex() throws Exception {
        try {
            this.lion = new Lion(lionSex, feline);
            Assert.assertEquals(lionHasMane, lion.doesHaveMane());
        } catch (Exception e) {
            Assert.assertEquals(null, this.lion);
            Assert.assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}
