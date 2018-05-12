package com.zly.service.impl;

import com.github.pagehelper.PageHelper;
import com.zly.mapper.TbItemMapper;
import com.zly.pojo.TbItem;
import com.zly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zly11 on 2018/5/8.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private TbItemMapper itemMapper;

    @Override
    public List<TbItem> findItemByCid(Long cid,int pageNum) {
        PageHelper.startPage(pageNum, 5);
        return itemMapper.findItemByCid(cid);
    }

    @Override
    public List<TbItem> findItemDetalisByCid(Long id) {
        return itemMapper.findItemDetalis(id);
    }

    @Override
    public List<TbItem> findItemSimilar(Long id) {

        //推荐数量
        final int SimilarNum = 10;
        //原始 Item 下标
        int index = 0;

        List<TbItem> endList = new ArrayList<>();

        TbItem tbItem  = itemMapper.findItemById(id);

        //1,对产品品牌和价格进行提取
        String itemName = tbItem.getTitle().split(" ")[0];
        Long itemPrice = tbItem.getPrice();

        //2.对确定品牌名进行模糊搜索
        List<TbItem> tbItems = itemMapper.findItemByTitle(itemName);

        //3.对价格进行排序
        Collections.sort(tbItems, new Comparator<TbItem>() {
            @Override
            public int compare(TbItem o1, TbItem o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });
        //确定原始item下标
        for(TbItem item :tbItems){
            if (item.getId() == tbItem.getId()){
                break;
            }
            index+=1;
        }
        //对同品牌进行价格筛选
        for (int j = 1;j<=5;j++){
          //  System.out.println(j);
            if (index+j<tbItems.size()){
                if (tbItems.get(index+j).getPrice()-itemPrice < 1000)
                    endList.add(tbItems.get(index+j));
            }
            if (index-j>0){
        //        System.out.println(index-j);
                if (itemPrice - tbItems.get(index-j).getPrice()<1000){
                    System.out.println(tbItems.get(index-j).getId());
                    endList.add(tbItems.get(index-j));
                }
            }
        }

        if (endList.size()<SimilarNum){
            endList.addAll(itemMapper.findItemByPrice(itemPrice-1000,itemPrice+1000,SimilarNum-endList.size()));
        }
        return endList;
    }

    @Override
    public List<TbItem> findItemByKeyword(String title) {
        return itemMapper.findItemByTitle(title);
    }
}
