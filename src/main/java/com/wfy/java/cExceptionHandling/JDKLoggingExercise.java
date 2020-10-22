package com.wfy.java.cExceptionHandling;

/*
 * @Author wfy
 * @Date 2020/10/22 11:49
 * com.wfy.java.cExceptionHandling
 */

import com.sun.tools.javac.Main;

import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

public class JDKLoggingExercise {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Start process...");
        try{
            //"".getBytes("invalidCharsetName");
            "".getBytes("GBK");
        }catch (UnsupportedEncodingException e){
            // 使用logger.severe打印异常
            logger.severe(e.toString());
        }
        logger.info("Process end.");
    }
}
