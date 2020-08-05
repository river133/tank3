package com.mashibing.tank;

public class Main {
    public static void main(String[] args) throws Exception{
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i = 0; i < 4; i++) {
            tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tf));
        }
        //背景音乐
//        new Thread(()->new Audio("audio/war1.wav").loop()).strat();

        while (true) {
            Thread.sleep(40);
            tf.repaint();
        }
    }
}
