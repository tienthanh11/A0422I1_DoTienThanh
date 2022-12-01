package com.codegym.repository;

import com.codegym.model.Medical;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalRepository implements IMedicalRepository {
    private static List<Medical> medicals = new ArrayList<>();

    static {
        medicals.add(new Medical(1, "Nguyen Van A", "01-01-2001", "Nam",
                "Viet Nam", "123456789", "Wave ", "92N6 12345", "1", "1-1-2021"
                , "2-1-2021", "Quang Ngai", "Quang Nam", "Nui Thanh", "Tam Hoa", "Thon 5",
                "123456789", "nguyenvana@gmail.com", true, true
                , true, true, true, true, true, true,
                true, true));
    }

    @Override
    public List<Medical> findAll() {
        return medicals;
    }

    @Override
    public void update(Medical medical) {
        int lastId = 1;
        if (medicals.size() >= 1) {
            lastId = medicals.get(medicals.size() - 1).getId() + 1;
        }
        medical.setId(lastId);
        medicals.add(medical);
    }
}