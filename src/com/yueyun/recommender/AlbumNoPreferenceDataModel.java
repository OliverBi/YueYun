package com.yueyun.recommender;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

@SuppressWarnings("serial")
public class AlbumNoPreferenceDataModel extends MySQLJDBCDataModel{

	private AlbumNoPreferenceDataModel(DataSource dataSource,
			String preferenceTable, String userIDColumn, String itemIDColumn,
			String preferenceColumn, String timestampColumn) {
		super(dataSource, preferenceTable, userIDColumn, itemIDColumn,
				preferenceColumn, timestampColumn);
	}
	
	public AlbumNoPreferenceDataModel(DataSource dataSource){
		this(dataSource, "tb_album_nopreference", "userId", "albumId", "nopreference","");
	}
}
