package model.repository.icontract;

import model.bean.Contract;

import java.util.List;

public interface IContractRepository {
    List<Contract> selectAllContract();

    boolean insertContract(Contract contract);

    Contract selectContract(int id);

    boolean updateContract(Contract contract);

    boolean deleteContract(int id);
}
