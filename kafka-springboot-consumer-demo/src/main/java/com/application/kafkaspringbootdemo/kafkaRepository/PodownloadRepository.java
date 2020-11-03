package com.application.kafkaspringbootdemo.kafkaRepository;

import com.application.kafkaspringbootdemo.model.PoDetails;
import org.springframework.data.repository.CrudRepository;

public interface PodownloadRepository  extends CrudRepository<PoDetails,Integer> {

}
