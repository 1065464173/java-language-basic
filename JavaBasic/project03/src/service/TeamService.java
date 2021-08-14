/*
 * @Author: Sxuet
 * @Date: 2021-06-05 21:28:57
 * @LastEditTime: 2021-06-07 16:01:09
 * @LastEditors: Sxuet
 * @FilePath: /project03/src/service/TeamService.java
 * @Description: 关于开发团队的增删改查
 */
package service;

import domain.Architect;
import domain.Designer;
import domain.Employee;
import domain.Programmer;
import domain.Status;

public class TeamService {
    private static int counter = 1;// 开发团队成员的uid
    private final int MAX_MEMBER = 5;// 开发团队的人数限制
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;// 开发团队中的实际人数

    public TeamService() {}

    /**
     * @description: 获取开发团队中的所有成员
     * @Author: Sxuet
     * @Date: 2021-06-05 22:27:09
     * @param {*}
     * @return Programmer[] programmers
     */
    public Programmer[] getTeam() {
        Programmer[] programmers = new Programmer[total];
        for (int i = 0; i < programmers.length; i++) {
            programmers[i] = team[i];
        }
        return programmers;
    }

    /**
     * @description: 添加成员
     * @Author: Sxuet
     * @Date: 2021-06-05 21:32:17
     * @param {*}
     * @return {*}
     */
    public void addMember(Employee e) throws TeamException {
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满，无法添加");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发成员，无法添加");
        }
        if (isExist(e)) {
            throw new TeamException("该成员已在本开发团队中");
        }
        Programmer p = (Programmer) e;
        if ("BUSY".equals(p.getStatus().getNAME())) {
            throw new TeamException("该成员已在某团队中，无法添加");
        } else if ("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("该成员正在休假，无法添加");
        }
        // 获取团队中已有的开发成员
        int numOfPro = 0;
        int numOfDes = 0;
        int numOfArc = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] instanceof Architect) {
                numOfArc++;
            } else if (team[i] instanceof Designer) {
                numOfDes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        if (p instanceof Architect) {
            if (numOfArc >= 1) {
                throw new TeamException("团队中至多只能有一名架构师");
            }
        } else if (p instanceof Designer) {
            if (numOfDes >= 2) {
                throw new TeamException("团队中至多只能有两名设计师");
            }
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3) {
                throw new TeamException("团队中至多只能有三名程序员");
            }
        }

        //添加成员
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }
    /**
     * @description: 判断指定的成员是否已经存在于team中
     * @Author: Sxuet
     * @Date: 2021-06-07 15:41:35
     * @param Employee e
     * @return true/false
     */
    private boolean isExist(Employee e) {
        if (e instanceof Programmer) {
            Programmer p = (Programmer) e;
            if (p.getMemberId() == 0) {
                return false;
            } else {
                for (int i = 0; i < team.length; i++) {
                    if (team[i].getMemberId() == p.getMemberId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * @description: 删除成员
     * @Author: Sxuet
     * @Date: 2021-06-05 21:33:08
     * @param {*}
     * @return {*}
     */
    public void removeMember(int employeeId) throws TeamException{
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == employeeId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i==total) {
            throw new TeamException("未找到指定id的团队成员");
        }
        for (int j = i+1; j < total; j++) {
            team[j-1] = team[j];
        }
        team[--total]=null;
        
    }
}
