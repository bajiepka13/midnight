package org.bajiepka.midnight.service;

import org.bajiepka.midnight.domain.entity.Record;
import org.bajiepka.midnight.repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public void save(Record r) {
        recordRepository.save(r);
    }
}
