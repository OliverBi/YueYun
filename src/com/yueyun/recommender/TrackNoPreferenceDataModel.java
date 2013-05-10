package com.yueyun.recommender;

import javax.sql.DataSource;

import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;

@SuppressWarnings("serial")
public class TrackNoPreferenceDataModel extends MySQLJDBCDataModel{

	private TrackNoPreferenceDataModel(DataSource dataSource,
			String preferenceTable, String userIDColumn, String itemIDColumn,
			String preferenceColumn, String timestampColumn) {
		super(dataSource, preferenceTable, userIDColumn, itemIDColumn,
				preferenceColumn, timestampColumn);
	}
	public TrackNoPreferenceDataModel(DataSource dataSource){
		this(dataSource, "tb_track_nopreference", "userId", "trackId", "nopreference", "");
	}
}
