package service;

import java.util.Arrays;

import bean.Customer;

/*
 * @Author: Sxuet
 * @Date: 2021-05-19 20:03:57
 * @LastEditTime: 2021-05-19 22:44:52
 * @LastEditors: Sxuet
 * @FilePath: /customer-manager/src/service/CustomerList.java
 * @Description: 
 */

public class CustomerList {
    private Customer[] customers;
    private int total = 0;

    /**
     * @description: 构造器-初始化数组长度
     * @Author: Sxuet
     * @Date: 2021-05-19 20:36:11
     * @param {int} totalCustomer
     * @return {*}
     */
    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    /**
     * @description: 添加客户
     * @Author: Sxuet
     * @Date: 2021-05-19 20:37:18
     * @param {Customer} customer
     * @return true:成功 false:失败
     */
    public boolean addCustomer(Customer customer) {
        if (total >= customers.length) {
            return false;
        }
        customers[total++] = customer;
        return true;
    }

    /**
     * @description: 修改指定索引上的customer信息
     * @Author: Sxuet
     * @Date: 2021-05-19 20:38:53
     * @param {Customer} customer
     * @param {int}      index
     * @return {*}
     */
    public boolean replaceCustomer(int index, Customer customer) {
        if (index < 0 || index >= total) {
            return false;
        }
        customers[index] = customer;
        return true;
    }

    /**
     * @description: 根据索引删除客户
     * @Author: Sxuet
     * @Date: 2021-05-19 20:42:27
     * @param {int} index
     * @return true:删除成功 false:删除失败
     */
    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (; index < total - 1; index++) {
            customers[index] = customers[index + 1];
        }
        customers[--total] = null;
        return true;
    }

    /**
     * @description: 获取所有的客户信息
     * @Author: Sxuet
     * @Date: 2021-05-19 20:47:41
     * @param {*}
     * @return Customers custs
     */
    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < custs.length; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    /**
     * @description:根据索引获取客户
     * @Author: Sxuet
     * @Date: 2021-05-19 20:51:17
     * @param {int} index
     * @return  Customers customer
     */
    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    /**
     * @description: 返回客户总数
     * @Author: Sxuet
     * @Date: 2021-05-19 20:52:50
     * @param {*}
     * @return int total 
     */    
    public int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "CustomerList [customers=" + Arrays.toString(customers) + ", total=" + total + "]";
    }

}
