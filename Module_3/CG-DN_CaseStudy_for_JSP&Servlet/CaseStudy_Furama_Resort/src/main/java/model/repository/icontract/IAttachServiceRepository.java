package model.repository.icontract;

import model.bean.AttachService;

import java.util.List;

public interface IAttachServiceRepository {
    List<AttachService> selectAllAttachService();
}
