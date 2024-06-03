package ppss.ejercicio1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiPathTest {
    MultipathExample exam;
    int resReal;
    int resEsp;
    @Test
    public void test1(){
        exam = new MultipathExample();
        resEsp = 8 ;
        resReal = exam.multiPath1(3, 6, 2);
    }

    @Test
    public void test2(){
        exam = new MultipathExample();
        resEsp = 8 ;
        resReal = exam.multiPath1(6, 2, 2);
    }

    @Test
    public void test3(){
        exam = new MultipathExample();
        resEsp = 16;
        resReal = exam.multiPath2(6, 4, 6);
    }

    @Test
    public void test4(){
        exam = new MultipathExample();
        resEsp = 2 ;
        resReal = exam.multiPath2(4, 4, 2);
    }
    @Test
    public void test5(){
        exam = new MultipathExample();
        resEsp = 2;
        resReal = exam.multiPath2(6, 7, 2);
    }
    @Test
    public void test6(){
        exam = new MultipathExample();
        resEsp = 16;
        resReal = exam.multiPath3(6, 4, 6);
    }

    @Test
    public void test7(){
        exam = new MultipathExample();
        resEsp = 2;
        resReal = exam.multiPath3(4, 7, 2);
    }
}
