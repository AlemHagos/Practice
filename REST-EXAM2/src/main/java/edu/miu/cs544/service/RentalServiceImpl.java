package edu.miu.cs544.service;
import edu.miu.cs544.dao.ContractDao;
import edu.miu.cs544.dao.PaymentDao;
import edu.miu.cs544.dao.ResidenceDao;
import edu.miu.cs544.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class RentalServiceImpl implements RentalService {
    @Resource
    private ResidenceDao residenceDao;

    @Resource
    private ContractDao contractDao;

    @Resource
    private PaymentDao paymentDao;

    @Override
    public List<Residence> getResidences() {
        return residenceDao.findAll();
    }

    @Override
    public Integer addHouse(House house, Address address) {
        house.setAddress(address);
        return residenceDao.save(house).getId();
    }

    @Override
    public boolean deleteResidence(Integer residenceId) {
       /** List<Residence> withActiveContracts = residenceDao.findByIdAndContractActive(residenceId,true);
           if (withActiveContracts.size()>0)
            return false;
            residenceDao.deleteById(residenceId);
           return true;
        */
        House house = (House) residenceDao.findById(residenceId).orElse(null);
        List<Contract>contracts = house.getContracts();
        for (Contract cont : contracts){
           if (cont.isActive() == true)
               return false;
        }
        residenceDao.deleteById(residenceId);
        return true;
    }

    @Override
    public Long updateContract(Long contractId, Contract newContract) {
        Contract contract = contractDao.getById(contractId);
        contract.setStart(newContract.getStart());
        contract.setEnd(newContract.getEnd());
        contract.setAmount(newContract.getAmount());
        contract.setActive(newContract.isActive());
        return contractDao.save(contract).getId();

    }

    @Override
    public List<Payment> underPayments(double amount) {
        return paymentDao.findByAmountLessThan(amount);
    }
}
