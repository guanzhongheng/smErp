package com.lcyzh.nmerp.entity;

/**
 * @Project : nm-erp
 * @Description : TODO
 * @Author : lijinku
 * @Iteration : 1.0
 * @Date : 2019/6/20  2:26 PM
 * @ModificationHistory Who          When          What
 * ----------   ------------- -----------------------------------
 * lijinku          2019/06/20    create
 */
public class ExcelHead {
        //读取表头
        private String head;
        //节点 这里要导入的Excel的表头必须和这儿完全匹配
        private String point = "订单标题,客户名称,客户地址,联系电话,订单交付日期,备注";
        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            if (this.head!=null && this.head.trim()!="") {
                this.head = String.format("%s,%s", this.head, head.trim());
            } else {
                this.head = head.trim();
            }
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

}