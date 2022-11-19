package service.impl;

import model.Room;
import repositories.IRoomRepository;
import repositories.impl.RoomRepository;
import service.IRoomService;

import java.util.List;

public class RoomService implements IRoomService {
    IRoomRepository iRoomRepository = new RoomRepository();

    @Override
    public List<Room> findAll() {
        return iRoomRepository.findAll();
    }

    @Override
    public void create(Room room) {
        iRoomRepository.create(room);
    }

    @Override
    public boolean delete(int maPhongTro) {
        return iRoomRepository.delete(maPhongTro);
    }

    @Override
    public List<Room> search(String tenNguoiThue) {
        return iRoomRepository.search(tenNguoiThue);
    }
}
