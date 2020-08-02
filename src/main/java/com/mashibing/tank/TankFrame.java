package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Hello world!
 *
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200,200,Dir.DOWN);

    public TankFrame()   {
        setSize(800,600);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        //监听键盘
        this.addKeyListener(new MykeyListener());

        //关闭窗口事件
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    //绘制坦克
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);//坦克自己画自己
    }

    //键盘监听处理类
    class MykeyListener extends KeyAdapter {

        boolean bL = false;
        boolean bU = false;
        boolean bR = false;
        boolean bD = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;

                    break;
                default:
                    break;
            }
            setMainTankDir();//根据按键改变方向
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;

                    break;
                default:
                    break;
            }
            setMainTankDir();//根据按键抬起改变方向
        }

        //将方向传递到坦克类 ，改变方向
        private void setMainTankDir() {

            if(!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);//代表坦克禁止状态
            }else {
                myTank.setMoving(true);//代表坦克移动了
                if(bL)myTank.setDir(Dir.LEFT) ;
                if(bU)myTank.setDir(Dir.UP);
                if(bR)myTank.setDir(Dir.RIGHT);
                if(bD)myTank.setDir(Dir.DOWN);
            }
        }
    }
}