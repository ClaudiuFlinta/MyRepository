import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Polinom {

    private LinkedList<Monom> polinom;

    public Polinom()
    {
        polinom = new LinkedList<>();
    }

    public void addMonom(Monom m)
    {
        polinom.add(m);
    }

    public int getSize(){
        return polinom.size();
    }
    public Monom getMonom(int i) {
        return polinom.get(i);
    }

    @Override
    public String toString() {
        return "Polinom{" +
                "polinom=" + polinom +
                '}';
    }

    public void sortare(){

        Collections.sort(polinom,new comparator());

    }
}
