
package uuu.totalbuy.model;

import java.util.List;
import uuu.totalbuy.domain.TotalBuyException;
//K型態String,T類別
public interface DAOInterface<K, T> {
    //新增、修改、移除
    void insert(T data) throws TotalBuyException;
    void update(T data) throws TotalBuyException;
    void delete(T data) throws TotalBuyException;
    public T get(K id) throws TotalBuyException;
    //加abstract必須要實作
    public abstract List<T> getAll() throws TotalBuyException;
    
}
