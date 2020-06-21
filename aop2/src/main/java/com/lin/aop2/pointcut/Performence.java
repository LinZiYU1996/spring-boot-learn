package com.lin.aop2.pointcut;

public interface Performence {

    public void play();

    /**
     * 带音乐家名字的演奏方法
     * @param pianist 音乐家名字
     */
    public void play(String pianist);


}
