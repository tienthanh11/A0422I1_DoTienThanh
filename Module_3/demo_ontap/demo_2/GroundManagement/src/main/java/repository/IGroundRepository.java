package repository;

import model.Ground;
import model.Status;
import model.TypeOffice;

import java.sql.SQLException;
import java.util.List;

public interface IGroundRepository {
    List<TypeOffice> selectAllTypeOffice();

    List<Status> selectAllStatus();

    List<Ground> selectAllGround();

    boolean insertGround(Ground ground);

    Ground selectGround(String id);

    boolean updateGround(Ground ground);

    boolean deleteGround(String id);

    List<Ground> search(String typeOffice, String floors, String price);

    List<Integer> listFloors();
}
