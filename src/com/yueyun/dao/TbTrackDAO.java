package com.yueyun.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * A data access object (DAO) providing persistence and search support for
 * TbTrack entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.yueyun.dao.TbTrack
 * @author MyEclipse Persistence Tools
 */

public class TbTrackDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(TbTrackDAO.class);
	// property constants
	public static final String TRACK_NAME = "trackName";
	public static final String TRACK_DURATION = "trackDuration";
	public static final String TRACK_URL = "trackUrl";
	public static final String TRACK_PLAY_COUNT = "trackPlayCount";
	public static final String TRACK_LISTENERS = "trackListeners";
	public static final String TRACK_ALBUM_ID = "trackAlbumId";

	protected void initDao() {
		// do nothing
	}

	public void save(TbTrack transientInstance) {
		log.debug("saving TbTrack instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TbTrack persistentInstance) {
		log.debug("deleting TbTrack instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TbTrack findById(java.lang.Integer id) {
		log.debug("getting TbTrack instance with id: " + id);
		try {
			TbTrack instance = (TbTrack) getHibernateTemplate().get(
					"com.yueyun.dao.TbTrack", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TbTrack instance) {
		log.debug("finding TbTrack instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TbTrack instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TbTrack as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTrackName(Object trackName) {
		return findByProperty(TRACK_NAME, trackName);
	}

	public List findByTrackDuration(Object trackDuration) {
		return findByProperty(TRACK_DURATION, trackDuration);
	}

	public List findByTrackUrl(Object trackUrl) {
		return findByProperty(TRACK_URL, trackUrl);
	}

	public List findByTrackPlayCount(Object trackPlayCount) {
		return findByProperty(TRACK_PLAY_COUNT, trackPlayCount);
	}

	public List findByTrackListeners(Object trackListeners) {
		return findByProperty(TRACK_LISTENERS, trackListeners);
	}

	public List findByTrackAlbumId(Object trackAlbumId) {
		return findByProperty(TRACK_ALBUM_ID, trackAlbumId);
	}

	public List findAll() {
		log.debug("finding all TbTrack instances");
		try {
			String queryString = "from TbTrack";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByTrackPartName(String trackPartName){
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		List trackList = session.createCriteria(TbTrack.class)
				.add(Restrictions.like(TRACK_NAME, trackPartName, MatchMode.ANYWHERE)).list();
		session.close();
		return trackList;
	}

	public TbTrack merge(TbTrack detachedInstance) {
		log.debug("merging TbTrack instance");
		try {
			TbTrack result = (TbTrack) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TbTrack instance) {
		log.debug("attaching dirty TbTrack instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TbTrack instance) {
		log.debug("attaching clean TbTrack instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TbTrackDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TbTrackDAO) ctx.getBean("TbTrackDAO");
	}
}