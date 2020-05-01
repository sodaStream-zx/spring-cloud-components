package pri.mapper;


import pri.vo.TProduct;

public interface ProductMapper {
    int deleteByPrimaryKey(Long pId);

    int insert(TProduct record);

    int insertSelective(TProduct record);

    TProduct selectByPrimaryKey(Long pId);

    int updateByPrimaryKeySelective(TProduct record);

    int updateByPrimaryKey(TProduct record);

    Integer totalProduct();

    Integer subOne(Long pId);
}