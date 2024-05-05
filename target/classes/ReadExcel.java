package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public ArrayList<Data> getData() throws IOException {
		// TODO Auto-generated method stub
			FileInputStream file=new FileInputStream("C:\\Users\\Priyanka Arora\\Desktop\\ExcelFile.xlsx");
			Workbook book=new XSSFWorkbook(file);
			Sheet sheet = book.getSheetAt(0);
			Iterator<Row>rows=sheet.iterator();
			ArrayList<Data>data=new ArrayList<Data>();
			while(rows.hasNext())
			{
				Data rowData=new Data();
				Row row=rows.next();
				Iterator<Cell>cols=row.cellIterator();
				int index=0;
				while(cols.hasNext())
				{
					Cell value=cols.next();
					if (index==0)
						rowData.setUsername(value+"");
					else
						rowData.setPassword(value+"");
					index++;
								
				}
				data.add(rowData);
				index=0;
				
			}
			return data;
		}
	


	}


