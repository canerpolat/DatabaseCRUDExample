package com.caner.db;

import java.sql.*;

public class Main {

	public static void main(String[] args) throws SQLException {

		OgrenciDb ogrenci = new OgrenciDb();
		Connection con = ogrenci.getConnection();

		Boolean boolInsert = ogrenci.setInsertUpdateDelete(con,
				"Insert into Ogrenci(OGR_NO,OGR_AD,OGR_SOYAD,OGR_SEHIR) values"
						+ "(2014212003,'Raymond','Kalla','Sudan')");
		Boolean boolUpdate = ogrenci.setInsertUpdateDelete(con,
				"Update Ogrenci set OGR_AD = 'Kamanan' where OGR_AD = 'Pini'");
		Boolean boolDelete = ogrenci.setInsertUpdateDelete(con, "Delete from Ogrenci where OGR_NO = 2014212006");
		String result = ogrenci.getSelectTableRows(con, "Select * from Ogrenci", 2);
		
		if (boolInsert == false) System.err.println("Hata  : Eklenemedi\n");
		if (boolUpdate == false)  System.err.println("Hata : Güncellenemedi\n");	
		if (boolDelete == false)  System.err.println("Hata : Silinemedi\n");
		
		System.out.println(result);
		
	}

}
