package poointerface.repositorio;

import poointerface.modelo.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstracListRepositorio<T extends BaseEntity> implements OrdenablePaginaCrudRepository<T> {
    protected List<T> dataSource;

    public AbstracListRepositorio() {
        this.dataSource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return dataSource;
    }

    @Override
    public T porId(Integer id) {
        for (T t : dataSource) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void crear(T t) {
        dataSource.add(t);
    }

    @Override
    public void editar(T t) {
        T t1 = porId(t.getId());
        if (t1 != null) {
            t1 = t;
        }
    }

    @Override
    public void eliminar(Integer id) {
        dataSource.removeIf(t -> t.getId().equals(id));
    }


    @Override
    public List<T> listar(int desde, int hasta) {
        return dataSource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return dataSource.size();
    }

}
