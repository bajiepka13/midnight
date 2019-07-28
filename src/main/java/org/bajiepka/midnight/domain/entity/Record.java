package org.bajiepka.midnight.domain.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "records", schema = "public")
@Getter
@ToString
@Slf4j
public class Record implements InitializingBean, DisposableBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID uuid;

    @Setter
    @Column(name = "record")
    private String record;

    @Column(name = "init_at")
    private LocalDateTime initedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    void setup() {
        this.createdAt = LocalDateTime.now();
    }

    @PostConstruct
    private void setUp() {
        log.info("Создана новая запись.", Record.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.initedAt = LocalDateTime.now();
    }

    @Override
    public void destroy() throws Exception {
        log.info("bean записи уничтожается");
    }
}
