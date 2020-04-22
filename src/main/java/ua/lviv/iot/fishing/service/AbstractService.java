package ua.lviv.iot.fishing.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public abstract class AbstractService<T> {

    protected abstract JpaRepository<T, Integer> getRepository();

    public ArrayList<T> findAll() {
        ArrayList<T> list = (ArrayList<T>) getRepository().findAll();
        for (T t : list) {
            System.out.println(t);
        }
        return list;
    }

    public T findById(Integer id) {
        if (getRepository().existsById(id)) {
            System.out.println(getRepository().findById(id).get());
            T t = (T) getRepository().getOne(id);
            return t;
        }
        return null;
    }

    public boolean deleteById(Integer id) {
        if (getRepository().existsById(id)) {
            getRepository().deleteById(id);
            return true;
        }
        return false;
    }

    public void update(T t) {
        getRepository().save(t);
    }

    public T create(T t) {
        return getRepository().save(t);
    }

    public boolean checkIfExists(Integer Id) {
        return getRepository().existsById(Id);
    }
}
