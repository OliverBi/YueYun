package com.yueyun.recommender;

import java.util.List;

import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.JDBCDataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class TestRecommender {
	public static void main(String[] args) throws Exception{
		/*DataModel model = new FileDataModel(new File("data.csv"));
		
		UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
		
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);
		
		Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		
		List<RecommendedItem> recommendations = recommender.recommend(1, 1);
		
		for(RecommendedItem recommendation : recommendations){
			System.out.println(recommendation);
		}*/
		
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setServerName("localhost");
		dataSource.setPort(3306);
		dataSource.setDatabaseName("YueYun");
		dataSource.setUser("root");
		dataSource.setPassword("root");
		
		JDBCDataModel dataModel = new MySQLJDBCDataModel(dataSource,"tb_track_nopreference","userId","trackId","nopreference","");
		
		/*UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
		
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, dataModel);
		
		Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
        
        List<RecommendedItem> recommendations = recommender.recommend(1, 1);
        
        for(RecommendedItem recommendation : recommendations){
            System.out.println(recommendation);
        }*/
		
		DataModel model = new GenericBooleanPrefDataModel(
				GenericBooleanPrefDataModel.toDataMap(dataModel));
		UserSimilarity similarity = new LogLikelihoodSimilarity(dataModel);
		
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(4, similarity, dataModel);
		
		Recommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
        
        List<RecommendedItem> recommendations = recommender.recommend(1, 3);
        
        for(RecommendedItem recommendation : recommendations){
            System.out.println(recommendation);
        }
	}
}
