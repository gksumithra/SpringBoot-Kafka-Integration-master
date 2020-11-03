package com.application.kafkaspringbootdemo.KafkaController;

import com.application.kafkaspringbootdemo.kafkaRepository.PodownloadRepository;
import com.application.kafkaspringbootdemo.model.PoDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@RequestMapping("/root/podownload")
public class PoDownloadController {
    @Autowired
    private PodownloadRepository poInfoRepo;
    @GetMapping("/{poNumber}")
    public Optional<PoDetails> getPOById(@PathVariable int poNumber)

    {
        return poInfoRepo.findById(poNumber);
    }

}
