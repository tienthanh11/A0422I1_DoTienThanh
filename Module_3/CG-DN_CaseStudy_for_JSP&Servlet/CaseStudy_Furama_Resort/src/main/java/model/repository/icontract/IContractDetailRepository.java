package model.repository.icontract;

import model.bean.ContractDetail;

import java.util.List;

public interface IContractDetailRepository {
    List<ContractDetail> selectAllContractDetail();

    boolean insertContractDetail(ContractDetail contractDetail);
}
