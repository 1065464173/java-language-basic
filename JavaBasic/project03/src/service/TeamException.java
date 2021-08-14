/*
 * @Author: Sxuet
 * @Date: 2021-06-05 17:50:04
 * @LastEditTime: 2021-06-05 22:25:12
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/service/TeamException.java
 */
package service;

public class TeamException extends Exception{
    static final long serialVersionUid = -3381243793124229948L;
    TeamException(){}
    TeamException(String msg){
        super(msg);
    }
}
