package top.yangwulang;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import top.yangwulang.swings.ui.CustomizeJavaFrame;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }
    @Test
    public void testCustomizeJavaFrame(){
        CustomizeJavaFrame customizeJavaFrame = new CustomizeJavaFrame();
        customizeJavaFrame.setVisible(true);
    }
}
