package pri.vo;

import java.io.Serializable;

/**
 * t_product
 *
 * @author
 */
public class TProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 商品id
     */
    private Long pId;
    /**
     * 商品名称
     */
    private String pName;
    /**
     * 商品描述
     */
    private String pDesc;
    /**
     * 库存
     */
    private Long pStock;

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDesc() {
        return pDesc;
    }

    public void setpDesc(String pDesc) {
        this.pDesc = pDesc;
    }

    public Long getpStock() {
        return pStock;
    }

    public void setpStock(Long pStock) {
        this.pStock = pStock;
    }
}