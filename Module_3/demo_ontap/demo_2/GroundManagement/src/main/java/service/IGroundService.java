package service;

import model.Ground;
import model.Status;
import model.TypeOffice;

import java.util.List;
import java.util.Map;

public interface IGroundService {
    List<TypeOffice> selectAllTypeOffice();

    List<Status> selectAllStatus();

    List<Ground> selectAllGround();

    Map<String , String> insertGround(Ground ground);

    Ground selectGround(String id);

    Map<String , String> updateGround(Ground ground);

    boolean deleteGround(String id);

    List<Ground> search(String typeOffice, String floors, String price);

    List<Integer> listFloors();
}
