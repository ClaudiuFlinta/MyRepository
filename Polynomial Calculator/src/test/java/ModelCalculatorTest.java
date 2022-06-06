import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ModelCalculatorTest {

    ModelCalculator model = new ModelCalculator();
    @Test
    void testSplitPlus(){

        String s  = "x^2-4x^1+x^0";
        Polinom p = new Polinom();
        Polinom rez = new Polinom();
        Monom m1 = new Monom(1,2);
        Monom m2 = new Monom(-4,1);
        Monom m3 = new Monom(1,0);
        rez.addMonom(m1);
        rez.addMonom(m2);
        rez.addMonom(m3);
        model.transform(s,p);
        assertEquals(p.toString(),rez.toString());


    }
    @Test
    void testSplitMinus(){

        ModelCalculator model = new ModelCalculator();
        String s  = "-x^3-4x^1-2x^0";
        Polinom p = new Polinom();
        Polinom rez = new Polinom();
        Monom m1 = new Monom(-1,3);
        Monom m2 = new Monom(-4,1);
        Monom m3 = new Monom(-2,0);
        rez.addMonom(m1);
        rez.addMonom(m2);
        rez.addMonom(m3);
        model.transform(s,p);
        assertEquals(p.toString(),rez.toString());


    }

    @Test
    void addTwoPolinoms(){

        //-x^3-4x^1-2x^0
        //-4x^7+x^1+22x^0
        //-4x^7-x^3-3x^1+20x^0
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom rez = new Polinom();
        Polinom referinta = new Polinom();
        Monom m1 = new Monom(-1,3);
        Monom m2 = new Monom(-4,1);
        Monom m3 = new Monom(-2,0);
        Monom m4 = new Monom(-4,7);
        Monom m5 = new Monom(1,1);
        Monom m6 = new Monom(22,0);

        Monom m7 = new Monom(-4,7);
        Monom m8 = new Monom(-1,3);
        Monom m9 = new Monom(-3,1);
        Monom m10 = new Monom(20,0);

        referinta.addMonom(m7);
        referinta.addMonom(m8);
        referinta.addMonom(m9);
        referinta.addMonom(m10);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        p2.addMonom(m6);

        rez = model.add(p1,p2);
        assertEquals(referinta.toString(),rez.toString());

    }

    @Test
    void substractTwoPolinoms(){

        //-x^3-4x^1-2x^0
        //-4x^7+x^1+22x^0
        //4x^7-x^3-5x^1-24x^0
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom rez = new Polinom();
        Polinom referinta = new Polinom();
        Monom m1 = new Monom(-1,3);
        Monom m2 = new Monom(-4,1);
        Monom m3 = new Monom(-2,0);
        Monom m4 = new Monom(-4,7);
        Monom m5 = new Monom(1,1);
        Monom m6 = new Monom(22,0);

        Monom m7 = new Monom(4,7);
        Monom m8 = new Monom(-1,3);
        Monom m9 = new Monom(-5,1);
        Monom m10 = new Monom(-24,0);

        referinta.addMonom(m7);
        referinta.addMonom(m8);
        referinta.addMonom(m9);
        referinta.addMonom(m10);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        p2.addMonom(m6);

        rez = model.substraction(p1,p2);
        assertEquals(referinta.toString(),rez.toString());

    }

    @Test
    void divideTwoPolinoms(){

        //x^2+x^1+x^0
        //x^1+2x^0
        //cat x^1-x^0 rest 3x^0
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom cat = new Polinom();
        Polinom rest = new Polinom();
        List<Polinom> rez = new ArrayList<Polinom>();
        List<Polinom> referinta = new ArrayList<Polinom>();
        Monom m1 = new Monom(1,2);
        Monom m2 = new Monom(1,1);
        Monom m3 = new Monom(1,0);

        Monom m4 = new Monom(1,1);
        Monom m5 = new Monom(2,0);

        //cat
        Monom m6 = new Monom(1,1);
        Monom m7 = new Monom(-1,0);
        //rest
        Monom m8 = new Monom(3,0);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);

        cat.addMonom(m6);
        cat.addMonom(m7);

        rest.addMonom(m8);

        referinta.add(cat);
        referinta.add(rest);

        rez = model.division(p1,p2);
        assertEquals(referinta.toString(),rez.toString());

    }

    @Test
    void multiplyTwoPolinoms(){

        //-x^3-4x^1-2x^0
        //-4x^7+x^1+22x^0
        //4x^10+16x^8+8x^7-x^4-22x^3-4x^2-90x^1-44x^0
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom rez = new Polinom();
        Polinom referinta = new Polinom();
        Monom m1 = new Monom(-1,3);
        Monom m2 = new Monom(-4,1);
        Monom m3 = new Monom(-2,0);
        Monom m4 = new Monom(-4,7);
        Monom m5 = new Monom(1,1);
        Monom m6 = new Monom(22,0);

        Monom m7 = new Monom(4,10);
        Monom m8 = new Monom(16,8);
        Monom m9 = new Monom(8,7);
        Monom m10 = new Monom(-1,4);
        Monom m11 = new Monom(-22,3);
        Monom m12 = new Monom(-4,2);
        Monom m13 = new Monom(-90,1);
        Monom m14 = new Monom(-44,0);

        referinta.addMonom(m7);
        referinta.addMonom(m8);
        referinta.addMonom(m9);
        referinta.addMonom(m10);
        referinta.addMonom(m11);
        referinta.addMonom(m12);
        referinta.addMonom(m13);
        referinta.addMonom(m14);

        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);

        p2.addMonom(m4);
        p2.addMonom(m5);
        p2.addMonom(m6);

        rez = model.multiplication(p1,p2);
        assertEquals(referinta.toString(),rez.toString());

    }

    @Test
    void derivationPolinom(){

        //-x^7+x^6-22x^2+210x^0
        //-7x^6+6x^5-44x^1
        Polinom p = new Polinom();
        Monom m1 = new Monom(-1,7);
        Monom m2 = new Monom(1,6);
        Monom m3 = new Monom(-22,2);
        Monom m4 = new Monom(210,0);

        p.addMonom(m1);
        p.addMonom(m2);
        p.addMonom(m3);
        p.addMonom(m4);

        Polinom rezultat = new Polinom();
        rezultat = model.derivation(p);

        Polinom referinta = new Polinom();

        Monom m5 = new Monom(-7,6);
        Monom m6 = new Monom(6,5);
        Monom m7 = new Monom(-44,1);

        referinta.addMonom(m5);
        referinta.addMonom(m6);
        referinta.addMonom(m7);

        assertEquals(referinta.toString(), rezultat.toString());

    }

    @Test
    void intergationPolinom(){

        //-x^7+x^6-22x^2+210x^0
        //-0.125x^8+0.14285714285714285x^7-7.333333333333333x^3+210x^1
        Polinom p = new Polinom();
        Monom m1 = new Monom(-1,7);
        Monom m2 = new Monom(1,6);
        Monom m3 = new Monom(-22,2);
        Monom m4 = new Monom(210,0);

        p.addMonom(m1);
        p.addMonom(m2);
        p.addMonom(m3);
        p.addMonom(m4);

        Polinom rezultat = new Polinom();
        rezultat = model.integration(p);

        Polinom referinta = new Polinom();

        Monom m5 = new Monom(-0.125,8);
        Monom m6 = new Monom(0.14285714285714285,7);
        Monom m7 = new Monom(-7.333333333333333,3);
        Monom m8 = new Monom(210,1);

        referinta.addMonom(m5);
        referinta.addMonom(m6);
        referinta.addMonom(m7);
        referinta.addMonom(m8);

        assertEquals(referinta.toString(), rezultat.toString());

    }


}