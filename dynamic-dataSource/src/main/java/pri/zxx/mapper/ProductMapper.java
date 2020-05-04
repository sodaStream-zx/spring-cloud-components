package pri.zxx.mapper;


import pri.zxx.annotion.PickDataSource;
import pri.zxx.vo.TProduct;

@PickDataSource(value = "hikari-slave")
public interface ProductMapper {
    int deleteByPrimaryKey(Long pId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Long pId);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);

    Integer totalProduct();


    Integer subOne(Long pId);

    @PickDataSource(value = "master")
    Integer subOneSlave(Long pId);
}