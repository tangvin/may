package com.example.may.class3;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Bruce_T
 * @date: 2022/05/23   20:42
 * @version: 1.0
 * @modified:
 */
public class CountDownLatchTest2 {


    //用于聚合所有的统计指标
    private static Map map = new HashMap();

    //创建计数器，这里需要统计4个指标
    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) {

        //记录开始时间
        long startTime = System.currentTimeMillis();

        Thread countUserThread = new Thread(() -> {
            try {
                System.out.println("正在统计新增用户数量");

                //任务执行需要3秒
                Thread.sleep(3000);

                //保存结果值
                map.put("userNumber", 1);

                //标记已经完成一个任务
                countDownLatch.countDown();
                System.out.println("统计新增用户数量完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        Thread countOrderThread = new Thread(() -> {
            try {
                System.out.println("正在统计订单数量");

                //任务执行需要3秒
                Thread.sleep(3000);

                //保存结果值
                map.put("countOrder", 2);

                //标记已经完成一个任务
                countDownLatch.countDown();
                System.out.println("统计订单数量完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread countGoodsThread = new Thread(() -> {
            try {
                System.out.println("正在商品销量");

                //任务执行需要3秒
                Thread.sleep(3000);

                //保存结果值
                map.put("countGoods", 3);

                //标记已经完成一个任务
                countDownLatch.countDown();
                System.out.println("统计商品销量完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread countMoneyThread = new Thread(() -> {
            try {
                System.out.println("正在总销售额");

                //任务执行需要3秒
                Thread.sleep(3000);

                //保存结果值
                map.put("countMoneyThread", 4);

                //标记已经完成一个任务
                countDownLatch.countDown();
                System.out.println("统计销售额完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //启动子线程执行任务
        countUserThread.start();
        countGoodsThread.start();
        countOrderThread.start();
        countMoneyThread.start();

        try {
            //主线程等待所有统计指标执行完毕
            countDownLatch.await();

            //记录结束时间
            long endTime = System.currentTimeMillis();
            System.out.println("------统计指标全部完成--------");
            System.out.println("统计结果为：" + map.toString());
            System.out.println("任务总执行时间为" + (endTime - startTime) / 1000 + "秒");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
