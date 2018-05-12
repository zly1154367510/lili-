package com.zly.service.impl;

import com.zly.mapper.TbItemCatMapper;
import com.zly.pojo.TbItemCat;
import com.zly.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/7.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<TbItemCat> getParenItemCat() {
        return tbItemCatMapper.getParentItemCat();
    }

    public List<TbItemCat> getItemCatParen(){
        //获得第一层父节点
        List<TbItemCat> oneParenList = this.getParenItemCat();
        List<TbItemCat> oneParenList1 =  isLeaf(oneParenList);
        return oneParenList1;

    }


    private List<TbItemCat> isLeaf(List<TbItemCat> list){

        for (TbItemCat ic :list){
            List<TbItemCat> nodeList = tbItemCatMapper.isLeatNode(ic.getId());
            if (nodeList.size() != 0){
                //指针指向下一节点
                ic.setSubList(nodeList);
                isLeaf(nodeList);
            }
        }
        return list;
    }

    @Override
    public List<TbItemCat> getSunItem(Long pid) {
        return tbItemCatMapper.isLeatNode(pid);
    }
}
