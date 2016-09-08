package com.tengfei.attendance.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.tengfei.attendance.sys.SysParams;
import com.tengfei.attendance.tools.Utility;
import com.tengfei.attendance.vo.ClockRecord;

/**
 * 解析excel工具
 * @author jianfei.xu
 * @date   2016年8月30日
 */
public class ParseExcelUtil {
	
	/**
	 * 解析打卡记录excel
	 * @param is		:文件流
	 * @return
	 * @throws IOException 
	 */
	public static List<ClockRecord> parseClockRecordExcel(InputStream is) throws IOException {
		if(Utility.isEmpty(is)) return null;
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		if(SysParams.ddExcelHead.equals(sheet.getRow(0).getCell(0)
				.getStringCellValue())) { //叮叮打卡记录
			return parseDDRecordExcel(sheet);
		}
		
		return parseCardRecordExcel(sheet);
	}
	
	protected static List<ClockRecord> parseDDRecordExcel(HSSFSheet sheet) {
		List<ClockRecord> clockRecordList = new LinkedList<ClockRecord>();
		Map<String, Integer> ddHeadColIndex = fillDDHeadColIndex(sheet);
		
		MergeRegion mergeRegion = null;
		for(int i = SysParams.ddExcelStartRow, rowCount = sheet.getLastRowNum(); i < rowCount; i++) {
			mergeRegion = getMergeRegion(sheet, i);
			if(null != mergeRegion) {
				for(int j = mergeRegion.startRow; j < mergeRegion.lastRow; j++) {
					
				}
				i = mergeRegion.lastRow;
				
				continue;
			}
			
			ClockRecord clockRecord = new ClockRecord();
			Row row = sheet.getRow(i);
			clockRecord.setName(row.getCell(0).getStringCellValue()); //姓名
			clockRecord.setDepartment(row.getCell(ddHeadColIndex.get("部门")).getStringCellValue()); //部门
			clockRecord.setDate(row.getCell(ddHeadColIndex.get("日期")).getStringCellValue()); //日期
			
		}
		
		return clockRecordList;
	}
	
	protected static Map<String, Integer> fillDDHeadColIndex(HSSFSheet sheet) {
		Iterator<Cell> cellIter = sheet.getRow(SysParams.ddExcelStartRow - 1).cellIterator();
		Map<String, Integer> ddHeadColIndex = new HashMap<String, Integer>() {
			private static final long serialVersionUID = 1L;

			{
//				put("姓名", 0);
				put("部门", 0);
				put("日期", 0);
				put("时间", 0);
				put("地点", 0);
			}
		};
		
		while(cellIter.hasNext()) {
			Cell cell = cellIter.next();
			if(ddHeadColIndex.containsKey(cell.getStringCellValue())) {
				ddHeadColIndex.put(cell.getStringCellValue(), cell.getColumnIndex());
			}
		}
		
		return ddHeadColIndex;
	}
	
	protected static List<ClockRecord> parseCardRecordExcel(HSSFSheet sheet) {
		List<ClockRecord> clockRecordList = new LinkedList<ClockRecord>();
		
		
		return clockRecordList;
	}
	
	protected static MergeRegion getMergeRegion(HSSFSheet sheet, int rowNum) {
		MergeRegion retVal = null;
		int sheetMergeCount = sheet.getNumMergedRegions();
		CellRangeAddress ca = null;
		
		for(int i = 0; i < sheetMergeCount; i++) {
			ca = sheet.getMergedRegion(i);
			if(ca.getFirstRow() <= rowNum && ca.getLastRow() >= rowNum) {
				retVal = new MergeRegion();
				retVal.startRow = ca.getFirstRow();
				retVal.startCol = ca.getLastColumn();
				retVal.lastRow = ca.getLastRow();
				retVal.lastCol = ca.getLastColumn();
				
				break;
			}
		}
		
		return retVal;
	}
	
	static class MergeRegion {
		int startRow;
		
		int startCol;
		
		int lastRow;
		
		int lastCol;
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ParseExcelUtil.parseClockRecordExcel(new FileInputStream(new File("F:/杭州工程签到报表20160620-20160630.xls")));
	}
	
}
