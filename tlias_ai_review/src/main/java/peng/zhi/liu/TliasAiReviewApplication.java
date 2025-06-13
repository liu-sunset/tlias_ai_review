package peng.zhi.liu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TliasAiReviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasAiReviewApplication.class, args);
    }

}
