package lyons.goods.service;

import java.util.ArrayList;
import java.util.List;

import lyons.dao.GoodsDao;
import lyons.goods.entity.Goods;

/**
 * 
 * 商品服务处理逻辑类
 * 
 * @author  (Lyons)zhanglei
 * 
 */
public class GoodsServiceImpl implements GoodsService
{
    GoodsDao goodsDao = new GoodsDao();
    
    /**
     * 
     * 查询商品服务实现类
     * 查询全部商品列表
     * @return
     */
    @Override
    public List<Goods> queryList()
    {
        return goodsDao.queryGoods();
    }
    
    /**
     * 
     * 查询商品服务实现类
     * 根据关键字查询
     * @return
     */
    @Override
    public List<Goods> queryGoodsByKey(String keyWord)
    {
        return goodsDao.queryGoodsByKey(keyWord);
    }

    /**
     * 
     * 查询商品信息 
     * （关键字||分类）or（关键字&&分类）
     * @return
     */
    public List<Goods> queryGoodsByKeyClassify(String keyWord, String goodsClassify)
    {
        Goods goodsList = null;
        goodsList = new Goods();
        
        if (((goodsClassify == null || "".equals(goodsClassify.trim()))
                &&(keyWord == null || "".equals(keyWord))))
        {
            return new ArrayList<Goods>(); //用户关键字与分类都没有输入的时候返回空集合
        }
        
        if (!(goodsClassify == null || "".equals(goodsClassify.trim())))
        {
            goodsList.setCommodity_id(Integer.parseInt(goodsClassify));
        }
        if (!(keyWord == null || "".equals(keyWord.trim())))
        {
            goodsList.setCommodity_name(keyWord);
        }
        
        return goodsDao.queryGoodsByKeyClassify(goodsList);
    }
    
    
    
}
