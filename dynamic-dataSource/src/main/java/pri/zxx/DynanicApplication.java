package pri.zxx;

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
public class DynanicApplication {
    public static void main(String[] args) {
        SpringApplication.run(DynanicApplication.class, args);
    }

}
