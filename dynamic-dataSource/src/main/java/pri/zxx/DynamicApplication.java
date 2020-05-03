package pri.zxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-26-20:43
 */

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan
public class DynamicApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynamicApplication.class, args);
    }

}
