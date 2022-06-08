package com.saas.Ben;

import org.springframework.data.domain.Page;

public class PageInfo<T> {

    private Integer index=1; //当前页
    private Integer number; //每页显示条数
    private Integer countnumber; //总数

    private Integer countindex;//总页数 通过计算 总数和显示条数得来

    private Page<T> list;



    public void setIndex(Integer index) {
        this.index = index;
    }
    public Integer getIndex() {
        return index;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCountnumber() {
        return countnumber;
    }

    public void setCountnumber(Integer countnumber) {
        this.countnumber = countnumber;
    }

    public Integer getCountindex() {
        this.countindex=this.countnumber%number==0?countnumber/number:countnumber/number+1;

        return countindex;
    }

    public void setCountindex(Integer countindex) {
        this.countindex = countindex;
    }





    public Page<T> getList() {
        return list;
    }

    public void setList(Page<T> list) {
        this.list = list;
    }



    public  PageInfo()
    {

    }

    public PageInfo(Integer index,Integer number,Integer counttotal)
    {

     this.number=number;
     this.countnumber=countnumber;
     this.countindex=counttotal%number==0?counttotal/number:counttotal/number+1;
     this.index=index;



    }


}

