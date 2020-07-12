package com.dhfl.OnlinePaymentGatewayDataDump.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;

@Repository
public interface DHFLCustomersDataRepo extends CrudRepository<DHFLCustomersEntity, String>{

}
