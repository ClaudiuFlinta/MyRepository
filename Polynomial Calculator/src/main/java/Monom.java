import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Monom  {

    private double coeficient;
    private int grad;

    public Monom(double coeficient, int grad) {
        this.coeficient = coeficient;
        this.grad = grad;
    }
    /*@Override
    public int compareTo(Monom o) {
        if(this.getGrad() > o.getGrad())
            return 1;
        else
            return -1;
    }*/

    public double getCoeficient() {
        return coeficient;
    }

    public int getGrad() {
        return grad;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }
    @Override
    public String toString() {
        return "Monom{" +
                "grad=" + grad +
                ", coeficient=" + coeficient +
                '}';
    }

}
