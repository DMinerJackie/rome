package com.jackie.wowjava.best.practice.java.export;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Author: Jackie
 * 带有合并单元格的Excel导出功能
 */
public class ExcelExport {
    private static final Logger LOG = LoggerFactory.getLogger(ExcelExport.class);

    public void export(HttpServletResponse response) {
        /**
         * resultPath可以存放自己的业务数据，比如
         * 一级目录1,二级目录1,三级目录1,四级目录2,
         *
         * 一级目录1,二级目录1,三级目录3,
         *
         * 一级目录1,二级目录1,三级目录5,
         *
         * 一级目录1,二级目录3,
         *
         * 一级目录1,二级目录5,三级目录5,
         *
         * 一级目录2,二级目录2,三级目录2,
         *
         * 一级目录2,二级目录2,三级目录3,
         *
         * 一级目录2,二级目录4,三级目录4,
         *
         * 一级目录2,二级目录7,
         *
         * 一级目录3,二级目录6,三级目录4,
         *
         * 一级目录3,二级目录6,三级目录10,
         *
         * 一级目录4,
         *
         * 一级目录5,二级目录8,三级目录6,
         */
        List<String> resultPath = new LinkedList<>();
        LOG.info("resultPath: {}", resultPath);

        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("sheet1");
        Row titleRow=sheet.createRow(0);

        titleRow.createCell(0).setCellValue("一级");
        titleRow.createCell(1).setCellValue("二级");
        titleRow.createCell(2).setCellValue("三级");
        titleRow.createCell(3).setCellValue("四级");

        int i = 0, j;
        for (String path : resultPath) {
            i++;
            j = 0;
            Row contentRow = sheet.createRow(i);

            String[] pathArr = path.split(",");
            int length = pathArr.length;

            if (length > 0) {
                contentRow.createCell(j++).setCellValue(pathArr[0]);
            }

            if (length > 1) {
                contentRow.createCell(j++).setCellValue(pathArr[1]);
            }

            if (length > 2) {
                contentRow.createCell(j++).setCellValue(pathArr[2]);
            }

            if (length > 3) {
                contentRow.createCell(j++).setCellValue(pathArr[3]);
            }
        }

        /**
         * guardIndex初始值从1开始，0表示标题行
         * row初始值从2开始，最大值为resultPath.size()，也是从下标为0开始
         * 举例如下
         * | 标题 |
         * | aaa |
         * | bbb |
         * |     |
         * |     |
         * | ccc |
         *
         * 初识情况,guardIndex = 1, 即index=1,guardContent="aaa"
         *  row=2, 即index=2, "bbb"所在行
         */
        for (int col = 0; col < 4; col++) {
            int guardIndex = 1; // 剔除第一行标题行
            String guardContent = sheet.getRow(guardIndex) == null || sheet.getRow(guardIndex).getCell(col) == null
                    ? "" : sheet.getRow(guardIndex).getCell(col).getStringCellValue();
            int offset = 0;

            for (int row = 2; row <= resultPath.size(); row++) { // 剔除第一行标题行，不从1开始是因为guardIndex初始为1，不需要自我比较
                if (sheet.getRow(row) != null && sheet.getRow(row).getCell(col) != null) {
                    String currentContent = sheet.getRow(row).getCell(col).getStringCellValue();
                    if (StringUtils.equals(guardContent, currentContent)) {
                        offset++;
                    } else {
//                        LOG.info("row: {}, col: {}, guardIndex: {}, offset: {}", row, col, guardIndex, offset);
                        sheet.addMergedRegion(new CellRangeAddress(guardIndex,
                                guardIndex + offset, col, col));
                        guardIndex = row;
                        guardContent = sheet.getRow(guardIndex).getCell(col).getStringCellValue();  // 更新哨兵
                        offset = 0;   // 重置偏移量
                    }
                } else {
//                    LOG.info("===blank===  row: {}, col: {}, guardIndex: {}, offset: {}", row, col, guardIndex, offset);
                    /**
                     * offset > 0的情况
                     * | aaa |
                     * | aaa |
                     * |     |
                     * 第三行为空白行，所以进入此段逻辑，但是鉴于第一行和第二行没有做合并单元格操作，所以先合并单元格，在合并当前空白行单元格
                     */
                    if (offset > 0) {
                        sheet.addMergedRegion(new CellRangeAddress(guardIndex, guardIndex + offset, col, col));
                    }
                    sheet.addMergedRegion(new CellRangeAddress(row, row, col, col));
                    guardIndex = row + 1;   // row行已经合并单元格，所以guardIndex为row+1
                    ++row;  // 即跳过当前空白行，已经完成合并单元格操作
                    guardContent = sheet.getRow(guardIndex) == null || sheet.getRow(guardIndex).getCell(col) == null
                            ? "" : sheet.getRow(guardIndex).getCell(col).getStringCellValue();  // 更新哨兵
                    offset = 0;// 重置偏移量
//                    LOG.info("===blank===  guardContent: {}, row: {}, guardIndex: {}", guardContent, row, guardIndex);
                }
            }
        }

        OutputStream output = null;
        try {
            output = response.getOutputStream();
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode("xxx.xlsx", "utf-8"));
            response.setContentType("application/msexcel");
            workbook.write(output);
            output.flush();
        } catch (Exception e) {
            LOG.error("export error");
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                LOG.error("export error");
            }
        }
    }
}
