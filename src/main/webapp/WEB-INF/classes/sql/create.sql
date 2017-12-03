/*
Navicat PGSQL Data Transfer

Source Server         : PostgreSQL
Source Server Version : 90602
Source Host           : localhost:5432
Source Database       : cbr
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90602
File Encoding         : 65001

Date: 2017-12-03 05:32:45
*/


-- ----------------------------
-- Table structure for bnkseek
-- ----------------------------
DROP TABLE IF EXISTS "public"."bnkseek";
CREATE TABLE "public"."bnkseek" (
"vkey" varchar(255) COLLATE "default" NOT NULL,
"real" varchar(4) COLLATE "default",
"pzn" varchar(2) COLLATE "default",
"uer" varchar(1) COLLATE "default",
"rgn" varchar(2) COLLATE "default",
"ind" varchar(6) COLLATE "default",
"tnp" varchar(1) COLLATE "default",
"nnp" varchar(25) COLLATE "default",
"adr" varchar(30) COLLATE "default",
"rkc" varchar(9) COLLATE "default",
"namep" varchar(45) COLLATE "default",
"namen" varchar(30) COLLATE "default",
"newnum" varchar(9) COLLATE "default",
"newks" varchar(9) COLLATE "default",
"permfo" varchar(6) COLLATE "default",
"srok" varchar(2) COLLATE "default",
"at1" varchar(7) COLLATE "default",
"at2" varchar(7) COLLATE "default",
"telef" varchar(25) COLLATE "default",
"regn" varchar(9) COLLATE "default",
"okpo" varchar(8) COLLATE "default",
"dt_izm" date,
"cks" varchar(6) COLLATE "default",
"ksnp" varchar(20) COLLATE "default",
"date_in" date,
"date_ch" date,
"vkeydel" varchar(8) COLLATE "default",
"dt_izmr" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for pzn
-- ----------------------------
DROP TABLE IF EXISTS "public"."pzn";
CREATE TABLE "public"."pzn" (
"vkey" varchar(2) COLLATE "default",
"pzn" varchar(2) COLLATE "default",
"imy" varchar(4) COLLATE "default",
"name" varchar(40) COLLATE "default",
"cb_date" date,
"ce_date" date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for reg
-- ----------------------------
DROP TABLE IF EXISTS "public"."reg";
CREATE TABLE "public"."reg" (
"vkey" varchar(2) COLLATE "default",
"rgn" varchar(2) COLLATE "default",
"name" varchar(40) COLLATE "default",
"center" varchar(30) COLLATE "default",
"namet" varchar(40) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for tnp
-- ----------------------------
DROP TABLE IF EXISTS "public"."tnp";
CREATE TABLE "public"."tnp" (
"vkey" varchar(2) COLLATE "default",
"tnp" varchar(2) COLLATE "default",
"fullname" varchar(25) COLLATE "default",
"shortname" varchar(5) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for uer
-- ----------------------------
DROP TABLE IF EXISTS "public"."uer";
CREATE TABLE "public"."uer" (
"vkey" varchar(2) COLLATE "default" NOT NULL,
"uer" varchar(1) COLLATE "default",
"uername" varchar(70) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table bnkseek
-- ----------------------------
ALTER TABLE "public"."bnkseek" ADD PRIMARY KEY ("vkey");

-- ----------------------------
-- Primary Key structure for table uer
-- ----------------------------
ALTER TABLE "public"."uer" ADD PRIMARY KEY ("vkey");
