package pri.zxx.service;

import org.springframework.stereotype.Service;
import pri.zxx.mapper.ProductMapper;
import pri.zxx.vo.TProduct;

import javax.annotation.Resource;

/**
 * @author Twilight
 * @desc
 * @createTime 2020-05-02-2:24
 */
@Service
public class ProductService {
    @Resource
    private ProductMapper productMapper;

    public Integer productTotal() {
        return productMapper.totalProduct();
    }

    public TProduct orderOne(Long pId) {
        return productMapper.selectByPrimaryKey(pId);
    }

    public Integer subOne(Long pId) {
        return productMapper.subOne(pId);
    }

    public Integer subOnesALVE(Long pId) {
        return productMapper.subOneSlave(pId);
    }
}
