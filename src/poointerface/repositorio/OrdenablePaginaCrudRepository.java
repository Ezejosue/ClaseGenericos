package poointerface.repositorio;

public interface OrdenablePaginaCrudRepository<T> extends CrudRepositorio<T>, OrdenableRepositorio<T>, PaginableRepositorio<T>, ContableRepositorio {
}
