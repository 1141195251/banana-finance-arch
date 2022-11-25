/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 5.7.37-log : Database - bfinance
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bfinance` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bfinance`;

/*Table structure for table `bank_deposit_diary` */

DROP TABLE IF EXISTS `bank_deposit_diary`;

CREATE TABLE `bank_deposit_diary` (
                                      `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                      `create_time` datetime DEFAULT NULL COMMENT '日期',
                                      `voucher_id` varchar(10) DEFAULT NULL COMMENT '凭证字号',
                                      `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
                                      `to_account_id` int(11) DEFAULT NULL COMMENT '对方科目账号',
                                      `income` decimal(25,2) DEFAULT NULL COMMENT '收入',
                                      `expense` decimal(25,2) DEFAULT NULL COMMENT '支出',
                                      `balance` decimal(25,2) DEFAULT NULL COMMENT '结余',
                                      PRIMARY KEY (`id`),
                                      KEY `idx_voucher_id` (`voucher_id`),
                                      KEY `idx_to_account_id` (`to_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='银行存款日记';

/*Data for the table `bank_deposit_diary` */

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                           `name` varchar(50) DEFAULT NULL COMMENT '名称',
                           `comment` varchar(100) DEFAULT NULL COMMENT '描述',
                           `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公司';

/*Data for the table `company` */

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
                        `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                        `name` varchar(30) DEFAULT NULL COMMENT '名称',
                        `comment` varchar(100) DEFAULT NULL COMMENT '描述',
                        `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';

/*Data for the table `dept` */

/*Table structure for table `dept_relation` */

DROP TABLE IF EXISTS `dept_relation`;

CREATE TABLE `dept_relation` (
                                 `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                 `company_id` int(11) DEFAULT NULL COMMENT '公司',
                                 `dept_id` int(11) DEFAULT NULL COMMENT '部门',
                                 `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                 PRIMARY KEY (`id`),
                                 KEY `idx_company_id` (`company_id`),
                                 KEY `idx_dept_id` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门关系';

/*Data for the table `dept_relation` */

/*Table structure for table `dt_account_receivable` */

DROP TABLE IF EXISTS `dt_account_receivable`;

CREATE TABLE `dt_account_receivable` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                         `voucher_id` varchar(10) DEFAULT NULL COMMENT '凭证字号',
                                         `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
                                         `debtor` decimal(25,2) DEFAULT NULL COMMENT '借方',
                                         `lender` decimal(25,2) DEFAULT NULL COMMENT '贷方',
                                         `jhd` char(1) DEFAULT NULL COMMENT '借或贷',
                                         `balance` decimal(25,2) DEFAULT NULL COMMENT '余额',
                                         PRIMARY KEY (`id`),
                                         KEY `idx_voucher_id` (`voucher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='应收款明细账';

/*Data for the table `dt_account_receivable` */

/*Table structure for table `dt_imprest` */

DROP TABLE IF EXISTS `dt_imprest`;

CREATE TABLE `dt_imprest` (
                              `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                              `account_id` int(11) NOT NULL COMMENT '科目ID',
                              `amount` decimal(25,2) DEFAULT NULL COMMENT '报销金额',
                              `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
                              `debit_money` decimal(25,2) DEFAULT NULL COMMENT '借方金额',
                              `lend_date` datetime DEFAULT NULL COMMENT '贷出日期',
                              `voucher_id` varchar(10) DEFAULT NULL COMMENT '凭证字号',
                              `take_amount` decimal(25,2) DEFAULT NULL COMMENT '收回金额',
                              PRIMARY KEY (`id`),
                              KEY `idx_voucher_id` (`voucher_id`),
                              KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='备用金明细账';

/*Data for the table `dt_imprest` */

/*Table structure for table `dt_material_account` */

DROP TABLE IF EXISTS `dt_material_account`;

CREATE TABLE `dt_material_account` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                       `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                       `voucher_id` varchar(10) DEFAULT NULL COMMENT '凭证字号',
                                       `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
                                       `in_count` int(11) DEFAULT NULL COMMENT '收入数量',
                                       `in_unit_price` decimal(25,2) DEFAULT NULL COMMENT '收入单价',
                                       `in_price` decimal(25,2) DEFAULT NULL COMMENT '收入金额',
                                       `out_count` int(11) DEFAULT NULL COMMENT '发出数量',
                                       `out_uprice` decimal(25,2) DEFAULT NULL COMMENT '发出单价',
                                       `out_price` decimal(25,2) DEFAULT NULL COMMENT '发出金额',
                                       `balance_count` int(11) DEFAULT NULL COMMENT '结存数量',
                                       `balance_uprice` decimal(25,2) DEFAULT NULL COMMENT '结存单价',
                                       `balance` decimal(25,2) DEFAULT NULL COMMENT '结存金额',
                                       PRIMARY KEY (`id`),
                                       KEY `idx_voucher_id` (`voucher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='原材料明细账';

/*Data for the table `dt_material_account` */

/*Table structure for table `dt_production_account` */

DROP TABLE IF EXISTS `dt_production_account`;

CREATE TABLE `dt_production_account` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                         `voucher_id` varchar(10) DEFAULT NULL COMMENT '凭证字号',
                                         `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
                                         `material_cost` decimal(25,2) DEFAULT NULL COMMENT '直接材料',
                                         `labour_cost` decimal(25,2) DEFAULT NULL COMMENT '直接人工',
                                         `production_cost` decimal(25,2) DEFAULT NULL COMMENT '制造费用',
                                         `total` decimal(25,2) DEFAULT NULL COMMENT '合计',
                                         PRIMARY KEY (`id`),
                                         KEY `idx_voucher_id` (`voucher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='生产成本明细账';

/*Data for the table `dt_production_account` */

/*Table structure for table `gl_bank_deposit` */

DROP TABLE IF EXISTS `gl_bank_deposit`;

CREATE TABLE `gl_bank_deposit` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                   `voucher_id` varchar(10) NOT NULL COMMENT '凭证字号',
                                   `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
                                   `debtor` decimal(25,2) DEFAULT NULL COMMENT '借方',
                                   `creditor` decimal(25,2) DEFAULT NULL COMMENT '贷方',
                                   `jhd` char(1) NOT NULL COMMENT '借或贷',
                                   `balance` decimal(25,2) NOT NULL COMMENT '余额',
                                   PRIMARY KEY (`id`),
                                   KEY `idx_voucher_id` (`voucher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='银行存款总账';

/*Data for the table `gl_bank_deposit` */

/*Table structure for table `income_account` */

DROP TABLE IF EXISTS `income_account`;

CREATE TABLE `income_account` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                  `item_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
                                  `today` decimal(25,2) DEFAULT NULL COMMENT '本日',
                                  `month_total` decimal(25,2) DEFAULT NULL COMMENT '本月累计',
                                  `year_total` decimal(25,2) DEFAULT NULL COMMENT '本年累计',
                                  `last_balance` decimal(25,2) DEFAULT NULL COMMENT '昨日结存',
                                  `balance` decimal(25,2) DEFAULT NULL COMMENT '今日结存',
                                  `cashier` int(11) DEFAULT NULL COMMENT '出纳员',
                                  PRIMARY KEY (`id`),
                                  KEY `idx_item_name` (`item_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收入账表';

/*Data for the table `income_account` */

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                           `invoice_type` varchar(50) DEFAULT NULL COMMENT '种类',
                           `invoice_type_org` varchar(50) DEFAULT NULL COMMENT '名称',
                           `invoice_code` varchar(100) DEFAULT NULL COMMENT '代码',
                           `invoice_num` varchar(100) DEFAULT NULL COMMENT '号码',
                           `invoice_code_confirm` varchar(100) DEFAULT NULL COMMENT '校验码',
                           `invoice_date` varchar(50) DEFAULT NULL COMMENT '日期',
                           `purchaser_name` varchar(100) DEFAULT NULL COMMENT '购方名称',
                           `purchaser_register_num` varchar(100) DEFAULT NULL COMMENT '购方纳税人识别号',
                           `purchaser_address` varchar(100) DEFAULT NULL COMMENT '购方地址及电话',
                           `purchaser_bank` varchar(100) DEFAULT NULL COMMENT '购方开户行及账号',
                           `seller_name` varchar(50) DEFAULT NULL COMMENT '销售方名称',
                           `seller_address` varchar(100) DEFAULT NULL COMMENT '销售方地址及电话',
                           `seller_bank` varchar(100) DEFAULT NULL COMMENT '销售开户行及账号',
                           `total_amount` decimal(25,2) DEFAULT NULL COMMENT '合计金额',
                           `total_tax` decimal(25,2) DEFAULT NULL COMMENT '合计税额',
                           `amountln_words` varchar(50) DEFAULT NULL COMMENT '价税合计大写',
                           `amountln_figuers` decimal(25,2) DEFAULT NULL COMMENT '价税合计小写',
                           PRIMARY KEY (`id`),
                           KEY `idx_purchaser_name` (`purchaser_name`),
                           KEY `idx_seller_name` (`seller_name`),
                           KEY `idx_invoice_code` (`invoice_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='发票';

/*Data for the table `invoice` */

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                       `name` varchar(50) DEFAULT NULL COMMENT '名称',
                       `comment` varchar(100) DEFAULT NULL COMMENT '描述',
                       `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='职位';

/*Data for the table `job` */

/*Table structure for table `message_record` */

DROP TABLE IF EXISTS `message_record`;

CREATE TABLE `message_record` (
                                  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                  `template_id` int(11) DEFAULT NULL COMMENT '消息模板ID',
                                  `to_type` int(11) DEFAULT NULL COMMENT '推送渠道',
                                  `receiver_id` bigint(20) DEFAULT NULL COMMENT '消息接收者ID',
                                  `content` varchar(200) DEFAULT NULL COMMENT '消息推送内容',
                                  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                  `update_by` bigint(20) DEFAULT NULL COMMENT '修改人',
                                  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
                                  PRIMARY KEY (`id`),
                                  KEY `idx_template_id` (`template_id`),
                                  KEY `idx_receiver_id` (`receiver_id`),
                                  KEY `idx_create_by` (`create_by`),
                                  KEY `idx_update_by` (`update_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息推送记录表';

/*Data for the table `message_record` */

/*Table structure for table `payment_voucher` */

DROP TABLE IF EXISTS `payment_voucher`;

CREATE TABLE `payment_voucher` (
                                   `id` varchar(10) NOT NULL COMMENT '凭证字号',
                                   `creditor_account_id` int(11) NOT NULL COMMENT '贷方科目',
                                   `create_date` datetime DEFAULT NULL COMMENT '创建日期',
                                   `summary` varchar(300) DEFAULT NULL COMMENT '摘要',
                                   `lender_account_id` int(11) NOT NULL COMMENT '借方一级科目',
                                   `lender_active_account_id` int(11) DEFAULT NULL COMMENT '借方明细科目',
                                   `account_money` decimal(25,2) NOT NULL COMMENT '一级科目金额',
                                   `active_acount_money` decimal(25,2) DEFAULT NULL COMMENT '明细科目金额',
                                   `auditor` bigint(20) DEFAULT NULL COMMENT '审核',
                                   `supervisor` bigint(20) NOT NULL COMMENT '会计主管',
                                   PRIMARY KEY (`id`),
                                   KEY `idx_creditor_account_id` (`creditor_account_id`),
                                   KEY `idx_lender_account_id` (`lender_account_id`),
                                   KEY `idx_lender_active_account_id` (`lender_active_account_id`),
                                   KEY `idx_auditor` (`auditor`),
                                   KEY `idx_supervisor` (`supervisor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='付款凭证';

/*Data for the table `payment_voucher` */

/*Table structure for table `receipt_voucher` */

DROP TABLE IF EXISTS `receipt_voucher`;

CREATE TABLE `receipt_voucher` (
                                   `id` varchar(10) NOT NULL COMMENT '凭证字号',
                                   `lender_account_id` int(11) NOT NULL COMMENT '借方科目',
                                   `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                   `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
                                   `creditor_account_id` int(11) NOT NULL COMMENT '贷方一级科目',
                                   `creditor_active_account_id` int(11) DEFAULT NULL COMMENT '贷方明细科目',
                                   `account_money` decimal(25,2) NOT NULL COMMENT '一级科目金额',
                                   `active_acount_money` decimal(25,2) DEFAULT NULL COMMENT '明细科目金额',
                                   `auditor` bigint(20) DEFAULT NULL COMMENT '审核',
                                   `supervisor` bigint(20) NOT NULL COMMENT '会计主管',
                                   PRIMARY KEY (`id`),
                                   KEY `idx_creditor_account_id` (`creditor_account_id`),
                                   KEY `idx_creditor_active_account_id` (`creditor_active_account_id`),
                                   KEY `idx_lender_account_id` (`lender_account_id`),
                                   KEY `idx_supervisor` (`supervisor`),
                                   KEY `idx_auditor` (`auditor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收款凭证';

/*Data for the table `receipt_voucher` */

/*Table structure for table `rs_risk` */

DROP TABLE IF EXISTS `rs_risk`;

CREATE TABLE `rs_risk` (
                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                           `risk_name` varchar(50) DEFAULT NULL COMMENT '风险名称',
                           `risk_category_id` int(11) DEFAULT NULL COMMENT '风险分类ID',
                           `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                           PRIMARY KEY (`id`),
                           KEY `idx_risk_category_id` (`risk_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='风险表';

/*Data for the table `rs_risk` */

/*Table structure for table `rs_risk_category` */

DROP TABLE IF EXISTS `rs_risk_category`;

CREATE TABLE `rs_risk_category` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                    `risk_category_name` varchar(50) DEFAULT NULL COMMENT '风险名称',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='风险分类表';

/*Data for the table `rs_risk_category` */

/*Table structure for table `rs_risk_report` */

DROP TABLE IF EXISTS `rs_risk_report`;

CREATE TABLE `rs_risk_report` (
                                  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                  `risk_id` int(11) DEFAULT NULL COMMENT '风险ID',
                                  `analysis` varchar(200) DEFAULT NULL COMMENT '分析',
                                  `measure` varchar(200) DEFAULT NULL COMMENT '措施',
                                  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                  PRIMARY KEY (`id`),
                                  KEY `idx_risk_id` (`risk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4mb4 COMMENT='风险报告';

/*Data for the table `rs_risk_report` */

/*Table structure for table `tb_account` */

DROP TABLE IF EXISTS `tb_account`;

CREATE TABLE `tb_account` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                              `name` varchar(30) DEFAULT NULL COMMENT '科目名称',
                              `parent_account_id` int(11) DEFAULT NULL COMMENT '一级科目',
                              `description` varchar(100) DEFAULT NULL COMMENT '描述',
                              PRIMARY KEY (`id`),
                              KEY `idx_parent_account_id` (`parent_account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4mb4 COMMENT='科目表';

/*Data for the table `tb_account` */

/*Table structure for table `tb_account_relation` */

DROP TABLE IF EXISTS `tb_account_relation`;

CREATE TABLE `tb_account_relation` (
                                       `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                       `account_id` int(11) DEFAULT NULL COMMENT '科目',
                                       `company_id` int(11) DEFAULT NULL COMMENT '公司',
                                       `dept_id` int(11) DEFAULT NULL COMMENT '部门',
                                       PRIMARY KEY (`id`),
                                       KEY `idx_account_id` (`account_id`),
                                       KEY `idx_company_id` (`company_id`),
                                       KEY `idx_dept_id` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='科目关系表';

/*Data for the table `tb_account_relation` */

/*Table structure for table `tb_expense` */

DROP TABLE IF EXISTS `tb_expense`;

CREATE TABLE `tb_expense` (
                              `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                              `allocation_id` int(11) DEFAULT NULL COMMENT '费用分摊ID',
                              `dept_id` int(11) DEFAULT NULL COMMENT '部门',
                              `company_id` int(11) DEFAULT NULL COMMENT '公司',
                              `cost` decimal(25,2) DEFAULT NULL COMMENT '金额',
                              PRIMARY KEY (`id`),
                              KEY `idx_allocation_id` (`allocation_id`),
                              KEY `idx_company_id` (`company_id`),
                              KEY `idx_dept_id` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用表';

/*Data for the table `tb_expense` */

/*Table structure for table `tb_expense_allocation` */

DROP TABLE IF EXISTS `tb_expense_allocation`;

CREATE TABLE `tb_expense_allocation` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                         `account_id` int(11) DEFAULT NULL COMMENT '科目',
                                         `allocation_type` varchar(30) DEFAULT NULL COMMENT '分摊方法',
                                         `total` decimal(25,2) DEFAULT NULL COMMENT '合计金额',
                                         PRIMARY KEY (`id`),
                                         KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用分摊表';

/*Data for the table `tb_expense_allocation` */

/*Table structure for table `tb_expense_budge` */

DROP TABLE IF EXISTS `tb_expense_budge`;

CREATE TABLE `tb_expense_budge` (
                                    `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                    `account_id` int(11) DEFAULT NULL COMMENT '科目',
                                    `company_id` int(11) DEFAULT NULL COMMENT '公司',
                                    `dept_id` int(11) DEFAULT NULL COMMENT '部门',
                                    `per_month_money` decimal(25,2) DEFAULT NULL COMMENT '每月',
                                    `per_year_money` decimal(25,2) DEFAULT NULL COMMENT '全年',
                                    `description` varchar(100) DEFAULT NULL COMMENT '描述',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                    PRIMARY KEY (`id`),
                                    KEY `idx_account_id` (`account_id`),
                                    KEY `idx_company_id` (`company_id`),
                                    KEY `idx_dept_id` (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='费用预算';

/*Data for the table `tb_expense_budge` */

/*Table structure for table `tb_reimbursement_info` */

DROP TABLE IF EXISTS `tb_reimbursement_info`;

CREATE TABLE `tb_reimbursement_info` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                         `cause` varchar(100) DEFAULT NULL COMMENT '事由',
                                         `create_sn` char(5) DEFAULT NULL COMMENT '创建人',
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `next_deal_sn` char(5) DEFAULT NULL COMMENT '待处理人',
                                         `total_amount` double DEFAULT NULL COMMENT '总金额',
                                         `status` varchar(20) DEFAULT NULL COMMENT '状态',
                                         PRIMARY KEY (`id`) USING BTREE,
                                         KEY `next_deal_sn` (`next_deal_sn`) USING BTREE,
                                         KEY `create_sn` (`create_sn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

/*Data for the table `tb_reimbursement_info` */

insert  into `tb_reimbursement_info`(`id`,`cause`,`create_sn`,`create_time`,`next_deal_sn`,`total_amount`,`status`) values
                                                                                                                        (18,'出差三天','1005','2019-07-19 21:54:12','1005',2900,'新创建'),
                                                                                                                        (19,'出差一周','1004','2019-07-19 21:56:29',NULL,3500,'已终止'),
                                                                                                                        (20,'聚餐','1004','2019-07-19 21:56:47',NULL,800,'已打款'),
                                                                                                                        (21,'节日旅游','1004','2019-07-19 21:57:14','1003',7000,'已审核');

/*Table structure for table `tb_reimbursement_item` */

DROP TABLE IF EXISTS `tb_reimbursement_item`;

CREATE TABLE `tb_reimbursement_item` (
                                         `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                         `claim_voucher_id` int(11) DEFAULT NULL COMMENT '报销单',
                                         `item` varchar(20) DEFAULT NULL COMMENT '费用类型',
                                         `amount` double DEFAULT NULL COMMENT '金额',
                                         `comment` varchar(100) DEFAULT NULL COMMENT '描述',
                                         PRIMARY KEY (`id`) USING BTREE,
                                         KEY `claim_voucher_id` (`claim_voucher_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

/*Data for the table `tb_reimbursement_item` */

insert  into `tb_reimbursement_item`(`id`,`claim_voucher_id`,`item`,`amount`,`comment`) values
                                                                                            (30,18,'交通',2000,'高铁'),
                                                                                            (31,18,'住宿',700,'酒店'),
                                                                                            (32,18,'餐饮',200,'三餐'),
                                                                                            (33,19,'交通',2000,'飞机'),
                                                                                            (34,19,'餐饮',500,'三餐'),
                                                                                            (35,19,'住宿',1000,'旅馆'),
                                                                                            (36,20,'餐饮',800,''),
                                                                                            (37,21,'交通',5000,'飞机'),
                                                                                            (38,21,'餐饮',2000,'聚餐');

/*Table structure for table `tb_reimbursement_record` */

DROP TABLE IF EXISTS `tb_reimbursement_record`;

CREATE TABLE `tb_reimbursement_record` (
                                           `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                           `claim_voucher_id` int(11) DEFAULT NULL COMMENT '报销单',
                                           `deal_sn` char(5) DEFAULT NULL COMMENT '处理人',
                                           `deal_time` datetime DEFAULT NULL COMMENT '处理时间',
                                           `deal_way` varchar(20) DEFAULT NULL COMMENT '处理类型',
                                           `deal_result` varchar(20) DEFAULT NULL COMMENT '处理结果',
                                           `comment` varchar(20) DEFAULT NULL COMMENT '备注',
                                           PRIMARY KEY (`id`) USING BTREE,
                                           KEY `claim_voucher_id` (`claim_voucher_id`) USING BTREE,
                                           KEY `deal_sn` (`deal_sn`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

/*Data for the table `tb_reimbursement_record` */

/*Table structure for table `transfer_voucher` */

DROP TABLE IF EXISTS `transfer_voucher`;

CREATE TABLE `transfer_voucher` (
                                    `id` varchar(10) NOT NULL COMMENT '凭证字号',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                    `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
                                    `account_id` int(11) DEFAULT NULL COMMENT '一级科目',
                                    `active_account_id` int(11) DEFAULT NULL COMMENT '明细科目',
                                    `lender_account_money` decimal(25,2) DEFAULT NULL COMMENT '借方一级科目金额',
                                    `lender_active_account_money` decimal(25,2) DEFAULT NULL COMMENT '借方明细科目金额',
                                    `creditor_account_money` decimal(25,2) DEFAULT NULL COMMENT '贷方一级科目金额',
                                    `creditor_active_account_money` decimal(25,2) DEFAULT NULL COMMENT '贷方明细科目金额',
                                    `auditor` bigint(20) DEFAULT NULL COMMENT '审核',
                                    `supervisor` bigint(20) NOT NULL COMMENT '会计主管',
                                    PRIMARY KEY (`id`),
                                    KEY `idx_account_id` (`account_id`),
                                    KEY `idx_active_account_id` (`active_account_id`),
                                    KEY `idx_supervisor` (`supervisor`),
                                    KEY `idx_auditor` (`auditor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='转账凭证';

/*Data for the table `transfer_voucher` */

/*Table structure for table `ums_admin` */

DROP TABLE IF EXISTS `ums_admin`;

CREATE TABLE `ums_admin` (
                             `id` bigint(20) NOT NULL AUTO_INCREMENT,
                             `username` varchar(64) DEFAULT NULL,
                             `password` varchar(64) DEFAULT NULL,
                             `icon` varchar(500) DEFAULT NULL COMMENT '头像',
                             `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
                             `nick_name` varchar(200) DEFAULT NULL COMMENT '昵称',
                             `note` varchar(500) DEFAULT NULL COMMENT '备注信息',
                             `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                             `login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
                             `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COMMENT='后台用户表';

/*Data for the table `ums_admin` */

insert  into `ums_admin`(`id`,`username`,`password`,`icon`,`email`,`nick_name`,`note`,`create_time`,`login_time`,`status`) values
                                                                                                                               (1,'test','$2a$10$NZ5o7r2E.ayT2ZoxgjlI.eJ6OEYqjH7INR/F.mXDbjZJi9HF0YCVG','http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg','asdasd@asasdasd.com','测试账号','123123123','2018-09-29 13:55:30','2018-09-29 13:55:39',1),
                                                                                                                               (3,'admin','$2a$10$.E1FokumK5GIXWgKlg.Hc.i/0/2.qdAwYFL1zc5QHdyzpXOr38RZO','http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg','admin@163.com','系统管理员','系统管理员','2018-10-08 13:32:47','2019-04-20 12:45:16',0),
                                                                                                                               (4,'macro','$2a$10$Bx4jZPR7GhEpIQfefDQtVeS58GfT5n6mxs/b4nLLK65eMFa16topa','string','macro@qq.com','macro','macro专用','2019-10-06 15:53:51','2020-02-03 14:55:55',1),
                                                                                                                               (6,'productAdmin','$2a$10$6/.J.p.6Bhn7ic4GfoB5D.pGd7xSiD1a9M6ht6yO0fxzlKJPjRAGm',NULL,'product@qq.com','商品管理员','只有商品权限2','2020-02-07 16:15:08',NULL,1),
                                                                                                                               (7,'orderAdmin','$2a$10$UqEhA9UZXjHHA3B.L9wNG.6aerrBjC6WHTtbv1FdvYPUI.7lkL6E.',NULL,'order@qq.com','订单管理员','只有订单管理权限','2020-02-07 16:15:50',NULL,1),
                                                                                                                               (10,'ceshi','$2a$10$RaaNo9CC0RSms8mc/gJpCuOWndDT4pHH0u5XgZdAAYFs1Uq4sOPRi',NULL,'ceshi@qq.com','ceshi',NULL,'2020-03-13 16:23:30',NULL,1),
                                                                                                                               (12,'rulldar','$2a$10$DGUwbXiB3InzcVwCxsZM/eg.GAMjhHmeQxmoWlE/5tz.rDb./4/3G','http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg','1141195251@qq.com','','','2022-09-17 19:07:53','2022-09-27 13:21:11',1),
                                                                                                                               (13,'rulldar1','$2a$10$TtofV3xhbibC0/aQJkNyEuS1/K7Y/O4THUPZTuukYuVG/ikDDDPdu','http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg','1141195251@qq.com','','','2022-09-18 16:48:37','2022-09-27 20:55:15',1),
                                                                                                                               (14,'rulldar12','$2a$10$eJatWrstYUI4sXO7KP21SepuIsFdpaBwCIgd/iECcEQa.3Ipv6hNG','http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/images/20180607/timg.jpg','1141195251@qq.com','','','2022-09-18 16:48:59','2022-09-18 17:00:11',1),
                                                                                                                               (40,'撒撒旦撒旦','$2a$10$qGW840n/057dJmmQPycMjOiDFBZS2VqRZ9179AT7k8srXY7j5thGa',NULL,'1141195251@qq.com','asd阿松大',NULL,'2022-09-23 11:49:07',NULL,1),
                                                                                                                               (41,'啊实打实的自行车自行车','$2a$10$0mXKuPjCZQijcjLdnNB8dOzwEQ.MrVpj/646qNiEJ32/u3.P0vGuC',NULL,'1141195251@qq.com','阿松大','阿松大','2022-09-23 11:49:44',NULL,1);

/*Table structure for table `ums_admin_login_log` */

DROP TABLE IF EXISTS `ums_admin_login_log`;

CREATE TABLE `ums_admin_login_log` (
                                       `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                       `admin_id` bigint(20) DEFAULT NULL,
                                       `create_time` datetime DEFAULT NULL,
                                       `ip` varchar(64) DEFAULT NULL,
                                       `address` varchar(100) DEFAULT NULL,
                                       `user_agent` varchar(100) DEFAULT NULL COMMENT '浏览器登录类型',
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=651 DEFAULT CHARSET=utf8mb4 COMMENT='后台用户登录日志表';

/*Data for the table `ums_admin_login_log` */

insert  into `ums_admin_login_log`(`id`,`admin_id`,`create_time`,`ip`,`address`,`user_agent`) values
                                                                                                  (285,3,'2020-08-24 14:05:21','0:0:0:0:0:0:0:1',NULL,NULL),
                                                                                                  (286,10,'2020-08-24 14:05:39','0:0:0:0:0:0:0:1',NULL,NULL),
                                                                                                  (287,11,'2022-09-16 14:38:01','192.168.86.1',NULL,NULL),
                                                                                                  (288,11,'2022-09-16 14:38:41','192.168.86.1',NULL,NULL),
                                                                                                  (289,11,'2022-09-16 14:48:36','192.168.86.1',NULL,NULL),
                                                                                                  (290,11,'2022-09-16 15:25:23','192.168.86.1',NULL,NULL),
                                                                                                  (291,11,'2022-09-16 16:15:33','192.168.86.1',NULL,NULL),
                                                                                                  (292,11,'2022-09-16 16:17:56','192.168.86.1',NULL,NULL),
                                                                                                  (293,11,'2022-09-16 16:18:27','192.168.86.1',NULL,NULL),
                                                                                                  (294,11,'2022-09-16 21:51:02','192.168.86.1',NULL,NULL),
                                                                                                  (295,11,'2022-09-16 22:26:04','192.168.86.1',NULL,NULL),
                                                                                                  (296,11,'2022-09-16 23:22:30','192.168.86.1',NULL,NULL),
                                                                                                  (297,11,'2022-09-17 16:02:31','192.168.86.1',NULL,NULL),
                                                                                                  (298,12,'2022-09-17 20:06:05','192.168.86.1',NULL,NULL),
                                                                                                  (299,12,'2022-09-17 21:00:59','192.168.86.1',NULL,NULL),
                                                                                                  (300,12,'2022-09-18 12:41:47','192.168.86.1',NULL,NULL),
                                                                                                  (301,13,'2022-09-18 16:49:16','192.168.86.1',NULL,NULL),
                                                                                                  (302,14,'2022-09-18 17:00:11','192.168.86.1',NULL,NULL),
                                                                                                  (303,13,'2022-09-18 17:18:03','192.168.86.1',NULL,NULL),
                                                                                                  (304,13,'2022-09-18 18:35:42','192.168.86.1',NULL,NULL),
                                                                                                  (305,13,'2022-09-18 19:04:43','192.168.86.1',NULL,NULL),
                                                                                                  (306,13,'2022-09-18 19:05:28','192.168.86.1',NULL,NULL),
                                                                                                  (307,13,'2022-09-18 19:05:29','192.168.86.1',NULL,NULL),
                                                                                                  (308,13,'2022-09-18 19:05:29','192.168.86.1',NULL,NULL),
                                                                                                  (309,13,'2022-09-18 19:05:30','192.168.86.1',NULL,NULL),
                                                                                                  (310,13,'2022-09-18 19:05:30','192.168.86.1',NULL,NULL),
                                                                                                  (311,13,'2022-09-18 19:05:30','192.168.86.1',NULL,NULL),
                                                                                                  (312,13,'2022-09-18 19:06:11','192.168.86.1',NULL,NULL),
                                                                                                  (313,13,'2022-09-18 19:06:12','192.168.86.1',NULL,NULL),
                                                                                                  (314,12,'2022-09-18 19:18:34','192.168.86.1',NULL,NULL),
                                                                                                  (315,12,'2022-09-18 19:19:02','192.168.86.1',NULL,NULL),
                                                                                                  (316,13,'2022-09-18 19:20:52','192.168.86.1',NULL,NULL),
                                                                                                  (317,13,'2022-09-18 19:21:16','192.168.86.1',NULL,NULL),
                                                                                                  (318,13,'2022-09-18 19:21:21','192.168.86.1',NULL,NULL),
                                                                                                  (319,12,'2022-09-18 19:22:37','192.168.86.1',NULL,NULL),
                                                                                                  (320,13,'2022-09-18 19:22:45','192.168.86.1',NULL,NULL),
                                                                                                  (321,13,'2022-09-18 19:23:17','192.168.86.1',NULL,NULL),
                                                                                                  (322,13,'2022-09-18 19:24:40','192.168.86.1',NULL,NULL),
                                                                                                  (323,13,'2022-09-18 19:26:05','192.168.86.1',NULL,NULL),
                                                                                                  (324,13,'2022-09-18 19:26:22','192.168.86.1',NULL,NULL),
                                                                                                  (325,13,'2022-09-18 19:26:44','192.168.86.1',NULL,NULL),
                                                                                                  (326,13,'2022-09-18 19:26:49','192.168.86.1',NULL,NULL),
                                                                                                  (327,13,'2022-09-18 19:27:35','192.168.86.1',NULL,NULL),
                                                                                                  (328,13,'2022-09-18 19:28:12','192.168.86.1',NULL,NULL),
                                                                                                  (329,13,'2022-09-18 19:28:17','192.168.86.1',NULL,NULL),
                                                                                                  (330,13,'2022-09-18 19:29:48','192.168.86.1',NULL,NULL),
                                                                                                  (331,13,'2022-09-18 19:29:49','192.168.86.1',NULL,NULL),
                                                                                                  (332,13,'2022-09-18 19:29:53','192.168.86.1',NULL,NULL),
                                                                                                  (333,13,'2022-09-18 19:29:55','192.168.86.1',NULL,NULL),
                                                                                                  (334,13,'2022-09-18 19:32:12','192.168.86.1',NULL,NULL),
                                                                                                  (335,13,'2022-09-18 19:33:51','192.168.86.1',NULL,NULL),
                                                                                                  (336,12,'2022-09-18 19:34:18','192.168.86.1',NULL,NULL),
                                                                                                  (337,13,'2022-09-18 19:37:17','192.168.86.1',NULL,NULL),
                                                                                                  (338,13,'2022-09-18 19:38:39','192.168.86.1',NULL,NULL),
                                                                                                  (339,13,'2022-09-18 19:42:06','192.168.86.1',NULL,NULL),
                                                                                                  (340,13,'2022-09-18 19:42:18','192.168.86.1',NULL,NULL),
                                                                                                  (341,13,'2022-09-18 19:42:18','192.168.86.1',NULL,NULL),
                                                                                                  (342,13,'2022-09-18 19:42:29','192.168.86.1',NULL,NULL),
                                                                                                  (343,13,'2022-09-18 19:43:30','192.168.86.1',NULL,NULL),
                                                                                                  (344,13,'2022-09-18 20:24:42','192.168.86.1',NULL,NULL),
                                                                                                  (345,13,'2022-09-18 20:25:22','192.168.86.1',NULL,NULL),
                                                                                                  (346,13,'2022-09-18 20:26:36','192.168.86.1',NULL,NULL),
                                                                                                  (347,13,'2022-09-18 20:26:55','192.168.86.1',NULL,NULL),
                                                                                                  (348,13,'2022-09-18 20:28:25','192.168.86.1',NULL,NULL),
                                                                                                  (349,13,'2022-09-18 20:28:44','192.168.86.1',NULL,NULL),
                                                                                                  (350,13,'2022-09-18 20:31:59','192.168.86.1',NULL,NULL),
                                                                                                  (351,13,'2022-09-18 20:32:08','192.168.86.1',NULL,NULL),
                                                                                                  (352,13,'2022-09-18 20:32:20','192.168.86.1',NULL,NULL),
                                                                                                  (353,13,'2022-09-18 20:32:31','192.168.86.1',NULL,NULL),
                                                                                                  (354,13,'2022-09-18 20:32:40','192.168.86.1',NULL,NULL),
                                                                                                  (355,13,'2022-09-18 20:35:42','192.168.86.1',NULL,NULL),
                                                                                                  (356,13,'2022-09-18 20:36:39','192.168.86.1',NULL,NULL),
                                                                                                  (357,13,'2022-09-18 20:37:00','192.168.86.1',NULL,NULL),
                                                                                                  (358,13,'2022-09-18 20:38:01','192.168.86.1',NULL,NULL),
                                                                                                  (359,13,'2022-09-18 20:38:36','192.168.86.1',NULL,NULL),
                                                                                                  (360,13,'2022-09-18 20:39:26','192.168.86.1',NULL,NULL),
                                                                                                  (361,13,'2022-09-18 20:40:03','192.168.86.1',NULL,NULL),
                                                                                                  (362,13,'2022-09-18 20:40:06','192.168.86.1',NULL,NULL),
                                                                                                  (363,13,'2022-09-18 20:44:09','192.168.86.1',NULL,NULL),
                                                                                                  (364,13,'2022-09-18 20:44:12','192.168.86.1',NULL,NULL),
                                                                                                  (365,13,'2022-09-18 20:44:22','192.168.86.1',NULL,NULL),
                                                                                                  (366,13,'2022-09-18 20:45:11','192.168.86.1',NULL,NULL),
                                                                                                  (367,13,'2022-09-18 20:46:48','192.168.86.1',NULL,NULL),
                                                                                                  (368,13,'2022-09-18 20:46:52','192.168.86.1',NULL,NULL),
                                                                                                  (369,13,'2022-09-18 20:46:55','192.168.86.1',NULL,NULL),
                                                                                                  (370,13,'2022-09-18 20:47:33','192.168.86.1',NULL,NULL),
                                                                                                  (371,13,'2022-09-18 20:47:41','192.168.86.1',NULL,NULL),
                                                                                                  (372,13,'2022-09-18 20:47:45','192.168.86.1',NULL,NULL),
                                                                                                  (373,13,'2022-09-18 20:48:15','192.168.86.1',NULL,NULL),
                                                                                                  (374,13,'2022-09-18 20:48:22','192.168.86.1',NULL,NULL),
                                                                                                  (375,13,'2022-09-18 20:48:28','192.168.86.1',NULL,NULL),
                                                                                                  (376,13,'2022-09-18 20:49:33','192.168.86.1',NULL,NULL),
                                                                                                  (377,13,'2022-09-18 20:49:40','192.168.86.1',NULL,NULL),
                                                                                                  (378,13,'2022-09-18 20:50:34','192.168.86.1',NULL,NULL),
                                                                                                  (379,13,'2022-09-18 20:51:15','192.168.86.1',NULL,NULL),
                                                                                                  (380,13,'2022-09-18 20:51:28','192.168.86.1',NULL,NULL),
                                                                                                  (381,13,'2022-09-18 20:51:29','192.168.86.1',NULL,NULL),
                                                                                                  (382,13,'2022-09-18 20:51:29','192.168.86.1',NULL,NULL),
                                                                                                  (383,13,'2022-09-18 20:51:30','192.168.86.1',NULL,NULL),
                                                                                                  (384,13,'2022-09-18 20:51:30','192.168.86.1',NULL,NULL),
                                                                                                  (385,13,'2022-09-18 20:51:30','192.168.86.1',NULL,NULL),
                                                                                                  (386,13,'2022-09-18 20:51:31','192.168.86.1',NULL,NULL),
                                                                                                  (387,13,'2022-09-18 20:51:31','192.168.86.1',NULL,NULL),
                                                                                                  (388,13,'2022-09-18 20:51:43','192.168.86.1',NULL,NULL),
                                                                                                  (389,13,'2022-09-18 20:51:43','192.168.86.1',NULL,NULL),
                                                                                                  (390,13,'2022-09-18 20:52:34','192.168.86.1',NULL,NULL),
                                                                                                  (391,13,'2022-09-18 20:54:01','192.168.86.1',NULL,NULL),
                                                                                                  (392,13,'2022-09-18 20:54:11','192.168.86.1',NULL,NULL),
                                                                                                  (393,13,'2022-09-18 20:57:04','192.168.86.1',NULL,NULL),
                                                                                                  (394,13,'2022-09-18 20:57:11','192.168.86.1',NULL,NULL),
                                                                                                  (395,13,'2022-09-18 21:02:21','192.168.86.1',NULL,NULL),
                                                                                                  (396,13,'2022-09-18 21:02:35','192.168.86.1',NULL,NULL),
                                                                                                  (397,13,'2022-09-18 21:03:41','192.168.86.1',NULL,NULL),
                                                                                                  (398,13,'2022-09-18 21:04:12','192.168.86.1',NULL,NULL),
                                                                                                  (399,13,'2022-09-18 21:06:13','192.168.86.1',NULL,NULL),
                                                                                                  (400,13,'2022-09-18 21:06:34','192.168.86.1',NULL,NULL),
                                                                                                  (401,13,'2022-09-18 21:07:14','192.168.86.1',NULL,NULL),
                                                                                                  (402,13,'2022-09-18 21:07:19','192.168.86.1',NULL,NULL),
                                                                                                  (403,13,'2022-09-18 21:07:19','192.168.86.1',NULL,NULL),
                                                                                                  (404,13,'2022-09-18 21:09:34','192.168.86.1',NULL,NULL),
                                                                                                  (405,13,'2022-09-18 21:09:36','192.168.86.1',NULL,NULL),
                                                                                                  (406,13,'2022-09-18 21:10:25','192.168.86.1',NULL,NULL),
                                                                                                  (407,13,'2022-09-18 21:13:56','192.168.86.1',NULL,NULL),
                                                                                                  (408,12,'2022-09-18 21:33:21','192.168.86.1',NULL,NULL),
                                                                                                  (409,13,'2022-09-18 21:33:31','192.168.86.1',NULL,NULL),
                                                                                                  (410,13,'2022-09-18 21:41:17','192.168.86.1',NULL,NULL),
                                                                                                  (411,13,'2022-09-18 21:41:26','192.168.86.1',NULL,NULL),
                                                                                                  (412,13,'2022-09-18 21:41:28','192.168.86.1',NULL,NULL),
                                                                                                  (413,13,'2022-09-18 21:41:31','192.168.86.1',NULL,NULL),
                                                                                                  (414,13,'2022-09-18 21:41:31','192.168.86.1',NULL,NULL),
                                                                                                  (415,13,'2022-09-18 21:41:32','192.168.86.1',NULL,NULL),
                                                                                                  (416,13,'2022-09-18 21:41:32','192.168.86.1',NULL,NULL),
                                                                                                  (417,13,'2022-09-18 21:41:36','192.168.86.1',NULL,NULL),
                                                                                                  (418,13,'2022-09-18 21:42:06','192.168.86.1',NULL,NULL),
                                                                                                  (419,13,'2022-09-18 21:42:14','192.168.86.1',NULL,NULL),
                                                                                                  (420,13,'2022-09-18 21:42:25','192.168.86.1',NULL,NULL),
                                                                                                  (421,13,'2022-09-18 21:42:52','192.168.86.1',NULL,NULL),
                                                                                                  (422,13,'2022-09-18 21:44:29','192.168.86.1',NULL,NULL),
                                                                                                  (423,13,'2022-09-18 21:53:14','192.168.86.1',NULL,NULL),
                                                                                                  (424,13,'2022-09-18 21:54:06','192.168.86.1',NULL,NULL),
                                                                                                  (425,13,'2022-09-18 21:54:17','192.168.86.1',NULL,NULL),
                                                                                                  (426,13,'2022-09-18 21:55:20','192.168.86.1',NULL,NULL),
                                                                                                  (427,13,'2022-09-18 21:55:21','192.168.86.1',NULL,NULL),
                                                                                                  (428,13,'2022-09-18 21:55:21','192.168.86.1',NULL,NULL),
                                                                                                  (429,13,'2022-09-18 21:55:22','192.168.86.1',NULL,NULL),
                                                                                                  (430,13,'2022-09-18 21:55:40','192.168.86.1',NULL,NULL),
                                                                                                  (431,13,'2022-09-18 21:57:07','192.168.86.1',NULL,NULL),
                                                                                                  (432,13,'2022-09-18 21:57:31','192.168.86.1',NULL,NULL),
                                                                                                  (433,13,'2022-09-18 21:57:39','192.168.86.1',NULL,NULL),
                                                                                                  (434,13,'2022-09-18 22:13:44','192.168.86.1',NULL,NULL),
                                                                                                  (435,13,'2022-09-18 22:14:24','192.168.86.1',NULL,NULL),
                                                                                                  (436,13,'2022-09-18 22:14:35','192.168.86.1',NULL,NULL),
                                                                                                  (437,13,'2022-09-18 22:14:41','192.168.86.1',NULL,NULL),
                                                                                                  (438,13,'2022-09-18 22:14:47','192.168.86.1',NULL,NULL),
                                                                                                  (439,13,'2022-09-18 22:15:19','192.168.86.1',NULL,NULL),
                                                                                                  (440,13,'2022-09-18 22:15:51','192.168.86.1',NULL,NULL),
                                                                                                  (441,13,'2022-09-18 22:16:59','192.168.86.1',NULL,NULL),
                                                                                                  (442,13,'2022-09-18 22:17:04','192.168.86.1',NULL,NULL),
                                                                                                  (443,13,'2022-09-18 22:17:36','192.168.86.1',NULL,NULL),
                                                                                                  (444,13,'2022-09-18 22:17:40','192.168.86.1',NULL,NULL),
                                                                                                  (445,13,'2022-09-18 22:18:05','192.168.86.1',NULL,NULL),
                                                                                                  (446,13,'2022-09-18 22:18:59','192.168.86.1',NULL,NULL),
                                                                                                  (447,13,'2022-09-18 22:20:19','192.168.86.1',NULL,NULL),
                                                                                                  (448,13,'2022-09-18 22:38:16','192.168.86.1',NULL,NULL),
                                                                                                  (449,13,'2022-09-18 22:39:27','192.168.86.1',NULL,NULL),
                                                                                                  (450,13,'2022-09-18 23:01:48','192.168.86.1',NULL,NULL),
                                                                                                  (451,13,'2022-09-18 23:01:57','192.168.86.1',NULL,NULL),
                                                                                                  (452,13,'2022-09-18 23:02:16','192.168.86.1',NULL,NULL),
                                                                                                  (453,13,'2022-09-18 23:02:21','192.168.86.1',NULL,NULL),
                                                                                                  (454,13,'2022-09-18 23:03:08','192.168.86.1',NULL,NULL),
                                                                                                  (455,13,'2022-09-18 23:07:39','192.168.86.1',NULL,NULL),
                                                                                                  (456,13,'2022-09-18 23:10:07','192.168.86.1',NULL,NULL),
                                                                                                  (457,13,'2022-09-18 23:10:18','192.168.86.1',NULL,NULL),
                                                                                                  (458,13,'2022-09-18 23:11:43','192.168.86.1',NULL,NULL),
                                                                                                  (459,13,'2022-09-18 23:12:28','192.168.86.1',NULL,NULL),
                                                                                                  (460,13,'2022-09-18 23:14:28','192.168.86.1',NULL,NULL),
                                                                                                  (461,13,'2022-09-18 23:15:24','192.168.86.1',NULL,NULL),
                                                                                                  (462,13,'2022-09-18 23:31:38','192.168.86.1',NULL,NULL),
                                                                                                  (463,13,'2022-09-18 23:33:56','192.168.86.1',NULL,NULL),
                                                                                                  (464,13,'2022-09-18 23:36:33','192.168.86.1',NULL,NULL),
                                                                                                  (465,13,'2022-09-18 23:36:57','192.168.86.1',NULL,NULL),
                                                                                                  (466,13,'2022-09-18 23:40:47','192.168.86.1',NULL,NULL),
                                                                                                  (467,13,'2022-09-18 23:41:04','192.168.86.1',NULL,NULL),
                                                                                                  (468,13,'2022-09-18 23:41:19','192.168.86.1',NULL,NULL),
                                                                                                  (469,13,'2022-09-19 00:29:58','192.168.86.1',NULL,NULL),
                                                                                                  (470,13,'2022-09-19 00:34:04','192.168.86.1',NULL,NULL),
                                                                                                  (471,13,'2022-09-19 00:40:53','192.168.86.1',NULL,NULL),
                                                                                                  (472,13,'2022-09-19 00:41:35','192.168.86.1',NULL,NULL),
                                                                                                  (473,13,'2022-09-19 00:42:24','192.168.86.1',NULL,NULL),
                                                                                                  (474,13,'2022-09-19 00:48:25','192.168.86.1',NULL,NULL),
                                                                                                  (475,13,'2022-09-19 00:48:58','192.168.86.1',NULL,NULL),
                                                                                                  (476,13,'2022-09-19 00:49:00','192.168.86.1',NULL,NULL),
                                                                                                  (477,13,'2022-09-19 00:49:08','192.168.86.1',NULL,NULL),
                                                                                                  (478,13,'2022-09-19 00:52:12','192.168.86.1',NULL,NULL),
                                                                                                  (479,13,'2022-09-19 00:52:15','192.168.86.1',NULL,NULL),
                                                                                                  (480,13,'2022-09-19 00:52:18','192.168.86.1',NULL,NULL),
                                                                                                  (481,13,'2022-09-19 00:52:21','192.168.86.1',NULL,NULL),
                                                                                                  (482,13,'2022-09-19 00:53:08','192.168.86.1',NULL,NULL),
                                                                                                  (483,13,'2022-09-19 00:53:14','192.168.86.1',NULL,NULL),
                                                                                                  (484,13,'2022-09-19 00:53:21','192.168.86.1',NULL,NULL),
                                                                                                  (485,13,'2022-09-19 01:06:21','192.168.86.1',NULL,NULL),
                                                                                                  (486,13,'2022-09-19 01:07:15','192.168.86.1',NULL,NULL),
                                                                                                  (487,13,'2022-09-19 01:07:45','192.168.86.1',NULL,NULL),
                                                                                                  (488,13,'2022-09-19 01:16:17','192.168.86.1',NULL,NULL),
                                                                                                  (489,13,'2022-09-19 01:22:29','192.168.86.1',NULL,NULL),
                                                                                                  (490,13,'2022-09-19 01:22:34','192.168.86.1',NULL,NULL),
                                                                                                  (491,13,'2022-09-19 01:28:13','192.168.86.1',NULL,NULL),
                                                                                                  (492,13,'2022-09-19 01:28:21','192.168.86.1',NULL,NULL),
                                                                                                  (493,13,'2022-09-19 01:28:26','192.168.86.1',NULL,NULL),
                                                                                                  (494,13,'2022-09-19 01:28:33','192.168.86.1',NULL,NULL),
                                                                                                  (495,13,'2022-09-19 01:28:43','192.168.86.1',NULL,NULL),
                                                                                                  (496,13,'2022-09-19 01:28:59','192.168.86.1',NULL,NULL),
                                                                                                  (497,13,'2022-09-19 01:35:39','192.168.86.1',NULL,NULL),
                                                                                                  (498,13,'2022-09-19 01:44:10','192.168.86.1',NULL,NULL),
                                                                                                  (499,13,'2022-09-19 01:47:29','192.168.86.1',NULL,NULL),
                                                                                                  (500,13,'2022-09-19 01:47:48','192.168.86.1',NULL,NULL),
                                                                                                  (501,13,'2022-09-19 01:51:14','192.168.86.1',NULL,NULL),
                                                                                                  (502,13,'2022-09-19 01:53:27','192.168.86.1',NULL,NULL),
                                                                                                  (503,13,'2022-09-19 01:55:27','192.168.86.1',NULL,NULL),
                                                                                                  (504,13,'2022-09-19 01:55:36','192.168.86.1',NULL,NULL),
                                                                                                  (505,13,'2022-09-19 01:59:18','192.168.86.1',NULL,NULL),
                                                                                                  (506,13,'2022-09-19 02:02:32','192.168.86.1',NULL,NULL),
                                                                                                  (507,13,'2022-09-19 02:03:22','192.168.86.1',NULL,NULL),
                                                                                                  (508,13,'2022-09-19 02:04:17','192.168.86.1',NULL,NULL),
                                                                                                  (509,13,'2022-09-19 02:10:52','192.168.86.1',NULL,NULL),
                                                                                                  (510,13,'2022-09-19 02:11:06','192.168.86.1',NULL,NULL),
                                                                                                  (511,13,'2022-09-19 02:20:30','192.168.86.1',NULL,NULL),
                                                                                                  (512,13,'2022-09-19 02:20:37','192.168.86.1',NULL,NULL),
                                                                                                  (513,13,'2022-09-19 02:21:45','192.168.86.1',NULL,NULL),
                                                                                                  (514,13,'2022-09-19 02:22:09','192.168.86.1',NULL,NULL),
                                                                                                  (515,13,'2022-09-19 02:22:14','192.168.86.1',NULL,NULL),
                                                                                                  (516,13,'2022-09-19 02:23:17','192.168.86.1',NULL,NULL),
                                                                                                  (517,13,'2022-09-19 02:24:09','192.168.86.1',NULL,NULL),
                                                                                                  (518,13,'2022-09-19 02:25:45','192.168.86.1',NULL,NULL),
                                                                                                  (519,13,'2022-09-19 02:26:21','192.168.86.1',NULL,NULL),
                                                                                                  (520,13,'2022-09-19 02:27:45','192.168.86.1',NULL,NULL),
                                                                                                  (521,13,'2022-09-19 02:28:51','192.168.86.1',NULL,NULL),
                                                                                                  (522,13,'2022-09-19 02:29:05','192.168.86.1',NULL,NULL),
                                                                                                  (523,13,'2022-09-19 02:29:31','192.168.86.1',NULL,NULL),
                                                                                                  (524,13,'2022-09-19 02:30:09','192.168.86.1',NULL,NULL),
                                                                                                  (525,13,'2022-09-19 02:30:22','192.168.86.1',NULL,NULL),
                                                                                                  (526,13,'2022-09-19 02:31:00','192.168.86.1',NULL,NULL),
                                                                                                  (527,13,'2022-09-19 02:31:44','192.168.86.1',NULL,NULL),
                                                                                                  (528,13,'2022-09-19 02:32:48','192.168.86.1',NULL,NULL),
                                                                                                  (529,13,'2022-09-19 02:32:53','192.168.86.1',NULL,NULL),
                                                                                                  (530,13,'2022-09-19 02:33:09','192.168.86.1',NULL,NULL),
                                                                                                  (531,13,'2022-09-19 02:33:21','192.168.86.1',NULL,NULL),
                                                                                                  (532,13,'2022-09-19 02:33:27','192.168.86.1',NULL,NULL),
                                                                                                  (533,13,'2022-09-19 02:33:40','192.168.86.1',NULL,NULL),
                                                                                                  (534,13,'2022-09-19 02:34:30','192.168.86.1',NULL,NULL),
                                                                                                  (535,13,'2022-09-19 02:34:39','192.168.86.1',NULL,NULL),
                                                                                                  (536,13,'2022-09-19 02:34:48','192.168.86.1',NULL,NULL),
                                                                                                  (537,13,'2022-09-19 02:35:38','192.168.86.1',NULL,NULL),
                                                                                                  (538,13,'2022-09-19 02:35:49','192.168.86.1',NULL,NULL),
                                                                                                  (539,13,'2022-09-19 02:35:59','192.168.86.1',NULL,NULL),
                                                                                                  (540,13,'2022-09-19 02:36:15','192.168.86.1',NULL,NULL),
                                                                                                  (541,13,'2022-09-19 02:36:35','192.168.86.1',NULL,NULL),
                                                                                                  (542,13,'2022-09-19 02:37:14','192.168.86.1',NULL,NULL),
                                                                                                  (543,13,'2022-09-19 02:37:36','192.168.86.1',NULL,NULL),
                                                                                                  (544,13,'2022-09-19 02:38:08','192.168.86.1',NULL,NULL),
                                                                                                  (545,13,'2022-09-19 02:38:28','192.168.86.1',NULL,NULL),
                                                                                                  (546,13,'2022-09-19 02:39:55','192.168.86.1',NULL,NULL),
                                                                                                  (547,13,'2022-09-19 02:42:07','192.168.86.1',NULL,NULL),
                                                                                                  (548,13,'2022-09-19 02:45:56','192.168.86.1',NULL,NULL),
                                                                                                  (549,13,'2022-09-19 02:48:22','192.168.86.1',NULL,NULL),
                                                                                                  (550,13,'2022-09-19 02:51:35','192.168.86.1',NULL,NULL),
                                                                                                  (551,13,'2022-09-19 02:51:45','192.168.86.1',NULL,NULL),
                                                                                                  (552,13,'2022-09-19 02:58:17','192.168.86.1',NULL,NULL),
                                                                                                  (553,13,'2022-09-19 03:01:52','192.168.86.1',NULL,NULL),
                                                                                                  (554,13,'2022-09-19 03:02:43','192.168.86.1',NULL,NULL),
                                                                                                  (555,13,'2022-09-19 03:06:36','192.168.86.1',NULL,NULL),
                                                                                                  (556,13,'2022-09-19 03:07:22','192.168.86.1',NULL,NULL),
                                                                                                  (557,13,'2022-09-19 03:07:59','192.168.86.1',NULL,NULL),
                                                                                                  (558,13,'2022-09-19 03:08:04','192.168.86.1',NULL,NULL),
                                                                                                  (559,13,'2022-09-19 03:08:11','192.168.86.1',NULL,NULL),
                                                                                                  (560,13,'2022-09-19 03:08:46','192.168.86.1',NULL,NULL),
                                                                                                  (561,13,'2022-09-19 03:09:03','192.168.86.1',NULL,NULL),
                                                                                                  (562,13,'2022-09-19 03:09:50','192.168.86.1',NULL,NULL),
                                                                                                  (563,13,'2022-09-19 03:09:55','192.168.86.1',NULL,NULL),
                                                                                                  (564,13,'2022-09-19 03:10:26','192.168.86.1',NULL,NULL),
                                                                                                  (565,13,'2022-09-19 03:14:48','192.168.86.1',NULL,NULL),
                                                                                                  (566,13,'2022-09-19 03:15:27','192.168.86.1',NULL,NULL),
                                                                                                  (567,13,'2022-09-19 03:15:30','192.168.86.1',NULL,NULL),
                                                                                                  (568,13,'2022-09-19 03:18:33','192.168.86.1',NULL,NULL),
                                                                                                  (569,13,'2022-09-19 03:19:24','192.168.86.1',NULL,NULL),
                                                                                                  (570,13,'2022-09-19 03:20:47','192.168.86.1',NULL,NULL),
                                                                                                  (571,13,'2022-09-19 03:25:14','192.168.86.1',NULL,NULL),
                                                                                                  (572,13,'2022-09-19 03:32:07','192.168.86.1',NULL,NULL),
                                                                                                  (573,13,'2022-09-19 03:32:50','192.168.86.1',NULL,NULL),
                                                                                                  (574,13,'2022-09-19 03:34:49','192.168.86.1',NULL,NULL),
                                                                                                  (575,13,'2022-09-19 03:36:27','192.168.86.1',NULL,NULL),
                                                                                                  (576,13,'2022-09-19 03:38:00','192.168.86.1',NULL,NULL),
                                                                                                  (577,13,'2022-09-19 03:47:57','192.168.86.1',NULL,NULL),
                                                                                                  (578,13,'2022-09-19 03:48:57','192.168.86.1',NULL,NULL),
                                                                                                  (579,13,'2022-09-19 03:50:25','192.168.86.1',NULL,NULL),
                                                                                                  (580,13,'2022-09-19 03:54:43','192.168.86.1',NULL,NULL),
                                                                                                  (581,13,'2022-09-19 11:17:11','192.168.86.1',NULL,NULL),
                                                                                                  (582,13,'2022-09-19 11:17:40','192.168.86.1',NULL,NULL),
                                                                                                  (583,13,'2022-09-19 12:00:25','192.168.86.1',NULL,NULL),
                                                                                                  (584,13,'2022-09-19 12:00:34','192.168.86.1',NULL,NULL),
                                                                                                  (585,13,'2022-09-19 12:01:37','192.168.86.1',NULL,NULL),
                                                                                                  (586,13,'2022-09-19 12:03:59','192.168.86.1',NULL,NULL),
                                                                                                  (587,13,'2022-09-19 12:04:23','192.168.86.1',NULL,NULL),
                                                                                                  (588,13,'2022-09-19 12:04:41','192.168.86.1',NULL,NULL),
                                                                                                  (589,13,'2022-09-19 12:05:18','192.168.86.1',NULL,NULL),
                                                                                                  (590,13,'2022-09-19 12:05:59','192.168.86.1',NULL,NULL),
                                                                                                  (591,13,'2022-09-19 12:08:24','192.168.86.1',NULL,NULL),
                                                                                                  (592,13,'2022-09-19 13:04:27','192.168.86.1',NULL,NULL),
                                                                                                  (593,13,'2022-09-19 13:05:55','192.168.86.1',NULL,NULL),
                                                                                                  (594,13,'2022-09-19 13:09:46','192.168.86.1',NULL,NULL),
                                                                                                  (595,13,'2022-09-19 13:39:29','192.168.86.1',NULL,NULL),
                                                                                                  (596,13,'2022-09-19 13:39:37','192.168.86.1',NULL,NULL),
                                                                                                  (597,13,'2022-09-19 13:45:06','192.168.86.1',NULL,NULL),
                                                                                                  (598,13,'2022-09-19 14:49:58','192.168.86.1',NULL,NULL),
                                                                                                  (599,13,'2022-09-19 14:55:44','192.168.86.1',NULL,NULL),
                                                                                                  (600,13,'2022-09-19 22:37:54','192.168.86.1',NULL,NULL),
                                                                                                  (601,13,'2022-09-20 04:59:42','192.168.86.1',NULL,NULL),
                                                                                                  (602,13,'2022-09-20 05:24:19','192.168.86.1',NULL,NULL),
                                                                                                  (603,13,'2022-09-20 06:17:49','192.168.86.1',NULL,NULL),
                                                                                                  (604,13,'2022-09-20 10:53:28','192.168.86.1',NULL,NULL),
                                                                                                  (605,12,'2022-09-20 12:07:44','192.168.86.1',NULL,NULL),
                                                                                                  (606,13,'2022-09-20 19:14:14','192.168.86.1',NULL,NULL),
                                                                                                  (607,13,'2022-09-20 20:08:42','192.168.86.1',NULL,NULL),
                                                                                                  (608,12,'2022-09-21 12:26:19','192.168.86.1',NULL,NULL),
                                                                                                  (609,13,'2022-09-21 21:00:08','192.168.86.1',NULL,NULL),
                                                                                                  (610,13,'2022-09-21 21:51:28','192.168.86.1',NULL,NULL),
                                                                                                  (611,13,'2022-09-21 22:25:23','192.168.86.1',NULL,NULL),
                                                                                                  (612,13,'2022-09-21 23:55:32','192.168.86.1',NULL,NULL),
                                                                                                  (613,13,'2022-09-22 08:27:02','192.168.86.1',NULL,NULL),
                                                                                                  (614,13,'2022-09-22 09:56:17','192.168.86.1',NULL,NULL),
                                                                                                  (615,13,'2022-09-22 15:58:33','192.168.86.1',NULL,NULL),
                                                                                                  (616,12,'2022-09-22 16:46:29','192.168.86.1',NULL,NULL),
                                                                                                  (617,13,'2022-09-22 17:15:28','192.168.86.1',NULL,NULL),
                                                                                                  (618,13,'2022-09-22 18:40:39','192.168.86.1',NULL,NULL),
                                                                                                  (619,13,'2022-09-23 10:35:23','192.168.86.1',NULL,NULL),
                                                                                                  (620,13,'2022-09-23 11:58:37','192.168.86.1',NULL,NULL),
                                                                                                  (621,13,'2022-09-23 13:06:31','192.168.86.1',NULL,NULL),
                                                                                                  (622,13,'2022-09-23 17:54:17','192.168.86.1',NULL,NULL),
                                                                                                  (623,12,'2022-09-23 18:23:27','192.168.86.1',NULL,NULL),
                                                                                                  (624,13,'2022-09-23 19:53:41','192.168.86.1',NULL,NULL),
                                                                                                  (625,13,'2022-09-23 19:53:45','192.168.86.1',NULL,NULL),
                                                                                                  (626,12,'2022-09-23 19:53:54','192.168.86.1',NULL,NULL),
                                                                                                  (627,13,'2022-09-24 15:58:34','192.168.86.1',NULL,NULL),
                                                                                                  (628,12,'2022-09-24 22:34:03','192.168.86.1',NULL,NULL),
                                                                                                  (629,13,'2022-09-25 00:10:19','192.168.86.1',NULL,NULL),
                                                                                                  (630,13,'2022-09-25 00:18:52','192.168.86.1',NULL,NULL),
                                                                                                  (631,13,'2022-09-25 00:21:41','192.168.86.1',NULL,NULL),
                                                                                                  (632,13,'2022-09-25 00:34:58','192.168.86.1',NULL,NULL),
                                                                                                  (633,13,'2022-09-25 00:35:00','192.168.86.1',NULL,NULL),
                                                                                                  (634,13,'2022-09-25 00:37:55','192.168.86.1',NULL,NULL),
                                                                                                  (635,13,'2022-09-25 00:38:10','192.168.86.1',NULL,NULL),
                                                                                                  (636,13,'2022-09-25 00:38:25','192.168.86.1',NULL,NULL),
                                                                                                  (637,13,'2022-09-25 01:01:24','192.168.86.1',NULL,NULL),
                                                                                                  (638,13,'2022-09-25 17:05:39','192.168.86.1',NULL,NULL),
                                                                                                  (639,12,'2022-09-26 03:01:19','192.168.86.1',NULL,NULL),
                                                                                                  (640,13,'2022-09-26 05:00:52','192.168.86.1',NULL,NULL),
                                                                                                  (641,13,'2022-09-26 05:48:27','192.168.86.1',NULL,NULL),
                                                                                                  (642,13,'2022-09-26 06:30:25','192.168.86.1',NULL,NULL),
                                                                                                  (643,13,'2022-09-26 06:33:01','192.168.86.1',NULL,NULL),
                                                                                                  (644,13,'2022-09-26 08:27:21','192.168.86.1',NULL,NULL),
                                                                                                  (645,13,'2022-09-26 13:38:43','192.168.86.1',NULL,NULL),
                                                                                                  (646,13,'2022-09-26 22:09:16','192.168.86.1',NULL,NULL),
                                                                                                  (647,12,'2022-09-27 13:21:11','192.168.86.1',NULL,NULL),
                                                                                                  (648,13,'2022-09-27 13:23:13','192.168.86.1',NULL,NULL),
                                                                                                  (649,13,'2022-09-27 18:50:47','192.168.86.1',NULL,NULL),
                                                                                                  (650,13,'2022-09-27 20:55:15','192.168.86.1',NULL,NULL);

/*Table structure for table `ums_admin_role_relation` */

DROP TABLE IF EXISTS `ums_admin_role_relation`;

CREATE TABLE `ums_admin_role_relation` (
                                           `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                           `admin_id` bigint(20) DEFAULT NULL,
                                           `role_id` bigint(20) DEFAULT NULL,
                                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COMMENT='后台用户和角色关系表';

/*Data for the table `ums_admin_role_relation` */

insert  into `ums_admin_role_relation`(`id`,`admin_id`,`role_id`) values
                                                                      (26,3,5),
                                                                      (27,6,1),
                                                                      (28,7,2),
                                                                      (30,4,5),
                                                                      (31,8,5),
                                                                      (39,10,8),
                                                                      (42,12,5),
                                                                      (46,13,2),
                                                                      (47,13,5),
                                                                      (73,12,12),
                                                                      (74,12,13),
                                                                      (75,12,14),
                                                                      (112,1,5),
                                                                      (113,40,5),
                                                                      (114,41,5);

/*Table structure for table `ums_menu` */

DROP TABLE IF EXISTS `ums_menu`;

CREATE TABLE `ums_menu` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `parent_id` bigint(20) DEFAULT NULL COMMENT '父级ID',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `title` varchar(100) DEFAULT NULL COMMENT '菜单名称',
                            `level` int(4) DEFAULT NULL COMMENT '菜单级数',
                            `sort` int(4) DEFAULT NULL COMMENT '菜单排序',
                            `name` varchar(100) DEFAULT NULL COMMENT '前端名称',
                            `icon` varchar(200) DEFAULT NULL COMMENT '前端图标',
                            `hidden` int(1) DEFAULT NULL COMMENT '前端隐藏',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COMMENT='后台菜单表';

/*Data for the table `ums_menu` */

insert  into `ums_menu`(`id`,`parent_id`,`create_time`,`title`,`level`,`sort`,`name`,`icon`,`hidden`) values
                                                                                                          (30,0,NULL,'演示页',0,0,'demo','sad',0),
                                                                                                          (31,0,NULL,'权限',0,0,'auth','auth',0),
                                                                                                          (32,31,NULL,'用户',1,0,'user','user',0),
                                                                                                          (33,31,NULL,'角色',1,0,'role','role',0),
                                                                                                          (34,31,NULL,'菜单',2,0,'menu','menu',0),
                                                                                                          (35,31,NULL,'资源',1,0,'resource','resource',0),
                                                                                                          (36,32,NULL,'用户详情',3,0,'userdetails','userdetails',0),
                                                                                                          (37,34,NULL,'菜单详情',3,NULL,'menudetails','menudetails',NULL);

/*Table structure for table `ums_resource` */

DROP TABLE IF EXISTS `ums_resource`;

CREATE TABLE `ums_resource` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `name` varchar(200) DEFAULT NULL COMMENT '资源名称',
                                `url` varchar(200) DEFAULT NULL COMMENT '资源URL',
                                `description` varchar(500) DEFAULT NULL COMMENT '描述',
                                `category_id` bigint(20) DEFAULT NULL COMMENT '资源分类ID',
                                PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COMMENT='后台资源表';

/*Data for the table `ums_resource` */

insert  into `ums_resource`(`id`,`create_time`,`name`,`url`,`description`,`category_id`) values
                                                                                             (1,'2020-02-04 17:04:55','商品品牌管理','/brand/**',NULL,1),
                                                                                             (2,'2020-02-04 17:05:35','商品属性分类管理','/productAttribute/**',NULL,1),
                                                                                             (3,'2020-02-04 17:06:13','商品属性管理','/productAttribute/**',NULL,1),
                                                                                             (4,'2020-02-04 17:07:15','商品分类管理','/productCategory/**',NULL,1),
                                                                                             (5,'2020-02-04 17:09:16','商品管理','/product/**',NULL,1),
                                                                                             (6,'2020-02-04 17:09:53','商品库存管理','/sku/**',NULL,1),
                                                                                             (8,'2020-02-05 14:43:37','订单管理','/order/**','',2),
                                                                                             (9,'2020-02-05 14:44:22',' 订单退货申请管理','/returnApply/**','',2),
                                                                                             (10,'2020-02-05 14:45:08','退货原因管理','/returnReason/**','',2),
                                                                                             (11,'2020-02-05 14:45:43','订单设置管理','/orderSetting/**','',2),
                                                                                             (12,'2020-02-05 14:46:23','收货地址管理','/companyAddress/**','',2),
                                                                                             (13,'2020-02-07 16:37:22','优惠券管理','/coupon/**','',3),
                                                                                             (14,'2020-02-07 16:37:59','优惠券领取记录管理','/couponHistory/**','',3),
                                                                                             (15,'2020-02-07 16:38:28','限时购活动管理','/flash/**','',3),
                                                                                             (16,'2020-02-07 16:38:59','限时购商品关系管理','/flashProductRelation/**','',3),
                                                                                             (17,'2020-02-07 16:39:22','限时购场次管理','/flashSession/**','',3),
                                                                                             (18,'2020-02-07 16:40:07','首页轮播广告管理','/home/advertise/**','',3),
                                                                                             (19,'2020-02-07 16:40:34','首页品牌管理','/home/brand/**','',3),
                                                                                             (20,'2020-02-07 16:41:06','首页新品管理','/home/newProduct/**','',3),
                                                                                             (21,'2020-02-07 16:42:16','首页人气推荐管理','/home/recommendProduct/**','',3),
                                                                                             (22,'2020-02-07 16:42:48','首页专题推荐管理','/home/recommendSubject/**','',3),
                                                                                             (23,'2020-02-07 16:44:56',' 商品优选管理','/prefrenceArea/**','',5),
                                                                                             (24,'2020-02-07 16:45:39','商品专题管理','/subject/**','',5),
                                                                                             (25,'2020-02-07 16:47:34','后台用户管理','/admin/**','',4),
                                                                                             (26,'2020-02-07 16:48:24','后台用户角色管理','/role/**','',4),
                                                                                             (27,'2020-02-07 16:48:48','后台菜单管理','/menu/**','',4),
                                                                                             (28,'2020-02-07 16:49:18','后台资源分类管理','/resourceCategory/**','',4),
                                                                                             (29,'2020-02-07 16:49:45','后台资源管理','/resource/**','',4);

/*Table structure for table `ums_resource_category` */

DROP TABLE IF EXISTS `ums_resource_category`;

CREATE TABLE `ums_resource_category` (
                                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                         `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                         `name` varchar(200) DEFAULT NULL COMMENT '分类名称',
                                         `sort` int(4) DEFAULT NULL COMMENT '排序',
                                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='资源分类表';

/*Data for the table `ums_resource_category` */

insert  into `ums_resource_category`(`id`,`create_time`,`name`,`sort`) values
                                                                           (1,'2020-02-05 10:21:44','商品模块',0),
                                                                           (2,'2020-02-05 10:22:34','订单模块',0),
                                                                           (3,'2020-02-05 10:22:48','营销模块',0),
                                                                           (4,'2020-02-05 10:23:04','权限模块',0),
                                                                           (5,'2020-02-07 16:34:27','内容模块',0),
                                                                           (6,'2020-02-07 16:35:49','其他模块',0);

/*Table structure for table `ums_role` */

DROP TABLE IF EXISTS `ums_role`;

CREATE TABLE `ums_role` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) DEFAULT NULL COMMENT '名称',
                            `description` varchar(500) DEFAULT NULL COMMENT '描述',
                            `admin_count` int(11) DEFAULT NULL COMMENT '后台用户数量',
                            `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                            `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
                            `sort` int(11) DEFAULT '0',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT='后台用户角色表';

/*Data for the table `ums_role` */

insert  into `ums_role`(`id`,`name`,`description`,`admin_count`,`create_time`,`status`,`sort`) values
                                                                                                   (1,'商品管理员','只能查看及操作商品',0,'2022-09-27 21:08:41',0,0),
                                                                                                   (2,'订单管理员','只能查看及操作订单',0,'2022-09-26 22:31:34',1,0),
                                                                                                   (5,'超级管理员','拥有所有查看和操作功能',0,'2020-02-02 15:11:05',1,0),
                                                                                                   (8,'权限管理员','用于权限模块所有操作功能',0,'2020-08-24 10:57:35',1,0),
                                                                                                   (12,'超级用户','非常厉害的用户',0,NULL,0,0),
                                                                                                   (13,'小用户','asd',12,NULL,1,0);

/*Table structure for table `ums_role_menu_relation` */

DROP TABLE IF EXISTS `ums_role_menu_relation`;

CREATE TABLE `ums_role_menu_relation` (
                                          `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                          `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
                                          `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4 COMMENT='后台角色菜单关系表';

/*Data for the table `ums_role_menu_relation` */

insert  into `ums_role_menu_relation`(`id`,`role_id`,`menu_id`) values
                                                                    (33,1,1),
                                                                    (34,1,2),
                                                                    (35,1,3),
                                                                    (36,1,4),
                                                                    (37,1,5),
                                                                    (38,1,6),
                                                                    (53,2,7),
                                                                    (54,2,8),
                                                                    (55,2,9),
                                                                    (56,2,10),
                                                                    (57,2,11),
                                                                    (72,5,1),
                                                                    (73,5,2),
                                                                    (74,5,3),
                                                                    (75,5,4),
                                                                    (76,5,5),
                                                                    (77,5,6),
                                                                    (78,5,7),
                                                                    (79,5,8),
                                                                    (80,5,9),
                                                                    (81,5,10),
                                                                    (82,5,11),
                                                                    (83,5,12),
                                                                    (84,5,13),
                                                                    (85,5,14),
                                                                    (86,5,16),
                                                                    (87,5,17),
                                                                    (88,5,18),
                                                                    (89,5,19),
                                                                    (90,5,20),
                                                                    (91,5,21),
                                                                    (92,5,22),
                                                                    (93,5,23),
                                                                    (94,5,24),
                                                                    (95,5,25),
                                                                    (96,6,21),
                                                                    (97,6,22),
                                                                    (98,6,23),
                                                                    (99,6,24),
                                                                    (100,6,25),
                                                                    (101,7,21),
                                                                    (102,7,22),
                                                                    (103,7,23),
                                                                    (104,7,24),
                                                                    (105,7,25),
                                                                    (106,8,21),
                                                                    (107,8,22),
                                                                    (108,8,23),
                                                                    (109,8,24),
                                                                    (110,8,25),
                                                                    (111,10,26),
                                                                    (112,10,27),
                                                                    (113,5,30),
                                                                    (114,5,31),
                                                                    (115,5,32),
                                                                    (116,5,33),
                                                                    (117,5,34),
                                                                    (118,5,35),
                                                                    (119,5,36),
                                                                    (120,5,37),
                                                                    (121,1,1),
                                                                    (122,1,1),
                                                                    (123,1,30);

/*Table structure for table `ums_role_operation` */

DROP TABLE IF EXISTS `ums_role_operation`;

CREATE TABLE `ums_role_operation` (
                                      `role_id` bigint(20) NOT NULL COMMENT '角色id',
                                      `add` int(1) DEFAULT NULL COMMENT '添加操作',
                                      `edit` int(1) DEFAULT NULL COMMENT '编辑操作',
                                      `delete` int(1) DEFAULT NULL COMMENT '删除操作',
                                      `find` int(1) DEFAULT NULL COMMENT '查询操作',
                                      PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ums_role_operation` */

insert  into `ums_role_operation`(`role_id`,`add`,`edit`,`delete`,`find`) values
                                                                              (1,0,1,0,1),
                                                                              (2,1,1,0,1),
                                                                              (5,1,1,1,1);

/*Table structure for table `ums_role_resource_relation` */

DROP TABLE IF EXISTS `ums_role_resource_relation`;

CREATE TABLE `ums_role_resource_relation` (
                                              `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                              `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
                                              `resource_id` bigint(20) DEFAULT NULL COMMENT '资源ID',
                                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=utf8mb4 COMMENT='后台角色资源关系表';

/*Data for the table `ums_role_resource_relation` */

insert  into `ums_role_resource_relation`(`id`,`role_id`,`resource_id`) values
                                                                            (103,2,8),
                                                                            (104,2,9),
                                                                            (105,2,10),
                                                                            (106,2,11),
                                                                            (107,2,12),
                                                                            (142,5,1),
                                                                            (143,5,2),
                                                                            (144,5,3),
                                                                            (145,5,4),
                                                                            (146,5,5),
                                                                            (147,5,6),
                                                                            (148,5,8),
                                                                            (149,5,9),
                                                                            (150,5,10),
                                                                            (151,5,11),
                                                                            (152,5,12),
                                                                            (153,5,13),
                                                                            (154,5,14),
                                                                            (155,5,15),
                                                                            (156,5,16),
                                                                            (157,5,17),
                                                                            (158,5,18),
                                                                            (159,5,19),
                                                                            (160,5,20),
                                                                            (161,5,21),
                                                                            (162,5,22),
                                                                            (163,5,23),
                                                                            (164,5,24),
                                                                            (165,5,25),
                                                                            (166,5,26),
                                                                            (167,5,27),
                                                                            (168,5,28),
                                                                            (169,5,29),
                                                                            (170,1,1),
                                                                            (171,1,2),
                                                                            (172,1,3),
                                                                            (173,1,4),
                                                                            (174,1,5),
                                                                            (175,1,6),
                                                                            (176,1,23),
                                                                            (177,1,24),
                                                                            (178,6,25),
                                                                            (179,6,26),
                                                                            (180,6,27),
                                                                            (181,6,28),
                                                                            (182,6,29),
                                                                            (205,7,25),
                                                                            (206,7,26),
                                                                            (207,7,27),
                                                                            (208,7,28),
                                                                            (209,7,29),
                                                                            (210,7,31),
                                                                            (211,8,25),
                                                                            (212,8,26),
                                                                            (213,8,27),
                                                                            (214,8,28),
                                                                            (215,8,29);

/*Table structure for table `voucher_item` */

DROP TABLE IF EXISTS `voucher_item`;

CREATE TABLE `voucher_item` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '凭证单号',
                                `title` varchar(100) DEFAULT NULL COMMENT '流程标题',
                                `applicant` bigint(20) DEFAULT NULL COMMENT '申请人',
                                `dept_id` int(11) DEFAULT NULL COMMENT '申请部门',
                                `app_date` datetime DEFAULT NULL COMMENT '申请日期',
                                `total` decimal(25,2) DEFAULT NULL COMMENT '总金额',
                                `status` char(5) DEFAULT NULL COMMENT '凭证状态',
                                `comment` varchar(100) DEFAULT NULL COMMENT '凭证返回说明',
                                PRIMARY KEY (`id`),
                                KEY `idx_applicant` (`applicant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='凭证单';

/*Data for the table `voucher_item` */

/*Table structure for table `zj_account_summary` */

DROP TABLE IF EXISTS `zj_account_summary`;

CREATE TABLE `zj_account_summary` (
                                      `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                      `account_id` int(11) DEFAULT NULL COMMENT '公司编号',
                                      `debtor_accrual` decimal(25,2) DEFAULT NULL COMMENT '本期借方发生额',
                                      `creditor_accrual` decimal(25,2) DEFAULT NULL COMMENT '本期贷方发生额',
                                      `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                      PRIMARY KEY (`id`),
                                      KEY `idx_account_id` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='科目汇总表';

/*Data for the table `zj_account_summary` */

/*Table structure for table `zj_contract_item` */

DROP TABLE IF EXISTS `zj_contract_item`;

CREATE TABLE `zj_contract_item` (
                                    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                                    `contract_name` varchar(100) DEFAULT NULL COMMENT '合同名称',
                                    `supplier_id` int(11) DEFAULT NULL COMMENT '供应商',
                                    `account_id` int(11) DEFAULT NULL COMMENT '收款方',
                                    `price` decimal(25,2) DEFAULT NULL COMMENT '金额',
                                    `invoice_amount` decimal(25,2) DEFAULT NULL COMMENT '已开票金额',
                                    `paid_amount` decimal(25,2) DEFAULT NULL COMMENT '已付款金额',
                                    `unpay_amount` decimal(25,2) DEFAULT NULL COMMENT '未付款金额',
                                    `create_time` datetime DEFAULT NULL COMMENT '创建日期',
                                    PRIMARY KEY (`id`),
                                    KEY `idx_account_id` (`account_id`),
                                    KEY `idx_supplier_id` (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='合同付款表';

/*Data for the table `zj_contract_item` */

/*Table structure for table `zj_supplier` */

DROP TABLE IF EXISTS `zj_supplier`;

CREATE TABLE `zj_supplier` (
                               `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
                               `company_id` int(11) DEFAULT NULL COMMENT '公司编号',
                               `supplier_type` varchar(20) DEFAULT NULL COMMENT '供应商类型',
                               `access_date` datetime DEFAULT NULL COMMENT '准入日期',
                               `status` varchar(8) DEFAULT NULL COMMENT '状态',
                               `grade` varchar(8) DEFAULT NULL COMMENT '等级',
                               PRIMARY KEY (`id`),
                               KEY `idx_company_id` (`company_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='供应商';

/*Data for the table `zj_supplier` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
