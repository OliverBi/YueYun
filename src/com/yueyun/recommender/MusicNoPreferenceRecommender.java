package com.yueyun.recommender;

import java.util.Collection;
import java.util.List;

import org.apache.mahout.cf.taste.common.Refreshable;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.IDRescorer;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class MusicNoPreferenceRecommender implements Recommender{
	public static int NEIGHBORHOOD_NUM = 4;

	private final Recommender recommender;
	
	public MusicNoPreferenceRecommender(DataModel dataModel) throws TasteException{
		DataModel model = new GenericBooleanPrefDataModel(
				GenericBooleanPrefDataModel.toDataMap(dataModel));
		
		UserSimilarity similarity = new LogLikelihoodSimilarity(model);
		
		UserNeighborhood neighborhood = new NearestNUserNeighborhood(NEIGHBORHOOD_NUM, similarity, model);
		
		recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
	}
	
	@Override
	public void refresh(Collection<Refreshable> alreadyRefreshed) {
		recommender.refresh(alreadyRefreshed);
	}

	@Override
	public float estimatePreference(long userId, long itemId) throws TasteException {
		return recommender.estimatePreference(userId, itemId);
	}

	@Override
	public DataModel getDataModel() {
		return recommender.getDataModel();
	}

	@Override
	public List<RecommendedItem> recommend(long userId, int howMany)
			throws TasteException {
		return recommender.recommend(userId, howMany);
	}

	@Override
	public List<RecommendedItem> recommend(long userId, int howMany, IDRescorer rescorer)
			throws TasteException {
		return recommender.recommend(userId, howMany, rescorer);
	}

	@Override
	public void removePreference(long userId, long itemId) throws TasteException {
		recommender.removePreference(userId, itemId);
	}

	@Override
	public void setPreference(long userId, long itemId, float preference)
			throws TasteException {
		recommender.setPreference(userId, itemId, preference);
	}

}
