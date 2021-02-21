package utilidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Counter<T> {
    Map<T, Integer> conteo = new HashMap();

    public Counter(T[] arreglo){
        for (T elemento: arreglo){
            if (conteo.containsKey(elemento)){
                conteo.put(elemento, conteo.get(elemento) + 1 );
            } else {
                conteo.put(elemento, 1);
            }
        }
    }

    public Set<Map.Entry<T, Integer>> items(){
        return conteo.entrySet();
    }
}
