import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.*;

public class ModelCalculator {

    private String finalResult;



    public void transform(String s, Polinom p) {

        s = s.replaceAll("-", "+-");
        if(s.charAt(0) == '+') {
            s=s.substring(1);
        }
        s = s.replaceAll("\\^","");

        String[] arr = s.split("\\+");


        for(String i : arr) {

            String[] split = i.split("x");
            if(split[0].isEmpty())
            {
                split[0]="1";
            }
            if(split[0].equals("-"))
            {
                split[0] = "-1";
            }
            double x = Double.parseDouble(split[0]);
            //x = Math.round(x*100.0)/100.0;
            int y = Integer.parseInt(split[1]);

            Monom m = new Monom(x,y);
            p.addMonom(m);

        }

    }

    public Polinom add (Polinom p1, Polinom p2){

        Polinom rezultat = new Polinom();
        int mini = 0;
        int size_1 = p1.getSize();
        int size_2 = p2.getSize();

        int i=0;
        int j=0;
        while(i<size_1 && j<size_2){

            int a,b;
            a=p1.getMonom(i).getGrad();
            b=p2.getMonom(j).getGrad();
            if(a > b){

                rezultat.addMonom(p1.getMonom(i));
                i++;

            }
            else if(a < b){

                rezultat.addMonom(p2.getMonom(j));
                j++;

            }
            else{

                Monom m = new Monom(p1.getMonom(i).getCoeficient() + p2.getMonom(j).getCoeficient(),p1.getMonom(i).getGrad());
                rezultat.addMonom(m);
                i++;
                j++;

            }
        }

        while(i<size_1){

            rezultat.addMonom(p1.getMonom(i));
            i++;
        }

        while(j<size_2){

            rezultat.addMonom(p2.getMonom(j));
            j++;
        }

        return rezultat;
    }

    public Polinom substraction (Polinom p1, Polinom p2){

        Polinom rezultat = new Polinom();
        int size_1 = p1.getSize();
        int size_2 = p2.getSize();

        int i=0;
        int j=0;
        while(i<size_1 && j<size_2){

            int a,b;
            a=p1.getMonom(i).getGrad();
            b=p2.getMonom(j).getGrad();
            if(a > b){

                rezultat.addMonom(p1.getMonom(i));
                i++;

            }
            else if(a < b){

                double q = p2.getMonom(j).getCoeficient()*(-1);
                if(q != 0.0) {
                    Monom m = new Monom(q, p2.getMonom(j).getGrad());
                    rezultat.addMonom(m);
                }
                j++;

            }
            else{

                double q = p1.getMonom(i).getCoeficient() - p2.getMonom(j).getCoeficient();
                if(q!=0.0) {
                    Monom m = new Monom(p1.getMonom(i).getCoeficient() - p2.getMonom(j).getCoeficient(), p1.getMonom(i).getGrad());
                    rezultat.addMonom(m);
                }
                i++;
                j++;

            }
        }

        while(i<size_1){

            rezultat.addMonom(p1.getMonom(i));
            i++;
        }

        while(j<size_2){

            double q = p2.getMonom(j).getCoeficient()*(-1);
            if(q != 0.0) {
                Monom m = new Monom(q, p2.getMonom(j).getGrad());
                rezultat.addMonom(m);
            }
            j++;
        }

        return rezultat;
    }

    public Polinom multiplication (Polinom p1, Polinom p2) {

        Polinom rezultat = new Polinom();
        Polinom aux = new Polinom();
        int size_1 = p1.getSize();
        int size_2 = p2.getSize();
        double a;
        int b;
        int ok = 0;

        for(int i=0; i<size_1; i++)
            for(int j=0; j<size_2; j++){

                Monom m = new Monom(p1.getMonom(i).getCoeficient() * p2.getMonom(j).getCoeficient(), p1.getMonom(i).getGrad() + p2.getMonom(j).getGrad());
                rezultat.addMonom(m);
            }

        rezultat.sortare();

        int size_3 = rezultat.getSize();
        int i = 0;
        int j = 1;
        while(j<size_3){

            a = rezultat.getMonom(i).getCoeficient();
            b = rezultat.getMonom(i).getGrad();
            while( j<size_3 && rezultat.getMonom(i).getGrad() == rezultat.getMonom(j).getGrad()){

                a += rezultat.getMonom(j).getCoeficient();
                j++;

            }

            i=j;
            j++;
            Monom m = new Monom(a,b);
            aux.addMonom(m);
        }

        if(i == size_3 - 1){

            a = rezultat.getMonom(i).getCoeficient();
            b = rezultat.getMonom(i).getGrad();
            Monom m = new Monom(a,b);
            aux.addMonom(m);

        }
        return aux;
    }

    public Polinom multiplyByMonom(Polinom p, Monom m){

        Polinom rezultat = new Polinom();

        for(int i =0 ;i < p.getSize() ; i++){

            double a;
            int b;
            a = p.getMonom(i).getCoeficient() * m.getCoeficient();
            b = p.getMonom(i).getGrad() + m.getGrad();
            Monom aux = new Monom(a,b);
            rezultat.addMonom(aux);

        }

        return rezultat;

    }
    public List<Polinom> division(Polinom d, Polinom i){

        double a = 0.0;
        int b = 0;
        List<Polinom> rez = new ArrayList<Polinom>();
        Polinom c = new Polinom();
        while(d.getMonom(0).getGrad() >= i.getMonom(0).getGrad()){

            Monom md = d.getMonom(0);
            Monom mi = i.getMonom(0);
            a =  md.getCoeficient() / mi.getCoeficient();
            b = md.getGrad() - mi.getGrad();
            Monom mc = new Monom(a,b);
            c.addMonom(mc);

            Polinom aux = multiplyByMonom(i,mc);
            d = substraction(d,aux);

        }
        rez.add(c);
        rez.add(d);
        return rez;
    }

    public Polinom derivation(Polinom p){

        Polinom rezultat = new Polinom();
        double a;
        int b;
        for(int i=0; i<p.getSize(); i++){

            a = p.getMonom(i).getCoeficient();
            b = p.getMonom(i).getGrad();
            a = a*b;
            b = b-1;
            if(b>=0) {
                Monom m = new Monom(a, b);
                rezultat.addMonom(m);
            }

        }

        return rezultat;

    }

    public Polinom integration(Polinom p){

        Polinom rezultat = new Polinom();
        double a;
        int b;
        for(int i=0; i<p.getSize(); i++){

            a = p.getMonom(i).getCoeficient();
            b = p.getMonom(i).getGrad();
            a = a/(b+1);
            b = b+1;
            Monom m = new Monom(a,b);
            rezultat.addMonom(m);

        }

        return rezultat;

    }

    public String displayResult(Polinom p) {

        finalResult="";
        for(int i=0; i<p.getSize(); i++){

            if(p.getMonom(i).getCoeficient() != 0)
                finalResult += p.getMonom(i).getCoeficient() +"x^" + p.getMonom(i).getGrad() + " + ";
        }

        //sterg +ul de pe ultima pozitie
        finalResult = finalResult.substring(0,finalResult.length()-2);
        return finalResult;
    }

}
