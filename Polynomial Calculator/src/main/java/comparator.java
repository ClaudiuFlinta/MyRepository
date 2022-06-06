import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class comparator implements Comparator<Monom>{

    @Override
    public int compare(Monom e1, Monom e2) {
        if(e1.getGrad() < e2.getGrad()){
            return 1;
        } else {
            return -1;
        }
    }
}