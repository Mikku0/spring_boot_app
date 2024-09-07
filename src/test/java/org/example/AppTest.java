package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {


    @Test
    public void shouldAnswerWithTrue() {
        App testApp = new App();
        int result = testApp.Calc(10, 50);

        Assertions.assertEquals(60, result);
    }
}
