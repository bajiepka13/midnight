package org.bajiepka.midnight.startup;

import lombok.extern.slf4j.Slf4j;
import org.bajiepka.midnight.domain.entity.Record;
import org.bajiepka.midnight.service.RecordService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Slf4j
@Component
public class ApplicationStartupRunner implements ApplicationRunner, ApplicationContextAware {

    @Autowired
    private RecordService recordService;

    private ApplicationContext ctx;

    @Autowired
    private GenericApplicationContext context;

    @PersistenceContext
    private EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        DataSource dataSource = (DataSource) ctx.getBean("dataSource");

        Record r = ctx.getBean(Record.class);
        r.setRecord("Создание компонентов spring Beans");
        recordService.save(r);

        log.info("Получаем все доступные записи");
        recordService.getAllRecords().stream().forEach(System.out::println);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
