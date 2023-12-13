package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<>();


    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("data is null");
        }
        //기존의 데이터가 존재하는가?
        Optional<T> prevData = dataList.stream().filter(
                it -> {
                    return it.getId().equals(data.getId());
                }
        ).findFirst();
        if (prevData.isPresent()) {
            //update
            dataList.remove(prevData.get());
            dataList.add(data);
        } else {
            //insert
            index++;
            //unique id
            data.setId(index);
            dataList.add(data);
        }
        return data;
    }

    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream().filter(it -> {
            return it.getId().equals(id);
        }).findFirst();
    }

    @Override
    public List<T> findAll() {
        //정렬 후 모든 데이터 리턴
        return dataList
                .stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(ID id) {
        Optional<T> findObject = dataList.stream().filter(
                it -> {
                    return it.getId().equals(id);
                }
        ).findFirst();
        if (findObject.isPresent()) {
            dataList.remove(findObject.get());
        }


    }

}
