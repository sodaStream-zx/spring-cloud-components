package pri.zxx.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.zxx.service.ProductService;
import pri.zxx.vo.TProduct;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-04-19-10:33
 */
@RestController
@RequestMapping("/dynamic")
@Api(tags = "动态数据源测试")
public class ProducerController {

    final Object mutx = new Object();
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProductService productService;


    /**
     * 调用消费者接口
     */
    @GetMapping(value = "/order/{pId}")
    @ApiOperation(value = "下单slave")
    public String orderOne(@PathVariable(value = "pId") Long pId) {
        TProduct product = productService.orderOne(pId);
        if (product.getpStock() > 0) {
            Integer integer = productService.subOne(pId);
            if (integer > 0) {
                return "秒杀失败";
            }
        }
        return "秒杀成功";
    }

    /**
     * 调用消费者接口
     */
    @GetMapping(value = "/order2/{pId}")
    @ApiOperation(value = "下单master")
    public String orderOneSlave(@PathVariable(value = "pId") Long pId) {
        TProduct product = productService.orderOne(pId);
        if (product.getpStock() > 0) {
            Integer integer = productService.subOnesALVE(pId);
            if (integer > 0) {
                return "秒杀失败";
            }
        }
        return "秒杀成功";
    }
}
