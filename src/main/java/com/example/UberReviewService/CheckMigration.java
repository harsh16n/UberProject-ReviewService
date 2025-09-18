package com.example.UberReviewService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;

@Component
public class CheckMigration implements CommandLineRunner {

    @Override
    public void run(String... args) {
        try {
            ClassPathResource resource = new ClassPathResource("db/migration/V1__init_db.sql");
            if (resource.exists()) {
                System.out.println("✅ SUCCESS: Migration file found at: " + resource.getPath());
                System.out.println("File size: " + resource.contentLength() + " bytes");
            } else {
                System.out.println("❌ ERROR: Migration file NOT found!");
            }
        } catch (Exception e) {
            System.out.println("❌ ERROR: " + e.getMessage());
        }
    }
}
