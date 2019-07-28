package org.bajiepka.midnight.repository;

import org.bajiepka.midnight.domain.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecordRepository extends JpaRepository<Record, UUID> {
}
