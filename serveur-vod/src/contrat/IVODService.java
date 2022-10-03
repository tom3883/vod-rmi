package contrat;

import java.util.List;

public interface IVODService {
    List<Integer> viewCatalog();
    int playmovie(String isbn, int a);
}
