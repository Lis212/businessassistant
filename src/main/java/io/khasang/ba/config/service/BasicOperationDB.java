package io.khasang.ba.config.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BasicOperationDB {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getTableCreationStatus(){
        try {
            jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS public.cats\n" +
                    "(\n" +
                    "    id integer NOT NULL,\n" +
                    "    name character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    description character varying(255) COLLATE pg_catalog.\"default\",\n" +
                    "    color_id integer,\n" +
                    "    CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            jdbcTemplate.execute("select c.name from cats c where c.color_id = " +
                    "(select id from colors cl where cl.name = 'smoke');");
            return "Complete create";
        } catch (Exception e){
            return  "No complete " + e;
        }
    }

    public String getTableSelectStatus(){
        try {
            jdbcTemplate.execute("select c.name from cats c where c.color_id = " +
                    "(select id from colors cl where cl.name = 'smoke');");
            return "Complete select";
        } catch (Exception e){
            return  "No complete " + e;
        }
    }

    public String getTableInsertStatus(){
        try {
            jdbcTemplate.execute("insert into cats as c (id, name, description, color_id) " +
                    "values (1, 'Barsik', 'happy', 1)");
            return "Complete insert";
        } catch (Exception e){
            return  "No complete " + e;
        }
    }
}
