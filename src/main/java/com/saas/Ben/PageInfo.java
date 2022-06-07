package com.saas.Ben;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageInfo<T> {

    private Integer index; //当前页

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public Integer getStartindex() {
        return startindex;
    }

    public void setStartindex(Integer startindex) {
        this.startindex = startindex;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public Page<T> getList() {
        return list;
    }

    public void setList(Page<T> list) {
        this.list = list;
    }

    private Integer number; //每页显示条数
    private Integer countnumber; //总数

    private Integer countindex;//总页数 通过计算得来
    private Integer startindex;//索引

    private Integer start;//起始页
    private Integer end;//结束页数

    private Page<T> list;



    public PageInfo(Integer index,Integer number,Integer counttotal)
    {

     this.number=number;
     this.countnumber=countnumber;
     this.countindex=counttotal%number==0?counttotal/number:counttotal/number+1;
     this.index=index;



    }
    public  PageInfo()
    {

    }

}

