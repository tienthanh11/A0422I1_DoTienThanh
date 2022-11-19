package repositories;

import model.Room;

import java.util.List;

public interface IRoomRepository {
    List<Room> findAll();

    boolean create(Room room);

    boolean delete(int maPhongTro);

    List<Room> search(String tenNguoiThue);
}
