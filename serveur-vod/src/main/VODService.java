package main;

import contrat.IVODService;

import java.util.List;

public class VODService implements IVODService {
    @Override
    public List<Integer> viewCatalog() {
        return null;
    }

    @Override
    public int playmovie(String isbn, int a) {
        return 0;
    }
}
